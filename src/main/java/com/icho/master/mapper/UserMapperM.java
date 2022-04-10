package com.icho.master.mapper;

import com.icho.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: icho
 * @Date: 2021/9/16 20:51
 * @Describe:
 */
@Mapper
public interface UserMapperM {
    @Select("select * from t_user where id = #{id}")
    User selectByPrimaryKey(Long id);
}
