package com.soaic.hellospringboot.common;

public class ResponseResult<T> {

    private String msg;
    private Integer code;
    private T data;

    public ResponseResult() {}

    public ResponseResult(Integer code, String msg, T data) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseResult<?> that = (ResponseResult<?>) o;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (msg != null ? !msg.equals(that.msg) : that.msg != null) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }


    @Override
    public String toString() {
        return "ResponseResult{" +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
