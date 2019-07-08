package com.mouse.bms.demo.test2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-08 19:16
 * @description 1 属性可以少
 * 2 两个都可以不实现序列化接口
 * 3 必须有无参数构造器
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String name;

    private Integer age;

}
