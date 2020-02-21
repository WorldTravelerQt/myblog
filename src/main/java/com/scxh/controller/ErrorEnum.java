package com.scxh.controller;

/**
 * @Author: 乔童
 * @Description: 错误枚举
 * @Date: 2020/02/21 15:20
 * @Version: 1.0
 */
public enum ErrorEnum {
    /**
     * 用于错误提示的枚举
     */
    PAGE_NOT_FOUND("页面无法找到！"),
    SYSTEM_ERROR("系统异常");
    private String message;

    ErrorEnum(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
