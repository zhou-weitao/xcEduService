package com.xuecheng.framework.model.response;

import lombok.ToString;


/**
 * @author wtzhou
 */

@ToString
public enum CommonCode implements ResultCode{
    /**
     * 操作成功
     */
    SUCCESS(true,10000,"操作成功！"),
    /**
     * 操作失败
     */
    FAIL(false,11111,"操作失败！"),
    /**
     * 未登录
     */
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统！"),
    /**
     * 无权限
     */
    UNAUTHORISE(false,10002,"权限不足，无权操作！"),
    /**
     * 内部错误
     */
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！"),

    INVALID_PARAM(false,88888,"请求参数异常");
//    private static ImmutableMap<Integer, CommonCode> codes ;

    boolean success;

    int code;

    String message;
    private CommonCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }


}
