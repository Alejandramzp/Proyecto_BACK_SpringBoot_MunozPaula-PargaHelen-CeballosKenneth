package com.example.POS.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class VentasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;  // Campo clave primaria

    private String numero_venta;  // Número de la venta
    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private EmpleadoModel empleado;  // Relación con EmpleadoModel

    private java.util.Date fecha;  // Fecha de la venta
    private double total_venta;  // Total de la venta

    // Estado de la venta: completada o cancelada
    private String estado;  // 'completada' o 'cancelada'

    // Constructor vacío requerido por JPA
    public VentasModel() {
    }

    // Constructor con parámetros
    public VentasModel(String numero_venta, EmpleadoModel empleado, java.util.Date fecha, double total_venta, String estado) {
        this.numero_venta = numero_venta;
        this.empleado = empleado;
        this.fecha = fecha;
        this.total_venta = total_venta;
        this.estado = estado;
    }

    // Getters y Setters
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

    public java.util.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
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
        return "Ventas [id_venta=" + id_venta +
                ", numero_venta='" + numero_venta + '\'' +
                ", empleado=" + empleado +
                ", fecha=" + fecha +
                ", total_venta=" + total_venta +
                ", estado='" + estado + '\'' +
                ']';
    }
}

