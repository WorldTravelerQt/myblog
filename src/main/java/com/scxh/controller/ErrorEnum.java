package com.scxh.controller;

/**
 * @Author: 乔童
 * @Description: 错误枚举
 * @Date: 2020/02/21 15:20
 * @Version: 1.0
 */
public enum ErrorEnum {
    /**
     * 页面未找到
     */
    PAGE_NOT_FOUND("页面无法找到！");
    private String message;

    ErrorEnum(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
