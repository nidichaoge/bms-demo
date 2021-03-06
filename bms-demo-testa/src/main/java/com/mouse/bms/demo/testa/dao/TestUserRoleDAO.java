package com.mouse.bms.demo.testa.dao;

import com.mouse.bms.demo.testa.dataobject.TestUserRoleDO;
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
public interface TestUserRoleDAO {

    @Select("select * from test_user_role where user_id = #{userId};")
    @Results({@Result(property = "userId",column = "user_id"),@Result(property = "roleId",column = "role_id")})
    List<TestUserRoleDO> findByUserId(@Param("userId") Long userId);

}
