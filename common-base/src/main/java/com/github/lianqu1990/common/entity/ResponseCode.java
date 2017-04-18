package com.github.lianqu1990.common.entity;

/**
 *
 */
public enum ResponseCode {
    //基础状态码
    SUCCESS(0,"数据正常"),
    FAILED(-1,"请求失败"),

    BAD_REQUEST(400,"参数有误"),
    UNAUTHORIZED(401,"用户未登录"),
    FORBIDDEN(403,"非法请求"),
    NOT_FOUND(404,"访问的地址不存在"),

    SERVER_ERROR(500,"服务器繁忙"),

    WRONG_PHONE(1001,"手机号不正确"),
    PHONE_EXIST(1002,"手机号已存在"),
    
    WRONG_CAPTCHAR(1011,"验证码不正确"),
    
    USER_NOT_EXIST(1021,"用户不存在"),
    
    WRONG_PASSWORD(1031,"密码不正确"),
    WRONG_USERNAME_OR_PASSWORD(1032,"用户名或密码不正确"),
    
    ACCOUNT_NOT_OPEN(1101,"账户未开通，请联系您的上线代理"),
    ACCOUNT_ALREAY_EXIST(1102,"账户已存在，无需重复开通"),
    AUTH_PERMISSION_DENIED(1103,"授权失败，您不具有此权限");


    private final Integer code;
    private final String info;
    private ResponseCode(Integer code, String info){
        this.code = code;
        this.info = info;
    }
    public Integer getCode() {
        return code;
    }
    public String getInfo() {
        return info;
    }
}
