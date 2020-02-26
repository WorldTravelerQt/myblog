package com.scxh.config;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
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
        hashMap.put("/admin/blogs","roles[admin]");
        hashMap.put("/admin/index","roles[admin]");
        hashMap.put("/admin/blogs-input","roles[admin]");

        factoryBean.setFilterChainDefinitionMap(hashMap);
        return factoryBean;
    }
    @Bean("webSecurityManager")
    public WebSecurityManager getWebSecurityManager(AuthorizingRealm realm)
    {
        return new DefaultWebSecurityManager(realm);
    }
    @Bean("realm")
    public AuthorizingRealm getRealm()
    {
        return new UserRealm();
    }
}
