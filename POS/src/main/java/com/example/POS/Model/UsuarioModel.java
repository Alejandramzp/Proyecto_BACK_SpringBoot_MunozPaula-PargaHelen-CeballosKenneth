package com.example.POS.Model;

import jakarta.persistence.*;
@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(name = "nombre_usuario", unique = true, nullable = false)
    private String nombre_usuario;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "token_jwt")
    private String token_jwt;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private EmpleadoModel empleado;  // Relación con EmpleadoModel

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoUsuario estado;

    public enum EstadoUsuario {
        activo, inactivo
    }

    public UsuarioModel() {
    }

    public UsuarioModel(Long id_usuario, String nombre_usuario, String password, String token_jwt, EmpleadoModel empleado, EstadoUsuario estado) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.token_jwt = token_jwt;
        this.empleado = empleado;
        this.estado = estado;
    }

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

    public EstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuario estado) {
        this.estado = estado;
    }
}

