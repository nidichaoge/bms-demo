package com.mouse.bms.demo.oauth2.dao;

import com.mouse.bms.demo.oauth2.dataobject.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-18 23:14
 * @description
 */
public interface RoleDAO {

    @Select({"<script>select * from role where id in",
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach></script>"})
    List<Role> findById(@Param("ids") List<Long> ids);

}
