package zyt.com.myrx.view;

import java.util.List;

import zyt.com.myrx.base.City;
import zyt.com.myrx.model.BaseModel;

public interface ShowView extends BaseView {

    /**
     * 成功后返回数据
     * @param type 类型
     * @param model 数据模板
     */
    void onUpdateData(String type,BaseModel<List<City>> model);

}
