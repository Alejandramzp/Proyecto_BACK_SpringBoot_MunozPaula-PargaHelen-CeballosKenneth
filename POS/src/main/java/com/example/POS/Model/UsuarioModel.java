package com.example.POS.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;  // Campo clave primaria

    @Column(unique = true, nullable = false)
    private String nombre_usuario;  // Nombre de usuario único

    @Column(nullable = false)
    private String password;  // Contraseña del usuario

    private String token_jwt;  // Token JWT para autenticación

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private EmpleadoModel empleado;  // Relación con EmpleadoModel

    private String estado;  // Estado del usuario (activo o inactivo)

    // Constructor vacío requerido por JPA
    public UsuarioModel() {
    }

    // Constructor con parámetros
    public UsuarioModel(String nombre_usuario, String password, String token_jwt, EmpleadoModel empleado, String estado) {
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.token_jwt = token_jwt;
        this.empleado = empleado;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken_jwt() {
        return token_jwt;
    }

    public void setToken_jwt(String token_jwt) {
        this.token_jwt = token_jwt;
    }

    public EmpleadoModel getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoModel empleado) {
        this.empleado = empleado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Sobrescribimos el método toString
    @Override
    public String toString() {
        return "Usuario [id_usuario=" + id_usuario +
                ", nombre_usuario=" + nombre_usuario +
                ", password=" + password +
                ", token_jwt=" + token_jwt +
                ", empleado=" + empleado +
                ", estado=" + estado + "]";
    }
}

