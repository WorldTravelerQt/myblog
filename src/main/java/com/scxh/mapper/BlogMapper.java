package com.scxh.mapper;

import com.scxh.po.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 乔童
 * @Description: 博客映射器
 * @Date: 2020/02/24 19:23
 * @Version: 1.0
 */
@Repository
public interface BlogMapper {
    List<Blog> getAll();
}
