package com.mouse.bms.demo.testa.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-21 22:08
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestPermissionDO {

    private Long id;

    private String permission;

    private String url;

    private String description;

    private Long parentId;

}
