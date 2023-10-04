package com.example.corsmaxuploadsize;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig implements WebMvcConfigurer {

  @Value("${security.cors-origin:}")
  private String allowedOrigin;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http,  HandlerMappingIntrospector introspector)
      throws Exception {
//    return http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
//        .authorizeHttpRequests(authCustomizer -> authCustomizer.requestMatchers(new MvcRequestMatcher(introspector, "/actuator/**")).permitAll())
//        .authorizeHttpRequests(authCustomizer -> authCustomizer.requestMatchers(new MvcRequestMatcher(introspector, "/integration/**")).permitAll())
//        .authorizeHttpRequests(authCustomizer -> authCustomizer.anyRequest().authenticated())
//        .sessionManagement(sessionCustomizer -> sessionCustomizer.sessionCreationPolicy(
//            SessionCreationPolicy.STATELESS))
//        .build();

    return http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
        .build();

  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins(allowedOrigin)
       // .allowCredentials(true)
    ;
  }

}
