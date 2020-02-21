package com.scxh.controller;

import com.scxh.exception.PageNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: 乔童
 * @Description: 首页控制器
 * @Date: 2020/02/21 10:59
 * @Version: 1.0
 */
@Controller
public class IndexController {
    @GetMapping({"/","/index"})
    public String index()
    {
        if(true)
        {
            throw new PageNotFoundException(ErrorEnum.PAGE_NOT_FOUND.getMessage());
        }
        return "index";
    }
}
