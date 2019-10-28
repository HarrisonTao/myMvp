package zyt.com.myrx.retrofit;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zyt.com.myrx.service.APIService;

/**
 * 网络请求封装
 */
public class APIRetrofit {
    public final String BASE_SERVER_URL = "https://wawa-api.vchangyi.com/";
    //设置请求对象
    private static APIRetrofit apiRetrofit;

    private Retrofit retrofit;

    private OkHttpClient client;

    private APIService apiServer;

    /**
     * 初始化Retrofit
     */
    public APIRetrofit() {
        /**
         * 输出请求日志
         */
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger()
        {
            @Override
            public void log(String message)
            {
                Log.d("Http--->", message+"");
            }
        });
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BASIC);
        client = new OkHttpClient.Builder()
                //添加log拦截器
                .addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
              //  .readTimeout(10, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_SERVER_URL)
                //解析类
                .addConverterFactory(GsonConverterFactory.create())
                //支持RXJAVA2 工厂
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //支持RxJava2
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        apiServer = retrofit.create(APIService.class);
    }


    public static APIRetrofit getInstance() {
        if (apiRetrofit == null) {
            synchronized (Object.class) {
                if (apiRetrofit == null) {
                    apiRetrofit = new APIRetrofit();
                }
            }
        }
        return apiRetrofit;
    }

    public APIService getApiService() {
        return apiServer;
    }
}
