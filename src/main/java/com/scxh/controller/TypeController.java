package com.scxh.controller;

import com.scxh.po.Pagination;
import com.scxh.po.Type;
import com.scxh.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @PostMapping("/type/input")
    public String saveType(Type type, Model model)
    {
        if(type.getName().isEmpty())
        {
            model.addAttribute("message",ErrorEnum.NULL_TYPENAME.getMessage());
            return "/admin/types-input";
        }else{
            typeService.saveType(type);
        }
        return "redirect:/admin/types";
    }
}
