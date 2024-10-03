package com.example.POS.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class ProductosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;  // Campo clave primaria

    @Column (unique = true)
    private String codigo_producto;  // Código único del producto

    private String nombre;  // Nombre del producto
    private String descripcion;  // Descripción del producto
    private double precio_unitario;  // Precio por unidad del producto
    private int cantidad_disponible;  // Stock disponible
    private String estado;  // Estado del producto (ej: Activo, Inactivo)

    // Constructor vacío requerido por JPA
    public ProductosModel() {
    }

    // Constructor con parámetros
    public ProductosModel(String codigo_producto, String nombre, String descripcion, double precio_unitario, int cantidad_disponible, String estado) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_unitario = precio_unitario;
        this.cantidad_disponible = cantidad_disponible;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
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

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
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
        return "Producto [id_producto=" + id_producto + ", codigo_producto=" + codigo_producto +
                ", nombre=" + nombre + ", descripcion=" + descripcion +
                ", precio_unitario=" + precio_unitario + ", cantidad_disponible=" + cantidad_disponible +
                ", estado=" + estado + "]";
    }
}
