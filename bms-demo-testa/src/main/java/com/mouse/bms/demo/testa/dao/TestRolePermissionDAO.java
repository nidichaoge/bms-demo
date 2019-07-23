package com.mouse.bms.demo.testa.dao;

import com.mouse.bms.demo.testa.dataobject.TestRolePermissionDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-21 22:00
 * @description
 */
public interface TestRolePermissionDAO {

    @Select("select * from test_role_permission where permission_id = #{permissionId}")
    @Results({@Result(property = "roleId",column = "role_id"),@Result(property = "permissionId",column = "permission_id")})
    List<TestRolePermissionDO> getByPermissionId(@Param("permissionId") Long permissionId);

}
