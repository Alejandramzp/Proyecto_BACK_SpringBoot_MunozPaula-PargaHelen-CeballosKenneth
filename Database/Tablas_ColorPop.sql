CREATE DATABASE ColorPop;
USE ColorPop;

CREATE TABLE productos(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    codigo_producto VARCHAR(50) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    cantidad_disponible INT NOT NULL
);

CREATE TABLE empleados(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    identificacion VARCHAR(100) UNIQUE NOT NULL,
    nombres VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(100),
    rol ENUM('Administrador', 'Gerente', 'Cajero') NOT NULL,
    estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo' NOT NULL
);

CREATE TABLE usuarios(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_empleado BIGINT NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (id_empleado) REFERENCES empleados(id)
);

CREATE TABLE carrito(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_usuario BIGINT NOT NULL,
    id_producto BIGINT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL, 
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_producto) REFERENCES productos(id)
);

CREATE TABLE ventas(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    numero_venta VARCHAR(50) UNIQUE NOT NULL,
    fecha TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2) NOT NULL
   
);

CREATE TABLE detalles_venta(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    id_venta BIGINT NOT NULL,
    id_producto BIGINT NOT NULL,
    cantidad INT NOT NULL,
    precio_unidad DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_venta) REFERENCES ventas(id),
    FOREIGN KEY (id_producto) REFERENCES productos(id)
);

SHOW TABLES;

select * from ventas ;

