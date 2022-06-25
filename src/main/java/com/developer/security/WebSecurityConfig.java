package com.developer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig
        extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService userDetailsService() {
        return new SpringSecurityUserDetails();
    };

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/css/**").permitAll()
            .antMatchers("/image/**").permitAll()
            .antMatchers("/js/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/product/**").permitAll()
                .antMatchers("/salesdetails/**").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/identity/login")
            .defaultSuccessUrl("/identity/dashboard", true)
            .permitAll()
            .and()
                .exceptionHandling().accessDeniedPage("/identity/404page")
                .and()
        .logout()
            .permitAll();
//            .logoutUrl("/identity/logout")
//            .logoutSuccessUrl("/identity/login");
    }
}
