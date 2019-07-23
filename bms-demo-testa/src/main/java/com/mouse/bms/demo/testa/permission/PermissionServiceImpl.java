package com.mouse.bms.demo.testa.permission;

import com.mouse.bms.demo.testa.dao.TestPermissionDAO;
import com.mouse.bms.demo.testa.dao.TestRoleDAO;
import com.mouse.bms.demo.testa.dao.TestRolePermissionDAO;
import com.mouse.bms.demo.testa.dataobject.TestPermissionDO;
import com.mouse.bms.demo.testa.dataobject.TestRoleDO;
import com.mouse.bms.demo.testa.dataobject.TestRolePermissionDO;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-22 21:16
 * @description
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    /**
     * 每一个资源所需要的角色 Collection<ConfigAttribute>决策器会用到
     */
    private static final Map<String, Collection<ConfigAttribute>> map = new HashMap<>();

    @Resource
    private TestPermissionDAO testPermissionDAO;
    @Resource
    private TestRolePermissionDAO testRolePermissionDAO;
    @Resource
    private TestRoleDAO testRoleDAO;

    @PostConstruct
    public void initPermissions() {

        Collection<ConfigAttribute> collection;
        ConfigAttribute cfg;

        List<TestPermissionDO> permissions = testPermissionDAO.findAll();

        for (TestPermissionDO permission : permissions) {
            collection = new ArrayList<>();
            List<TestRolePermissionDO> byPermissionId = testRolePermissionDAO.getByPermissionId(permission.getId());
            List<Long> list = byPermissionId.stream().map(TestRolePermissionDO::getRoleId).collect(Collectors.toList());
            List<TestRoleDO> roleDOList = testRoleDAO.findById(list);
            for (TestRoleDO r : roleDOList) {
                cfg = new SecurityConfig("ROLE_" + r.getRole());
                collection.add(cfg);
            }
            map.put(permission.getUrl(), collection);
        }
        System.out.println(map);
    }

    @Override
    public Map<String, Collection<ConfigAttribute>> getPermission() {
        return map;
    }

}
