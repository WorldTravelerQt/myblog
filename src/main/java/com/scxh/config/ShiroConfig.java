package com.scxh.config;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @Author: 乔童
 * @Description: shiro配置类
 * @Date: 2020/02/25 09:38
 * @Version: 1.0
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(WebSecurityManager webSecurityManager)
    {
        ShiroFilterFactoryBean factoryBean=new ShiroFilterFactoryBean();
        //设置安全管理器
        factoryBean.setSecurityManager(webSecurityManager);
        factoryBean.setLoginUrl("/admin/login");

        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        //设置拦截所有访问admin目录下资源的请求，必须拥有admin角色权限才可访问
        hashMap.put("/admin/index","roles[admin]");
        hashMap.put("/admin/blogs","roles[admin]");
        hashMap.put("/admin/blogs-input","roles[admin]");
        hashMap.put("/admin/types","roles[admin]");
        hashMap.put("/admin/types-input","roles[admin]");
        hashMap.put("/admin/tags","roles[admin]");
        hashMap.put("/admin/tags-input","roles[admin]");


        factoryBean.setFilterChainDefinitionMap(hashMap);
        return factoryBean;
    }
    @Bean("webSecurityManager")
    public WebSecurityManager getWebSecurityManager(AuthorizingRealm realm,CookieRememberMeManager rememberMeManager)
    {
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager(realm);
        webSecurityManager.setRememberMeManager(rememberMeManager);
        return webSecurityManager;
    }
    @Bean
    public CookieRememberMeManager getCookieRememberMeManager(SimpleCookie simpleCookie)
    {
        CookieRememberMeManager cookieManager = new CookieRememberMeManager();
        cookieManager.setCookie(simpleCookie);
        return cookieManager;
    }
    @Bean
    public SimpleCookie getSimpleCookie()
    {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //如果设置HttpOnly为true，则不会暴露客户端脚本，防止恶意攻击
        simpleCookie.setHttpOnly(true);
        //设置最大生存时间，单位是秒
        simpleCookie.setMaxAge(60*60*24);
        return simpleCookie;
    }
    @Bean("realm")
    public AuthorizingRealm getRealm()
    {
        return new UserRealm();
    }
}
