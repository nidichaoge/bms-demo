package com.mouse.bms.demo.oauth2.dao;

import com.mouse.bms.demo.oauth2.dataobject.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-18 23:12
 * @description
 */
public interface UserDAO {

    @Select("select * from user where username = #{username} and status = 0 limit 1;")
    User findByUsername(@Param("username") String username);

    @Insert("insert into user(username, password) value(#{username},#{password})")
    Long save(@Param("username") String username,@Param("password") String password);

}
