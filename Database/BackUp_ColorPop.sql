USE ColorPop;

CREATE TABLE productos_resguardo (
    id BIGINT,
    codigo_producto VARCHAR(50),
    nombre VARCHAR(100),
    descripcion TEXT,
    precio DECIMAL(10, 2),
    cantidad_disponible INT,
    fecha_resguardo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id, fecha_resguardo)
);

CREATE TABLE empleados_resguardo (
    id BIGINT,
    identificacion VARCHAR(100),
    nombres VARCHAR(255),
    apellidos VARCHAR(255),
    direccion VARCHAR(255),
    telefono VARCHAR(100),
    rol ENUM('Administrador', 'Gerente', 'Cajero'),
    estado ENUM('Activo', 'Inactivo'),
    fecha_resguardo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id, fecha_resguardo)
);

CREATE TABLE usuarios_resguardo (
    id BIGINT,
    id_empleado BIGINT,
    username VARCHAR(255),
    password VARCHAR(255),
    fecha_resguardo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id, fecha_resguardo),
    FOREIGN KEY (id_empleado) REFERENCES empleados_resguardo(id)
);

CREATE TABLE carrito_resguardo (
    id BIGINT,
    id_usuario BIGINT,
    id_producto BIGINT,
    cantidad INT,
    precio_unitario DECIMAL(10, 2),
    fecha_resguardo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id, fecha_resguardo),
    FOREIGN KEY (id_usuario) REFERENCES usuarios_resguardo(id),
    FOREIGN KEY (id_producto) REFERENCES productos_resguardo(id)
);

CREATE TABLE ventas_resguardo (
    id BIGINT,
    numero_venta VARCHAR(50),
    id_empleado BIGINT,
    fecha TIMESTAMP,
    total DECIMAL(10, 2),
    fecha_resguardo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id, fecha_resguardo),
    FOREIGN KEY (id_empleado) REFERENCES empleados_resguardo(id)
);

CREATE TABLE detalles_venta_resguardo (
    id BIGINT,
    id_venta BIGINT,
    id_producto BIGINT,
    cantidad INT,
    precio_unidad DECIMAL(10, 2),
    fecha_resguardo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id, fecha_resguardo),
    FOREIGN KEY (id_venta) REFERENCES ventas_resguardo(id),
    FOREIGN KEY (id_producto) REFERENCES productos_resguardo(id)
);
