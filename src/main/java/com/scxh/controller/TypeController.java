package com.scxh.controller;

import com.scxh.po.Pagination;
import com.scxh.po.Type;
import com.scxh.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 乔童
 * @Description: 分类控制器
 * @Date: 2020/02/27 15:54
 * @Version: 1.0
 */
@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @GetMapping("/types")
    public String typesPage(Model model)
    {
        Pagination<Type> page = typeService.getTypeList(1);
        model.addAttribute("page",page);
        return "/admin/types";
    }
    @GetMapping("/types/{id}")
    public String typesPage(Model model,@PathVariable Integer id)
    {
        Pagination<Type> page = typeService.getTypeList(id);
        model.addAttribute("page",page);
        return "/admin/types";
    }
    @GetMapping("/types/input")
    public String typesInputPage()
    {
        return "/admin/types-input";
    }

    @PostMapping("/types/input")
    public String saveType(Type type, Model model)
    {
        String message = validateTypeParam(type);
        if(!StringUtils.isEmpty(message))
        {
            model.addAttribute("message");
            return "/admin/types-input";
        }
        else{
            typeService.saveType(type);
        }
        return "redirect:/admin/types";
    }
    @ResponseBody
    @DeleteMapping("/types/input")
    public Object removeType(Integer id)
    {
        boolean flag = typeService.removeTypeById(id);
        //如果删除失败了，返回错误信息，如果成功了，返回的是一个空字符
        if(!flag)
        {
            return ErrorEnum.TYPE_NOT_FOUND.getMessage();
        }
        return null;
    }

    private String validateTypeParam(Type type)
    {
        //是否为空
        if(type.getName().isEmpty())
        {
            return ErrorEnum.NULL_TYPENAME.getMessage();
        }
        //名称是否重复
        if(typeService.getTypeByExample(new Type(type.getName())).size()>=1)
        {
            return ErrorEnum.REPEATED_TYPENAME.getMessage();
        }
        return "";
    }
}
