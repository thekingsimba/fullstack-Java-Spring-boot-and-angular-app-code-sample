package com.futurysoft.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.futurysoft.constant.Constant.API_V1;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (requests) -> {
                    requests
                            .requestMatchers("/" + API_V1 + "menu").authenticated()
                            .requestMatchers("/" + API_V1 + "user").permitAll();
                }
        );
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("54321")
                .authorities("admin")
                .build();

        UserDetails user =  User.withDefaultPasswordEncoder()
                .username("user")
                .password("12345")
                .authorities("user")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

}
