package com.scxh.mapper;

import com.scxh.po.Pagination;
import com.scxh.po.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 乔童
 * @Description: 标签映射器
 * @Date: 2020/02/28 22:01
 * @Version: 1.0
 */
@Mapper
@Repository
public interface TagMapper {
    boolean saveTag(Tag tag);
    List<Tag> getTagByExample(Tag tag);
    boolean updateTagById(@Param("name") String name,@Param("id") Integer id);
    boolean removeTagById(@Param("id") Integer id);
    Pagination<Tag> getTagList(@Param("limit") Integer limit,@Param("offSet") Integer offset);
    Integer countTags();
}
