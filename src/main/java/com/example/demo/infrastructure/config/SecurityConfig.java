package com.example.demo.infrastructure.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Desabilita CSRF usando nova API
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // Permite acesso ao H2 Console
                        .anyRequest().authenticated() // Requer autenticação para outros endpoints
                )
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())) // Permite exibição do H2 Console
                .formLogin(form -> form.defaultSuccessUrl("/h2-console", true)) // Configura login padrão e redireciona para o H2 Console
                .httpBasic(h -> {}); // Configura autenticação HTTP Basic
        return http.build();
    }
}
