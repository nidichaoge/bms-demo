package com.mouse.bms.demo.testa.permission;

import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.Map;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-22 21:15
 * @description
 */
public interface PermissionService {

    /**
     * 查询所有的权限
     * @return
     */
    Map<String, Collection<ConfigAttribute>> getPermission();

}
