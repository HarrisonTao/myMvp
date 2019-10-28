package zyt.com.myrx;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import zyt.com.myrx.base.City;
import zyt.com.myrx.baseimp.BaseActivity;
import zyt.com.myrx.model.BaseModel;
import zyt.com.myrx.presenter.ShowPresenter;
import zyt.com.myrx.retrofit.APIRetrofit;
import zyt.com.myrx.view.ShowView;


public class MainActivity extends BaseActivity<ShowPresenter> implements ShowView , View.OnClickListener {


    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.submitButton)
    Button submitButton;

    String Loogr = "myrx->";


    @Override
    protected ShowPresenter createPresenter() {
        return new ShowPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }





    @OnClick(R.id.submitButton)
    public void onClick(View view) {

    presenter.getStaffMsg();

    }



    @Override
    public void onUpdateData(String type, BaseModel<List<City>> model) {

    }
}

