package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable() // h2 console screen use
                .and()
                .authorizeRequests() // URL authority
                .antMatchers("/","css/**","/images/**","/js/**","h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // authority use
                .anyRequest().authenticated() // Allow logged in user
                .and()
                .logout()
                .logoutSuccessUrl("/") // logout ->
                .and()
                .oauth2Login() // login function entry point
                .userInfoEndpoint() // User info
                .userService(customOAuth2UserService); // embodiment registration


    }
}