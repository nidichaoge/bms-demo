package com.mouse.bms.demo.testa.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-18 23:09
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestUserRoleDO {

    private Long id;

    private Long userId;

    private Long roleId;

}
