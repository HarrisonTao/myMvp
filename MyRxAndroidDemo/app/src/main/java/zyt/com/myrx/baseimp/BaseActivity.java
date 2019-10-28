package zyt.com.myrx.baseimp;

import android.app.Activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.ButterKnife;
import zyt.com.myrx.R;
import zyt.com.myrx.model.BaseModel;
import zyt.com.myrx.presenter.BasePresenter;
import zyt.com.myrx.view.BaseView;

/**
 * Activity 基类
 * @param <P> 逻辑控制层具体对象
 */
public abstract class BaseActivity<P extends BasePresenter> extends Activity implements BaseView {
    public Context context;
    private Dialog dialog;
    public Toast toast;
    protected P presenter;
//设置逻辑操作对象
    protected abstract P createPresenter();
//设置布局
    protected abstract int getLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        presenter = createPresenter();
        initView();
        initData();
    }

    public void initData() {
    }

    public void initView() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    /**
     * @param s
     */
    public void showtoast(String s) {
        if (toast == null) {
            toast = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG);
        }
        toast.show();
    }

    private void closeLoadingDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }


    private void showLoadingDialog() {

      if (dialog == null ) {

        dialog =new Dialog(this);

        View view = LayoutInflater.from(this).inflate(R.layout.dialog_wait, null);
        dialog.setContentView(view);
      }
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    public void showLoading() {
        showLoadingDialog();
    }


    @Override
    public void hideLoading() {
        closeLoadingDialog();
    }


    @Override
    public void showError(String msg) {
        showtoast(msg);
    }

    @Override
    public void onErrorCode(BaseModel model) {

    }

}