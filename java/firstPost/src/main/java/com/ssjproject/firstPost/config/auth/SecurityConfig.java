package com.ssjproject.firstPost.config.auth;

import com.ssjproject.firstPost.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    // spring boot 5.7 이상 부터 WebSecurityConfigurerAdapter 를 더이상 지원 하지 않고 있다
    // SecurityFilterChain, WebSecurityCustomizer 를 상황에 따라 빈으로 등록해 사용한다.
    private final CustomOauth2UserService customOauth2UserService;
    private final OAuth2SuccessHandler successHandler;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests().antMatchers("/", "/css/**", "/images/**",
                        "/js**", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.GUEST.name()).anyRequest().authenticated()
                .and().logout().logoutSuccessUrl("/")
                .and().oauth2Login().userInfoEndpoint().userService(customOauth2UserService)
                .and().successHandler(successHandler)
                .and()
                .build();

    }
}
