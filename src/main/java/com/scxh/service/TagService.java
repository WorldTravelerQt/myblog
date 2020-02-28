package com.scxh.service;

import com.scxh.po.Pagination;
import com.scxh.po.Tag;

import java.util.List;

/**
 * @Author: 乔童
 * @Description: 标签接口
 * @Date: 2020/02/28 22:18
 * @Version: 1.0
 */
public interface TagService {
    boolean saveTag(Tag tag);
    List<Tag> getTagByExample(Tag tag);
    boolean updateTagById(String name, Integer id);
    boolean removeTagById(Integer id);
    Pagination<Tag> getTagList(Integer limit,Integer offset);
}
