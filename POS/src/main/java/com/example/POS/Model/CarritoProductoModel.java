package com.example.POS.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Carrito_Producto")
public class CarritoProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito_producto;

    @ManyToOne
    @JoinColumn(name = "id_carrito", nullable = false)
    private CarritoModel carrito;  // Relación con CarritoModel

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductosModel producto;  // Relación con ProductosModel

    private int cantidad;  // Cantidad del producto en el carrito
    private double precio;  // Precio del producto en el carrito

    // Constructor vacío requerido por JPA
    public CarritoProductoModel() {
    }

    // Constructor con parámetros
    public CarritoProductoModel(CarritoModel carrito, ProductosModel producto, int cantidad, double precio) {
        this.carrito = carrito;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y Setters
    public Long getId_carrito_producto() {
        return id_carrito_producto;
    }

    public void setId_carrito_producto(Long id_carrito_producto) {
        this.id_carrito_producto = id_carrito_producto;
    }

    public CarritoModel getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoModel carrito) {
        this.carrito = carrito;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Sobrescribimos el método toString
    @Override
    public String toString() {
        return "CarritoProducto [id_carrito_producto=" + id_carrito_producto +
                ", carrito=" + carrito + ", producto=" + producto +
                ", cantidad=" + cantidad + ", precio=" + precio + "]";
    }
}
