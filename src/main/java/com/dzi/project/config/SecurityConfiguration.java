package com.dzi.project.config;

import com.dzi.project.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final UserService userService;

    public SecurityConfiguration(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .userDetailsService(userService)
                .csrf(AbstractHttpConfigurer::disable
                )
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/css/*.css", "/js/*.js", "/images/*.png", "/images/*.jpg").permitAll()
                        .requestMatchers("/about").permitAll()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/register").anonymous()
                        .requestMatchers("/users/*").hasAuthority("admin")
                        .requestMatchers("/companies/*").hasAuthority("admin")
                        .requestMatchers("/ingredients/*").hasAuthority("admin")
                        .anyRequest().authenticated()
                ).headers(AbstractHttpConfigurer::disable)
                .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/").permitAll())
                .httpBasic(withDefaults());
        return http.build();
    }
}
