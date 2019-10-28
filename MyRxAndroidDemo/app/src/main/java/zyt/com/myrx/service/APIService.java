package zyt.com.myrx.service;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import zyt.com.myrx.base.City;
import zyt.com.myrx.model.BaseModel;

/**
 * 接口配置类
 */
public interface APIService {

    @POST("http://tg.lezhu.tv:9188/LzAppAgent/usermgt.do?act=getCityInfo")
    Call<ResponseBody> submit();

    @GET("http://tg.lezhu.tv:9188/LzAppAgent/usermgt.do?act=getCityInfo")
    Call<ResponseBody> submitGet();

    @FormUrlEncoded
    @POST("http://tg.lezhu.tv:9188/LzAppAgent/usermgt.do?act=getCityCommunityInfo")
    Call<ResponseBody> getCityCommunityInfo(@Field("data") String data, @Field("header") String header);

    @FormUrlEncoded
    @POST("http://tg.lezhu.tv:9188/LzAppAgent/usermgt.do?act=getCityCommunityInfo")
    Call<ResponseBody> getCityCommunityInfoMap(@FieldMap Map<String ,String> map);


    //{"cityName":"长沙市","sysSource":"0"}header={"clientType":"2","sign":"8bb486badadfb2d7f989547afe2c39bb","timestamp":"1542074070633","userId":"U000002820"}
    @GET("http://tg.lezhu.tv:9188/LzAppAgent/usermgt.do?act=getCityCommunityInfo")
    Call<ResponseBody> getCityCommunityInfo2(@Query("data") String data);

    @POST("https://spc.lezhu.tv:8442/LzAppAgent/usermgt.do?act=getCityInfo")
    Observable<BaseModel<  List<City> > > getStaffMsg();

}
