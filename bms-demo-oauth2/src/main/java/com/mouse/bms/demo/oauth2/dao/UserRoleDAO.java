package com.mouse.bms.demo.oauth2.dao;

import com.mouse.bms.demo.oauth2.dataobject.UserRoleDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-18 23:13
 * @description
 */
public interface UserRoleDAO {

    @Select("select * from user_role where user_id = #{userId};")
    @Results({@Result(property = "userId", column = "user_id"), @Result(property = "roleId", column = "role_id")})
    List<UserRoleDO> findByUserId(@Param("userId") Long userId);

}
