package com.scxh.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author: 乔童
 * @Description: 评论实体类
 * @Date: 2020/02/22 11:10
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long id;
    /**
     * 昵称
     */
    private String nickname;
    private String email;
    /**
     * 所属博客
     */
    private Blog blog;
    /**
     * 内容
     */
    private String content;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 上级评论
     */
    private Comment parentComment;

    /**
     * 回复的评论
     */
    private List<Comment> replayComments;

    private Date createTime;
    private Date modifiedTime;
}

