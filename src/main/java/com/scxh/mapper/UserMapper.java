package com.scxh.mapper;

import com.scxh.po.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: 乔童
 * @Description: 用户映射器
 * @Date: 2020/02/24 20:14
 * @Version: 1.0
 */
@Repository
public interface UserMapper {
    User getUserByExample(User userExample);
}
