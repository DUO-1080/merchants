package com.avondrix.merchants.ov;

public class Response {
    private Integer errorCode = 0;
    private String errorMsg = "";
    private Object data;

    public Response(Object o) {
        data = o;
    }

    public Response() {
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
