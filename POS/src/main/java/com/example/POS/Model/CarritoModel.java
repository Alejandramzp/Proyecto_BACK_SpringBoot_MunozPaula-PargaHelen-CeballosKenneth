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
import java.time.LocalDateTime;

@Entity
@Table(name = "Carrito")
public class CarritoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private EmpleadoModel empleado;  // Relación con EmpleadoModel

    private LocalDateTime fecha_creacion;

    @Enumerated(EnumType.STRING)
    private EstadoCarrito estado;  // Enum para el estado del carrito

    // Constructor vacío requerido por JPA
    public CarritoModel() {
    }

    // Constructor con parámetros
    public CarritoModel(EmpleadoModel empleado, LocalDateTime fecha_creacion, EstadoCarrito estado) {
        this.empleado = empleado;
        this.fecha_creacion = fecha_creacion;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Long id_carrito) {
        this.id_carrito = id_carrito;
    }

    public EmpleadoModel getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoModel empleado) {
        this.empleado = empleado;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public EstadoCarrito getEstado() {
        return estado;
    }

    public void setEstado(EstadoCarrito estado) {
        this.estado = estado;
    }

    // Sobrescribimos el método toString
    @Override
    public String toString() {
        return "Carrito [id_carrito=" + id_carrito + ", empleado=" + empleado +
                ", fecha_creacion=" + fecha_creacion + ", estado=" + estado + "]";
    }

    // Enum para el estado del carrito
    public enum EstadoCarrito {
        pendiente,
        finalizado
    }
}
