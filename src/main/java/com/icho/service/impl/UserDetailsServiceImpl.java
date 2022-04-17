package com.icho.service.impl;

import com.icho.bean.Menu;
import com.icho.bean.Role;
import com.icho.bean.Users;
import com.icho.master.mapper.MUsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: icho
 * @Date: 2022/4/12 23:18
 * @Describe: SpringSecurity实现数据库认证完成用户登录
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MUsersMapper mUsersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1.查询后直接返回,可在实体类中实现UserDetails
        // 2.
        Users user = mUsersMapper.selectUserByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 权限集合
        List<GrantedAuthority> list = new ArrayList<>();
        List<Menu> menus = mUsersMapper.selectMenuByUserId(Long.valueOf(user.getId()));
        List<Role> roles = mUsersMapper.selectRoleByUserId(Long.valueOf(user.getId()));
        // 权限处理
        menus.forEach(e -> list.add(new SimpleGrantedAuthority(e.getPermission())));
        // 处理角色
        roles.forEach(e -> list.add(new SimpleGrantedAuthority(e.getName())));

        //List<GrantedAuthority> list = AuthorityUtils.commaSeparatedStringToAuthorityList("admin"); // 角色支持多个role
        //return new User(user.getUsername(),new BCryptPasswordEncoder().encode(user.getPassword()),list);
        return new User(user.getUsername(),user.getPassword(),list);
    }

    public static void main(String[] args) {
        String s = new BCryptPasswordEncoder().encode("123");
        System.out.println("s = " + s);
    }
}
