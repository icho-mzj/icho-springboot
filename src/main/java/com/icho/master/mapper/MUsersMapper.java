package com.icho.master.mapper;

import com.icho.bean.Menu;
import com.icho.bean.Role;
import com.icho.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: icho
 * @Date: 2022/4/13 22:06
 * @Describe:
 */
@Mapper
public interface MUsersMapper {

    @Select("select * from users where username = #{username} ")
    Users selectUserByUsername(String username);

    /**
     * 根据用户 Id 查询用户角色
     * @param userId
     * @return
     */
    @Select("SELECT r.id,r.name FROM role r INNER JOIN role_user ru ON ru.rid=r.id where ru.uid=#{userId}")
    List<Role> selectRoleByUserId(Long userId);
    /**
     * 根据用户 Id 查询菜单
     * @param userId
     * @return
     */
    @Select("SELECT m.id,m.name,m.url,m.parentid,m.permission FROM menu m INNER JOIN role_menu rm ON m.id=rm.mid INNER JOIN role r ON r.id=rm.rid INNER JOIN role_user ru ON r.id=ru.rid WHERE ru.uid=#{userId}")
    List<Menu> selectMenuByUserId(Long userId);
}
