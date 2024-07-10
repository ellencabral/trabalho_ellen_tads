package br.edu.ifsul.cstsi.trabalho_ellen_tads.api.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true) //controle de acesso por anotação em metodos
public class SecurityConfig {
    @Autowired
    private UserDetailsServiceHttpBasic userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // desabilita proteçao contra ataques cross site request forger
                .authorizeHttpRequests(req -> { //controla autenticacao nas rotas
                    req.requestMatchers(HttpMethod.POST, "/api/v1/login").permitAll(); //exceto login
                    req.anyRequest().authenticated(); //todas rotas
                })
                .httpBasic(Customizer.withDefaults())
                .userDetailsService(userDetailsService); //autenticacao em banco de dados

        return http.build();
    }
    /* Autenticação em memória
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder.encode("user"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("USER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
    */
}
