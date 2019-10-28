package zyt.com.myrx.observer;

import com.google.gson.JsonParseException;

import org.json.JSONException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;
import zyt.com.myrx.model.BaseModel;
import zyt.com.myrx.view.BaseView;

public abstract   class BaseObserver<T> extends DisposableObserver<T> {
    protected BaseView view;
    /**
     * 解析数据失败
     */
    public static final int PARSE_ERROR = 1001;
    /**
     * 网络问题
     */
    public static final int BAD_NETWORK = 1002;
    /**
     * 连接错误
     */
    public static final int CONNECT_ERROR = 1003;
    /**
     * 连接超时
     */
    public static final int CONNECT_TIMEOUT = 1004;

    /**
     *
     * @param view
     */
    public BaseObserver(BaseView view) {
        this.view = view;
    }

    @Override
    protected void onStart() {
        if (view != null) {
            view.showLoading();
        }
    }

    @Override
    public void onNext(T o) {
        try {
            BaseModel model = (BaseModel) o;

                onSuccess(o);

        } catch (Exception e) {
            e.printStackTrace();
            view.showError(e.toString());
        }


    }

    @Override
    public void onError(Throwable e) {
        if (view != null) {
            view.hideLoading();
        }
        if (e instanceof HttpException) {
            //   HTTP错误
            onException(BAD_NETWORK);
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {
            //   连接错误
            onException(CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {
            //  连接超时
            onException(CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            //  解析错误
            onException(PARSE_ERROR);
        } else {
            if (e != null) {
                view.showError(e.toString());
            } else {
                view.showError("未知错误");
            }
        }

    }

    private void onException(int unknownError) {
        switch (unknownError) {
            case CONNECT_ERROR:
                view.showError("连接错误");
                break;

            case CONNECT_TIMEOUT:
                view.showError("连接超时");
                break;

            case BAD_NETWORK:
                view.showError("网络问题");
                break;

            case PARSE_ERROR:
                view.showError("解析数据失败");
                break;

            default:
                break;
        }
    }


    @Override
    public void onComplete() {
        if (view != null) {
            view.hideLoading();
        }

    }

    public abstract void onSuccess(T o);


}