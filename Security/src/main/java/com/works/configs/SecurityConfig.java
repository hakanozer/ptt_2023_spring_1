package com.works.configs;

import com.works.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final CustomerService customerService;
    final PasswordEncoder passwordEncoder;

    // sql -> role
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerService).passwordEncoder(passwordEncoder);
    }

    // role -> Mappings
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .httpBasic()
        .and()
        .authorizeHttpRequests()
        .antMatchers("/product/**").hasRole("product")
        .antMatchers("/slider/**").hasRole("slider")
        .and()
        .formLogin().disable().csrf().disable();

    }
}

/*
ali@mail.com -> product
veli@mail.com -> slider
zehra@mail.com -> product, slider
 */
