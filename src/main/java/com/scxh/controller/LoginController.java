package com.scxh.controller;

import com.alibaba.fastjson.JSON;
import com.scxh.po.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @Author: 乔童
 * @Description: 登录控制器
 * @Date: 2020/02/24 21:02
 * @Version: 1.0
 */
@Controller
public class LoginController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @GetMapping("/admin/login")
    public String loginPage()
    {
        return "admin/login";
    }
    @GetMapping("/admin/login/{message}")
    public String loginPage(@ModelAttribute @PathVariable String message)
    {
        return "admin/login";
    }

    @ResponseBody
    @PostMapping(value = "/admin/login",produces = "application/json;charset=utf-8")
    public String doLogin(
            @RequestBody User userInfo,
            HttpSession session)
    {
        String username= userInfo.getUsername();
        String password= userInfo.getPassword();
        HashMap<String,String> map=new HashMap<>();
        //验证信息
        boolean validate=true;
        //是否已登录校验
        if (session.getAttribute("user")!=null) {
            logger.debug("登录失败！原因：{}",ErrorEnum.REPEATED_LOGIN.getMessage());
            validate=false;
        }
        //非空校验
        if(StringUtils.isEmpty(username.trim())||StringUtils.isEmpty(password.trim()))
        {
            logger.debug("登录失败！原因：{}",ErrorEnum.NULL_USERNAME_PASSWORD.getMessage());
            validate=false;
        }
        //经过前两项验证再进行登录认证
        if(validate)
        {
            //进行登录认证
            Subject subject= SecurityUtils.getSubject();
            try {
                subject.login(new UsernamePasswordToken(username,password));
                User user = (User) subject.getPrincipal();
                //保护用户密码所以把它设为空，不能把密码存到session里
                user.setPassword("");
                session.setAttribute("user",user);
                map.put("url","/admin/index");
                return JSON.toJSONString(map);
            }catch (UnknownAccountException e)
            {
                logger.debug("登录失败！原因：{}",e.toString());
                map.put("message",ErrorEnum.USERNAME_ERROR.getMessage());
            }catch (IncorrectCredentialsException e)
            {
                logger.debug("登录失败！原因：{}",e.toString());
                map.put("message",ErrorEnum.PASSWORD_ERROR.getMessage());
            }
            catch (AuthenticationException e) {
                logger.debug("登录失败！原因：{}",e.toString());
                map.put("message",ErrorEnum.SYSTEM_ERROR.getMessage());
            }
        }
        map.put("url","/admin/login");
        return JSON.toJSONString(map);
    }

    @GetMapping("/admin/logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute("user");
        return "index";
    }

    @GetMapping("/admin/index")
    public String adminIndexPage()
    {
        return "/admin/index";
    }
}
