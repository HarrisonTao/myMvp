package zyt.com.myrx.view;

import zyt.com.myrx.model.BaseModel;

public interface BaseView {

    /**
     * 显示dialog
     */
    void showLoading();

    /**
     * 隐藏 dialog
     */

    void hideLoading();

    /**
     * 显示错误信息
     *
     * @param msg
     */
    void showError(String msg);

    /**
     * 错误码
     */
    void onErrorCode(BaseModel model);



}
