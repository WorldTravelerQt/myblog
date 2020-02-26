package com.scxh.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author: 乔童
 * @Description: 博客实体类
 * @Date: 2020/02/22 11:08
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private Long id;
    /**
     * 标题
     **/
    private String title;
    /**
     * 首图
     **/
    private String firstPicture;
    /**
     * 内容
     **/
    private String content;
    /**
     * 浏览次数
     **/
    private Integer views;
    /**
     * 标记
     **/
    private String flag;
    /**
     * 赞赏开启
     **/
    private boolean commendable;
    /**
     * 转载开启
     **/
    private boolean shareStatement;
    /**
     * 评论开启
     **/
    private boolean allowComment;
    /**
     * 是否发布
     **/
    private boolean published;
    /**
     * 是否推荐
     **/
    private boolean recommend;
    /**
     * 所包含的标签
     **/
    private List<Tag> tags;
    /**
     * 所属分类
     **/
    private Type type;
    /**
     * 所属评论
     */
    private List<Comment> comments;
    /**
     * 所属用户
     **/
    private User user;
    private Date createDate;
    private Date modifiedDate;
}
