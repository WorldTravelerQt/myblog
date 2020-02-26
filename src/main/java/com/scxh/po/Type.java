package com.scxh.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: 乔童
 * @Description: 类型实体类
 * @Date: 2020/02/22 11:13
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    /**
     * 主键
     **/
    private int id;
    /**
     * 分类名
     **/
    private String name;
    /**
     * 分类的所属博客
     **/
    private List<Blog> blogs;
}
