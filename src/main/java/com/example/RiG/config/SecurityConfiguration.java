//package com.example.RiG.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.catalina.startup.WebAnnotationSet;
//import org.springframework.beans.BeanInstantiationException;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Slf4j
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/h2-console/**");
//    }
//
//
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .antMatchers("/h2-console/**").permitAll()
////                .antMatchers("/", "/home").permitAll()
////                .anyRequest().authenticated();
////        http.headers().frameOptions().sameOrigin();
////    }
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////
////            http.authorizeHttpRequests((requests) -> requests
////                .antMatchers("/", "/home").permitAll()
////                .antMatchers("/h2-console/**").permitAll()
////                .anyRequest().authenticated()).formLogin((form) -> form
////                    .loginPage("/login")
////                    .permitAll())
////                    .logout((logout) -> logout.permitAll());
////            return http.build();
////
////    }
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        UserDetails user =
////                User.withDefaultPasswordEncoder()
////                        .username("getir")
////                        .password("getir")
////                        .roles("USER")
////                        .build();
////
////        return new InMemoryUserDetailsManager(user);
////    }
//
//}