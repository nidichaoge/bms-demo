package com.mouse.bms.demo.testa.dao;

import com.mouse.bms.demo.testa.dataobject.TestPermissionDO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-21 21:59
 * @description
 */
public interface TestPermissionDAO {

    @Select("select * from test_permission")
    @Results(@Result(property = "parentId",column = "parent_id"))
    List<TestPermissionDO> findAll();

}
