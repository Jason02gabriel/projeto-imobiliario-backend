package br.com.veneza.imoveis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Indica que esta é uma classe de configuração do Spring
@EnableWebSecurity // Habilita a segurança web do Spring nesta classe
public class SecurityConfig {

    @Bean // @Bean expõe o retorno deste método como um "Bean" gerenciável pelo Spring
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // Desabilitando a proteção CSRF, pois nossa API será 'stateless' (sem estado)
                .csrf(AbstractHttpConfigurer::disable)
                // Definindo a política de gerenciamento de sessão como 'stateless'
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Configurando as regras de autorização para as requisições HTTP
                .authorizeHttpRequests(authorize -> authorize
                        // Permite que requisições POST para "/api/usuarios" sejam feitas sem autenticação
                        .requestMatchers(HttpMethod.POST, "/api/usuarios").permitAll()
                        // Para todas as outras requisições, a autenticação é necessária
                        .requestMatchers("/api/clientes/**").permitAll()
                        .requestMatchers("/api/imoveis/**").permitAll()
                        .requestMatchers("/api/contratos/**").permitAll()
                        .requestMatchers("/api/recibos/**").permitAll()
                        .requestMatchers("/api/financeiro/**").permitAll()
                        .anyRequest().authenticated()

                )
                .build();
    }

    // Adicionamos também um Bean para criptografar senhas. Vamos usá-lo em breve.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}