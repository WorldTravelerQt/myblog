package com.scxh.mapper;

import com.scxh.po.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 乔童
 * @Description: 分类映射器
 * @Date: 2020/02/27 16:00
 * @Version: 1.0
 */
@Mapper
@Repository
public interface TypeMapper {
    boolean saveType(Type type);
    List<Type> getTypeByExample(Type type);
    boolean updateTypeById(@Param("name") String name,@Param("id") Integer id);
    boolean removeTypeById(@Param("id") Integer id);
    /**
     * 获取分类页数据
     * @param offSet
     * @param pageSize
     * @return
     */
    List<Type> getTypeList(@Param("offSet") Integer offSet, @Param("limit") Integer pageSize);
    Integer countTypes();
}
