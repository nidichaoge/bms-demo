package com.mouse.bms.demo.testa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-17 20:20
 * @description
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启方法级别的保护
public class TestSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                //无需认证
//                .antMatchers("/test","test2").permitAll()
//                //需要user角色
//                .antMatchers("/test3").hasRole("user")
//                //需要user或admin角色
//                .antMatchers("/test4").hasAnyRole("user","admin")
//                //其他请求需要认证
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .logout().permitAll();
//    }

    //==================================基于内存的方式,BCryptPasswordEncoder============================================//

    /**
     * 基于内存的方式
     * @param auth
     * @throws Exception
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("role").password(bCryptPasswordEncoder().encode("123")).roles("user")
//                .and()
//                .withUser("auth").password(bCryptPasswordEncoder().encode("123")).authorities("a")
//                .and()
//                .withUser("mouse").password(bCryptPasswordEncoder().encode("123")).roles("user").authorities("a")
//                .and()
//                .withUser("chao").password(bCryptPasswordEncoder().encode("123")).roles("admin").authorities("b");
//    }

    /**
     * 推荐使用这种加密方式
     * 此方式可在浏览器查到username password
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //==================================基于内存的方式,NoOpPasswordEncoder==============================================//

    /**
     * 基于内存的方式
     *
     * @param auth
     * @throws Exception
     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("role").password("123").roles("user")
//                .and()
//                .withUser("auth").password("123").authorities("a")
//                .and()
//                .withUser("mouse").password("123").roles("user").authorities("a")
//                .and()
//                .withUser("chao").password("123").roles("admin").authorities("b");
//    }

    /**
     * 此方式可在浏览器查到username password,使用明文传送username password
     * @return
     */
//    @Bean
//    public NoOpPasswordEncoder noOpPasswordEncoder(){
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }

}
