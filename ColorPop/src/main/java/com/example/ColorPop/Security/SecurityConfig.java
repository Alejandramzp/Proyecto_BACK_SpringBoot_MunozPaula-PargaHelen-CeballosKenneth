package com.example.ColorPop.Security;

import com.example.ColorPop.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private UsuarioService usuarioService;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Nueva forma de deshabilitar CSRF en Spring Security 6.1+
                .authorizeHttpRequests(auth -> auth
                        // === Acceso público ===
                        .requestMatchers("/api/login").permitAll()  // Cualquier usuario puede acceder al login
                        .requestMatchers("/api/ventas/").hasAuthority("Cajero") // Cajero solo puede registrar ventas
                        .requestMatchers("/api/inventarios/").hasAuthority("Gerente") // Gerente gestiona inventarios y reportes
                        .requestMatchers("/api/empleados/").hasAuthority("Administrador") // Admin gestiona empleados

                        .anyRequest().authenticated() // Otras rutas requieren autenticación
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // Sin estado (stateless)

        // Añadir el filtro JWT antes del filtro de autenticación de usuario
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usar BCrypt para cifrar contraseñas
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}