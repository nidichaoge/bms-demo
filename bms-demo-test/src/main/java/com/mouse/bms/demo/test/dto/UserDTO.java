package com.mouse.bms.demo.test.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-08 17:28
 * @description
 */
@Data
@Builder
public class UserDTO {

    private Long id;

    private String name;

    private Integer age;

}
