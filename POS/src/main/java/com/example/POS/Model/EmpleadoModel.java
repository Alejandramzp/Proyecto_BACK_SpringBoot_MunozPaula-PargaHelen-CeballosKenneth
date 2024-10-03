package com.example.POS.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@Table(name = "Empleado")
public class EmpleadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empleado;

    private String numero_identificacion;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private RolModel rol;  // Relación con RolModel

    @Enumerated(EnumType.STRING)
    private EstadoEmpleado estado;  // Enum para el estado del empleado

    // Constructor vacío requerido por JPA
    public EmpleadoModel() {
    }

    // Constructor con parámetros
    public EmpleadoModel(String numero_identificacion, String nombres, String apellidos, String direccion, String telefono, RolModel rol, EstadoEmpleado estado) {
        this.numero_identificacion = numero_identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rol = rol;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public RolModel getRol() {
        return rol;
    }

    public void setRol(RolModel rol) {
        this.rol = rol;
    }

    public EstadoEmpleado getEstado() {
        return estado;
    }

    public void setEstado(EstadoEmpleado estado) {
        this.estado = estado;
    }

    // Sobrescribimos el método toString
    @Override
    public String toString() {
        return "Empleado [id_empleado=" + id_empleado + ", numero_identificacion=" + numero_identificacion +
                ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion +
                ", telefono=" + telefono + ", rol=" + rol + ", estado=" + estado + "]";
    }

    // Enum para el estado del empleado
    public enum EstadoEmpleado {
        activo,
        inactivo
    }
}

