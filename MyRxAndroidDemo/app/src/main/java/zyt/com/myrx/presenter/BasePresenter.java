package zyt.com.myrx.presenter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import zyt.com.myrx.model.BaseModel;
import zyt.com.myrx.observer.BaseObserver;
import zyt.com.myrx.retrofit.APIRetrofit;
import zyt.com.myrx.service.APIService;
import zyt.com.myrx.view.BaseView;

/**
 * 逻辑控制基类
 * @param <V> 视图类 用于绑定
 */
public class BasePresenter<V extends BaseView> {

    private CompositeDisposable compositeDisposable;


    public V baseView;

    protected APIService apiService= APIRetrofit.getInstance().getApiService();

    public BasePresenter(V baseView) {
        this.baseView = baseView;
    }


    /**
     * 解除绑定
     */
    public void detachView() {
        baseView = null;
        removeDisposable();
    }



    /**
     * 返回 view
     *
     * @return
     */
    public V getBaseView() {
        return baseView;
    }


    public void addDisposable(Observable<?> observable, BaseObserver observer) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer));


    }

    public void removeDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

}
