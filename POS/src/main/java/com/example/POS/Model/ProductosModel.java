package com.example.POS.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Productos")
public class ProductosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Producto;

    @Column(name = "codigo_producto", unique = true, nullable = false)
    private String codigo_producto;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_unitario", nullable = false)
    private double precio_unitario;

    @Column(name = "cantidad_disponible", nullable = false)
    private Integer cantidad_disponible;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoProducto estado;

    public enum EstadoProducto {
        activo, agotado
    }

    public ProductosModel() {
    }

    public ProductosModel(Long id_Producto, String codigo_producto, String nombre, String descripcion, double precio_unitario, Integer cantidad_disponible, EstadoProducto estado) {
        this.id_Producto = id_Producto;
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
        this.cantidad_disponible = cantidad_disponible;
        this.estado = estado;
    }

    public Long getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(Long id_Producto) {
        this.id_Producto = id_Producto;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Integer getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(Integer cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }
}
