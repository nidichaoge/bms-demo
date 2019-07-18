package com.mouse.bms.demo.testa.dao;

import com.mouse.bms.demo.testa.dataobject.TestRoleDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-18 23:14
 * @description
 */
public interface TestRoleDAO {

    @Select({"<script>select * from test_role where id in",
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach></script>"})
    List<TestRoleDO> findById(@Param("ids") List<Long> ids);
}
