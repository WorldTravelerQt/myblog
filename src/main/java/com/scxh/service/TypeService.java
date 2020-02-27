package com.scxh.service;

import com.scxh.po.Pagination;
import com.scxh.po.Type;

import java.util.List;

/**
 * @Author: 乔童
 * @Description: 分类接口
 * @Date: 2020/02/27 15:55
 * @Version: 1.0
 */
public interface TypeService {
    boolean saveType( Type type);
    List<Type> getTypeByExample(Type type);
    boolean updateTypeById(String name,Integer id);
    boolean removeTypeById(Integer id);
    Pagination<Type> getTypeList(Integer pageCount);
}
