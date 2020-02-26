package com.scxh.service;

import com.scxh.po.User;

/**
 * @Author: 乔童
 * @Description: 用户接口
 * @Date: 2020/02/24 20:29
 * @Version: 1.0
 */
public interface UserService {

    User getUserByExample(User userExample);
}
