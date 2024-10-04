package com.example.POS.Model;

import jakarta.persistence.*;
@Entity
@Table(name = "Ventas_Producto")
public class VentasProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta_producto;

    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private VentasModel venta;  // Relación con VentasModel

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductosModel producto;  // Relación con ProductosModel

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precio_unidad", nullable = false)
    private double precio_unidad;

    public VentasProductoModel() {
    }

    public VentasProductoModel(Long id_venta_producto, VentasModel venta, ProductosModel producto, int cantidad, double precio_unidad) {
        this.id_venta_producto = id_venta_producto;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio_unidad = precio_unidad;
    }

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
}
