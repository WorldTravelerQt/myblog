package com.scxh.service.impl;

import com.scxh.mapper.UserMapper;
import com.scxh.po.User;
import com.scxh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 乔童
 * @Description: 用户业务实现类
 * @Date: 2020/02/24 20:33
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUserByExample(User userExample) {
        return userMapper.getUserByExample(userExample);
    }
}
