package zyt.com.myrx.model;

import java.io.Serializable;

import zyt.com.myrx.base.HeaderBean;

/**
 * 数据类型模板
 * @param <T> 具体数据类型
 */
public class BaseModel<T> implements Serializable {

    //数据类型
    private T data;
    //网络协议 状态类
    private HeaderBean header;


    public T getResult() {
        return data;
    }

    public void setResult(T result) {
        this.data = result;
    }

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }
}
