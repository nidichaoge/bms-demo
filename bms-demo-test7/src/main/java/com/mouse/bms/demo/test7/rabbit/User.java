package com.mouse.bms.demo.test7.rabbit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-10 23:28
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 946453003520303955L;
    private String name;

    private int age;

}
