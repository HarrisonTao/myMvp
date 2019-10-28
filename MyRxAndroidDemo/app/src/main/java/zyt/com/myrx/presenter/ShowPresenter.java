package zyt.com.myrx.presenter;


import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import zyt.com.myrx.base.City;
import zyt.com.myrx.model.BaseModel;
import zyt.com.myrx.observer.BaseObserver;
import zyt.com.myrx.view.ShowView;

public class ShowPresenter  extends BasePresenter<ShowView> {
    public ShowPresenter(ShowView baseView) {
        super(baseView);
    }

    String Loogr = "myrx->";

    public void getStaffMsg() {
        apiService.getStaffMsg()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( new BaseObserver< BaseModel<  List< City > > >( baseView ){
                    @Override
                    public void onSuccess( BaseModel< List< City > > o) {
                        baseView.onUpdateData("",o);
                    }
                });

    }
}
