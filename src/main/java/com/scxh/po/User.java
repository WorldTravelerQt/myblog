package com.scxh.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author: 乔童
 * @Description: 用户实体类
 * @Date: 2020/02/22 11:12
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;

    private String nickname;

    private String username;

    private String password;

    private String email;
    /**
     * 权限
     **/
    private String role;
    /**
     * 头像
     **/
    private String avatar;
    /**
     * 发布的博客
     **/
    private List<Blog> blogs;

    private Date createTime;

    private Date modifiedTime;

    public User(String username) {
        this.username=username;
    }
}
