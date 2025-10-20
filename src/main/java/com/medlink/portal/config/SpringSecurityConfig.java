package com.medlink.portal.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SpringSecurityConfig {

//    private final CustomUserDetailsService customUserDetailsService;

    private final String[] publicUrl = {
            "/",
            "/about",
            "/contact",
            "/index/**",
            "/layout/**",
            "/register",
            "/api/**",
            "/webjars/**",
            "/resources/**",
            "/assets/**",
            "/scripts/**",
            "/content/**",
            "/css/**",
            "/summernote/**",
            "/js/**",
            "/*.css",
            "/*.js",
            "/*.js.map",
            "/fonts**", "/favicon.ico", "/resources/**", "/error"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        http.authorizeHttpRequests(authenticationProvider());
        //All requests should be authenticated
        http.authorizeHttpRequests(authorizeRequests -> {
            authorizeRequests.requestMatchers(publicUrl).permitAll();
            authorizeRequests.anyRequest().authenticated();
        });

        //If a request is not authenticated, a web page is shown
//        http.httpBasic(Customizer.withDefaults());

        //Disable CSRF -> POST. PUT
        //http.csrf().disable();
        return http.build();
    }

    /**
     * Develop custom user Authentication and Authorization
     */

    // Custom authentication provider
    // Tell spring security how to find our users and how to authenticate passwords
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//        //tell Spring Security how to retrieve the users from the database
//        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
//        return daoAuthenticationProvider;
//    }
//
//    // Custom password Encoder
//    // Tell spring security how to authenticate passwords (plain text or encrytion)
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
