package com.scxh.controller;

/**
 * @Author: 乔童
 * @Description: 错误枚举
 * @Date: 2020/02/21 15:20
 * @Version: 1.0
 */
public enum ErrorEnum {
    /**
     * 登录错误信息
     */
    PAGE_NOT_FOUND("页面无法找到！"),
    SYSTEM_ERROR("系统异常，稍后再试！"),
    USERNAME_ERROR("不存在的用户名！"),
    PASSWORD_ERROR("密码错误，请重新输入！"),
    NULL_USERNAME_PASSWORD("用户名或密码不能为空！"),
    REPEATED_LOGIN("不要进行重复登录！"),
    /**
     * 分类错误信息
     */
    TYPE_NOT_FOUND("不存在该分类！"),
    NULL_TYPENAME("分类名称不能为空！"),
    REPEATED_TYPENAME("分类名称不能重复！"),
    /**
     * 标签错误信息
     */
    TAG_NOT_FOUND("不存在该标签！"),
    NULL_TAGNAME("标签名称不能为空！"),
    REPEATED_TAGNAME("标签名称不能重复！")
    ;
    private String message;

    ErrorEnum(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
