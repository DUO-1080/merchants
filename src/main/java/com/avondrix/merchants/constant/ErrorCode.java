package com.avondrix.merchants.constant;

public enum  ErrorCode {
    SUCCESS(0,""),
    DUPLICATE_NAME(1,"商户名重复"),
    EMPTY_LOGO(2,"logo 为空"),
    EMPTY_BUSINESS_LICENSE(3,"营业执照为空"),
    ERROR_PHONE(4,"联系电话错误"),
    EMPTY_ADDRESS(5,"地址为空"),
    EMPTY_NAME(7,"商户名为空"),
    MERCHANTS_NOT_EXIST(6,"商户不存在");

    private Integer code;
    private String desc;

    ErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
