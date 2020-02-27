package com.scxh.service.impl;

import com.scxh.controller.ErrorEnum;
import com.scxh.mapper.TypeMapper;
import com.scxh.po.Pagination;
import com.scxh.po.Type;
import com.scxh.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: 乔童
 * @Description:
 * @Date: 2020/02/27 16:00
 * @Version: 1.0
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;


    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public boolean saveType(Type type) {
        return typeMapper.saveType(type);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public List<Type> getTypeByExample(Type type) {
        return typeMapper.getTypeByExample(type);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public boolean updateTypeById(String name, Integer id) {
        boolean flag = typeMapper.updateTypeById(name, id);
        if (!flag)
        {
            throw new RuntimeException(ErrorEnum.TYPE_NOT_FOUND.getMessage());
        }
        return flag;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public boolean removeTypeById(Integer id) {
        boolean flag = typeMapper.removeTypeById(id);
        if(!flag)
        {
            throw new RuntimeException(ErrorEnum.TYPE_NOT_FOUND.getMessage());
        }
        return flag;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public Pagination<Type> getTypeList(Integer pageCount) {
        Pagination<Type> typePagination = new Pagination<>();
        typePagination.setPagination(pageCount,typeMapper.typeCount());
        //设置offset：offset=当前页-1*每页显示数
        int offset=(typePagination.getCurrCount()-1)*typePagination.getPageSize();
        //进行分页查询
        List<Type> typeList = typeMapper.getTypeList(offset, typePagination.getPageSize());
        typePagination.setElements(typeList);
        return typePagination;
    }
}
