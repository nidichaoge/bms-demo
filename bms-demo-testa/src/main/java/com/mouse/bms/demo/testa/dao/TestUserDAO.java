package com.mouse.bms.demo.testa.dao;

import com.mouse.bms.demo.testa.dataobject.TestUserDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-18 23:12
 * @description
 */
public interface TestUserDAO {

    @Select("select * from test_user where username = #{username} and status = 0 limit 1;")
    TestUserDO findByUsername(@Param("username") String username);

}
