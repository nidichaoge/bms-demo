package com.mouse.bms.demo.testa.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-21 22:09
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestRolePermissionDO {

    private Long id;

    private Long roleId;

    private Long permissionId;

}
