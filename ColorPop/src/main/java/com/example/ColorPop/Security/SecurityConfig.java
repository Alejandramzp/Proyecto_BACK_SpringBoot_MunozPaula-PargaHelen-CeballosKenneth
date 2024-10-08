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

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Nueva forma de deshabilitar CSRF en Spring Security 6.1+
                .authorizeHttpRequests(auth -> auth
                        // === Acceso público ===
                        .requestMatchers("/api/login").permitAll()  // Cualquier usuario puede acceder al login

                        // === Permisos para /api/ventas ===
                        .requestMatchers("GET", "/api/ventas").hasAnyRole("CAJERO", "GERENTE", "ADMIN")
                        .requestMatchers("POST", "/api/ventas").hasAnyRole("CAJERO", "GERENTE", "ADMIN")  // Crear ventas
                        .requestMatchers("PUT", "/api/ventas").hasAnyRole("GERENTE", "ADMIN")   // Actualizar ventas
                        .requestMatchers("DELETE", "/api/ventas").hasRole("ADMIN")  // Solo Gerente puede eliminar

                        // === Permisos para /api/detalles_ventas ===
                        .requestMatchers("GET", "/api/detalles_ventas").hasAnyRole("CAJERO", "GERENTE", "ADMIN")
                        .requestMatchers("POST", "/api/detalles_ventas").hasAnyRole("CAJERO","GERENTE", "ADMIN")  // Crear detalles
                        .requestMatchers("PUT", "/api/detalles_ventas").hasAnyRole("GERENTE", "ADMIN")   // Actualizar detalles
                        .requestMatchers("DELETE", "/api/detalles_ventas").hasRole("ADMIN")  // Eliminar detalles

                        // === Permisos para /api/productos ===
                        .requestMatchers("GET", "/api/productos").hasAnyRole("Cajero", "GERENTE", "ADMIN")
                        .requestMatchers("POST", "/api/productos").hasAnyRole("GERENTE", "ADMIN")  // Crear productos
                        .requestMatchers("PUT", "/api/productos").hasAnyRole("GERENTE", "ADMIN")   // Actualizar productos
                        .requestMatchers("DELETE", "/api/productos").hasRole("ADMIN")  // Solo Admin puede eliminar

                        // === Permisos para /api/empleados ===
                        .requestMatchers("GET", "/api/empleados").hasAnyRole("ADMIN")
                        .requestMatchers("POST", "/api/empleados").hasRole("ADMIN")  // Solo Admin puede crear empleados
                        .requestMatchers("PUT", "/api/empleados").hasRole("ADMIN")   // Solo Admin puede actualizar empleados
                        .requestMatchers("DELETE", "/api/empleados").hasRole("ADMIN")  // Solo Admin puede eliminar empleados

                        // === Permisos para /api/usuarios ===
                        .requestMatchers("GET", "/api/usuarios").hasAnyRole("ADMIN")
                        .requestMatchers("POST", "/api/usuarios").hasRole("ADMIN")  // Solo Admin puede crear empleados
                        .requestMatchers("PUT", "/api/usuarios").hasRole("ADMIN")   // Solo Admin puede actualizar empleados
                        .requestMatchers("DELETE", "/api/usuarios").hasRole("ADMIN")  // Solo Admin puede eliminar empleados

                        // === Permisos para /api/carritos ===
                        .requestMatchers("GET", "/api/carritos").hasAnyRole("CAJERO", "GERENTE", "ADMIN")
                        .requestMatchers("POST", "/api/carritos").hasAnyRole("CAJERO", "GERENTE", "ADMIN")  // Crear carritos
                        .requestMatchers("PUT", "/api/carritos").hasAnyRole("CAJERO", "GERENTE", "ADMIN")
                        .requestMatchers("DELETE", "/api/carritos").hasAnyRole("CAJERO", "GERENTE", "ADMIN")  // Eliminar carritos

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