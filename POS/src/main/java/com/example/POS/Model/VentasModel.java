package com.example.POS.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
public class VentasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;

    @Column(name = "numero_venta", unique = true, nullable = false)
    private String numero_venta;
    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private EmpleadoModel empleado;  // Relación con EmpleadoModel

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "total_venta", nullable = false)
    private double total_venta;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoVenta estado;

    public enum EstadoVenta {
        completada, cancelada
    }

    public VentasModel() {
    }

    public VentasModel(Long id_venta, String numero_venta, EmpleadoModel empleado, LocalDateTime fecha, double total_venta, EstadoVenta estado) {
        this.id_venta = id_venta;
        this.numero_venta = numero_venta;
        this.empleado = empleado;
        this.fecha = fecha;
        this.total_venta = total_venta;
        this.estado = estado;
    }

    public Long getId_venta() {
        return id_venta;
    }

    public void setId_venta(Long id_venta) {
        this.id_venta = id_venta;
    }

    public String getNumero_venta() {
        return numero_venta;
    }

    public void setNumero_venta(String numero_venta) {
        this.numero_venta = numero_venta;
    }

    public EmpleadoModel getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoModel empleado) {
        this.empleado = empleado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
    }

    public EstadoVenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoVenta estado) {
        this.estado = estado;
    }
}
