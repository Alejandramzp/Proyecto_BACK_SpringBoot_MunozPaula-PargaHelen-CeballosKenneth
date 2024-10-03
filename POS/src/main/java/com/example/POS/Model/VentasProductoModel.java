
package com.example.POS.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas_producto")
public class VentasProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta_producto;  // Campo clave primaria

    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private VentasModel venta;  // Relación con VentasModel

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductosModel producto;  // Relación con ProductosModel

    private int cantidad;  // Cantidad del producto vendido
    private double precio_unidad;  // Precio por unidad del producto vendido

    // Constructor vacío requerido por JPA
    public VentasProductoModel() {
    }

    // Constructor con parámetros
    public VentasProductoModel(VentasModel venta, ProductosModel producto, int cantidad, double precio_unidad) {
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio_unidad = precio_unidad;
    }

    // Getters y Setters
    public Long getId_venta_producto() {
        return id_venta_producto;
    }

    public void setId_venta_producto(Long id_venta_producto) {
        this.id_venta_producto = id_venta_producto;
    }

    public VentasModel getVenta() {
        return venta;
    }

    public void setVenta(VentasModel venta) {
        this.venta = venta;
    }

    public ProductosModel getProducto() {
        return producto;
    }

    public void setProducto(ProductosModel producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unidad() {
        return precio_unidad;
    }

    public void setPrecio_unidad(double precio_unidad) {
        this.precio_unidad = precio_unidad;
    }

    // Sobrescribimos el método toString
    @Override
    public String toString() {
        return "VentasProducto [id_venta_producto=" + id_venta_producto +
                ", venta=" + venta +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                ", precio_unidad=" + precio_unidad + "]";
    }
}
