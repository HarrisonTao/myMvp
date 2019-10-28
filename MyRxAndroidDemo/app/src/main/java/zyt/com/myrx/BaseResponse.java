package zyt.com.myrx;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BaseResponse {

    private HeaderBean header;
    @SerializedName("data")
    private Object data;

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static class HeaderBean {
        /**
         * code : 0000
         * message : 操作成功
         */
        private String code;

        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

    public static class DataBean {
        /**
         * cityName : 百色市
         * cityCode : 451000
         * py : B
         */

        private String cityName;

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }
    }
}
