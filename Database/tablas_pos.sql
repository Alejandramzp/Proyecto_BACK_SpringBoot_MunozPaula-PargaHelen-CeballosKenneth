create database pos;
use pos; 

CREATE TABLE Productos (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    codigo_producto VARCHAR(50) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    cantidad_disponible INT NOT NULL,
    estado ENUM('activo', 'agotado') DEFAULT 'activo'
);
CREATE TABLE Rol (
    id_rol INT PRIMARY KEY AUTO_INCREMENT,
    nombre_rol ENUM('Cajero', 'Gerente', 'Administrador') UNIQUE NOT NULL
);
CREATE TABLE Empleado (
    id_empleado INT PRIMARY KEY AUTO_INCREMENT,
    numero_identificacion VARCHAR(50) UNIQUE NOT NULL,
    nombres VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(15),
    id_rol INT,
    estado ENUM('activo', 'inactivo') DEFAULT 'activo',
    FOREIGN KEY (id_rol) REFERENCES Rol(id_rol)
);


CREATE TABLE Carrito (
    id_carrito INT PRIMARY KEY AUTO_INCREMENT,
    id_empleado INT,
    fecha_creacion DATETIME NOT NULL,
    estado ENUM('pendiente', 'finalizado') NOT NULL,
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado)
);

CREATE TABLE Carrito_Producto (
    id_carrito_producto INT PRIMARY KEY AUTO_INCREMENT,
    id_carrito INT,
    id_producto INT,
    cantidad INT NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_carrito) REFERENCES Carrito(id_carrito),
    FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);

CREATE TABLE Ventas (
    id_venta INT PRIMARY KEY AUTO_INCREMENT,
    numero_venta VARCHAR(50) UNIQUE NOT NULL,
    id_empleado INT,
    fecha DATETIME NOT NULL,
    total_venta DECIMAL(10, 2) NOT NULL,
    estado ENUM('completada', 'cancelada') DEFAULT 'completada',
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado)
);

CREATE TABLE Ventas_Producto (
    id_venta_producto INT PRIMARY KEY AUTO_INCREMENT,
    id_venta INT,
    id_producto INT,
    cantidad INT NOT NULL,
    precio_unidad DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_venta) REFERENCES Ventas(id_venta),
    FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);

CREATE TABLE Usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    token_jwt TEXT,
    id_empleado INT,
    estado ENUM('activo', 'inactivo') DEFAULT 'activo',
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado)
);

show tables;

