package com.scxh.service.impl;

import com.scxh.mapper.TagMapper;
import com.scxh.po.Pagination;
import com.scxh.po.Tag;
import com.scxh.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 乔童
 * @Description:
 * @Date: 2020/02/28 22:20
 * @Version: 1.0
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public boolean saveTag(Tag tag) {
        return tagMapper.saveTag(tag);
    }

    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public List<Tag> getTagByExample(Tag tag) {
        return tagMapper.getTagByExample(tag);
    }

    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public boolean updateTagById(String name, Integer id) {
        return tagMapper.updateTagById(name,id);
    }

    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public boolean removeTagById(Integer id) {
        return tagMapper.removeTagById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public Pagination<Tag> getTagList(Integer limit, Integer offset) {
        return tagMapper.getTagList(limit,offset);
    }
}
