package com.scxh.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: 乔童
 * @Description: 标签实体类
 * @Date: 2020/02/22 11:14
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    /**
     * 主键
     **/
    private Long id;
    /**
     * 标签名
     **/
    private String name;
    /**
     * 标签所属博客
     **/
    private List<Blog> blogs;
}
