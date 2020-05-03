package com.hq.simpleblog.security;

import com.hq.simpleblog.entity.UserEntity;
import com.hq.simpleblog.service.RoleService;
import com.hq.simpleblog.service.RoleUserService;
import com.hq.simpleblog.service.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * spring security UserDetailsService 实现类
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/22 21:16
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleUserService roleUserService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (StringUtils.isBlank(email)) {
            throw new BadCredentialsException("邮箱不能为空");
        }

        // 查询用户信息
        UserEntity userEntity = userService.getByEmail(email);
        if (userEntity == null) {
            throw new BadCredentialsException("邮箱或密码错误");
        }

        if (userEntity.getLock()) {
            throw new LockedException("账号被锁定");
        }

        // 获取用户拥有的角色
        List<String> roleNames = new ArrayList<>();
        List<Long> roleIds = roleUserService.getRoleIdsByUserId(userEntity.getUserId());
        if (CollectionUtils.isNotEmpty(roleIds)) {
            // 根据角色id集合获取角色名称集合
            roleNames = roleService.getRoleNamesByRoleIds(roleIds);
        }

        // 添加用户权限
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String roleName : roleNames) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + roleName);
            grantedAuthorities.add(simpleGrantedAuthority);
        }

        // 返回登录用户信息
        return new User(userEntity.getEmail(), userEntity.getPassword(), true, true, true, !userEntity.getLock(), grantedAuthorities);
    }

}
