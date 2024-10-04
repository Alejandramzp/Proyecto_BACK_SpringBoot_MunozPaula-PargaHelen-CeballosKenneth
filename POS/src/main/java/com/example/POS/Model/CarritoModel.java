package com.example.POS.Model;

import jakarta.persistence.*;
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

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fecha_creacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoCarrito estado;

    public CarritoModel() {
    }

    public CarritoModel(Long id_carrito, EmpleadoModel empleado, LocalDateTime fecha_creacion, EstadoCarrito estado) {
        this.id_carrito = id_carrito;
        this.empleado = empleado;
        this.fecha_creacion = fecha_creacion;
        this.estado = estado;
    }

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

    public enum EstadoCarrito {
        pendiente,
        finalizado
    }
}
