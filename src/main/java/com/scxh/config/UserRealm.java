package com.scxh.config;

import com.scxh.po.User;
import com.scxh.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: 乔童
 * @Description: 用户Realm
 * @Date: 2020/02/25 09:46
 * @Version: 1.0
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();

        User user= (User) principalCollection.getPrimaryPrincipal();
        //获取用户角色
        String role = user.getRole();
        if(!StringUtils.isEmpty(role))
        {
            //用户角色授权
            authorizationInfo.addRole(role);
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String username=token.getUsername();

        if(StringUtils.isEmpty(username))
        {
            return null;
        }
        //根据用户名从数据库中查找用户
        User user = userService.getUserByExample(new User(username));
        if(user==null)
        {
            return null;
        }
        //shiro会根据返回的SimpleAuthentication对象参数中的密码和token密码对比，如果匹配就通过认证
        return new SimpleAuthenticationInfo(user,user.getPassword(),"userRealm");
    }
}
