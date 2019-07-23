package com.mouse.bms.demo.oauth2.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-20 15:23
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = -6325314636884693609L;

    private Long id;

    private String role;

    private String description;

    @Override
    public String getAuthority() {
        return role;
    }

}
