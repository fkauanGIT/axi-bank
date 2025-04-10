package com.app.axibank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http, Environment env) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Desabilitando CSRF para APIs REST
                .formLogin(formLogin -> formLogin.disable())  // Desabilitando o login com formulário
                .httpBasic(httpBasic -> httpBasic.disable())  // Desabilitando autenticação básica
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))  // Configuração CORS
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/customers/login", "/customers/register").permitAll()  // Permitindo acesso livre aos endpoints de login e cadastro
                        .anyRequest().authenticated()  // Requer autenticação para todas as outras requisições
                );
        return http.build();  // Retorna a configuração do SecurityFilterChain
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Usando o encoder delegando para o default encoder
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        // Verificando se a senha foi comprometida
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        // Configuração CORS com permissões adequadas
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:3000");  // Permite todas as origens
        configuration.addAllowedMethod("GET");  // Permite métodos GET
        configuration.addAllowedMethod("POST");  // Permite métodos POST
        configuration.addAllowedMethod("PUT");  // Permite métodos PUT
        configuration.addAllowedMethod("DELETE");  // Permite métodos DELETE
        configuration.addAllowedMethod("PATCH");  // Permite métodos PATCH (adicionado)
        configuration.addAllowedMethod("OPTIONS");  // Permite métodos OPTIONS (adicionado)
        configuration.addAllowedHeader("*");  // Permite todos os cabeçalhos
        configuration.setAllowCredentials(true);  // Permite envio de cookies e headers de autenticação
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
