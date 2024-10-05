use pos;

-- --------PRODUCTO--------------
INSERT INTO Productos (codigo_producto, nombre, descripcion, precio_unitario, cantidad_disponible, estado) 
VALUES 
('BL001', 'Base Líquida', 'Base líquida de larga duración para todo tipo de piel', 12.50, 100, 'activo'),
('CCR001', 'Corrector', 'Corrector en crema para cubrir ojeras e imperfecciones', 8.99, 150, 'activo'),
('PC001', 'Polvo Compacto', 'Polvo compacto matificante para un acabado perfecto', 10.00, 80, 'activo'),
('SOQ001', 'Sombras de Ojos', 'Paleta de sombras de ojos con 10 colores vibrantes', 15.75, 60, 'activo'),
('DL001', 'Delineador Líquido', 'Delineador líquido de alta precisión y secado rápido', 6.50, 200, 'activo'),
('RUP001', 'Rubor', 'Rubor en polvo de textura suave y pigmento intenso', 7.80, 120, 'activo'),
('RIPA001', 'Rímel', 'Rímel a prueba de agua para mayor volumen y longitud', 9.25, 140, 'activo'),
('LM001', 'Labial Mate', 'Labial mate de larga duración con acabado aterciopelado', 11.00, 130, 'activo'),
('BLH001', 'Bálsamo Labial', 'Bálsamo hidratante con protector solar SPF 15', 4.50, 200, 'activo'),
('IL001', 'Iluminador Líquido', 'Iluminador líquido para un brillo natural y luminoso', 14.00, 90, 'activo');


-- ------------ROL----------

INSERT INTO Rol (nombre_rol) 
VALUES 
('Cajero'),
('Gerente'),
('Administrador');

-- ---------- EMPLEADO ----------------	

INSERT INTO Empleado (numero_identificacion, nombres, apellidos, direccion, telefono, id_rol, estado)
VALUES 
('1025698325', 'Ana', 'Gómez', 'Av. Libertador 123', '3101234506', 1, 'activo'),
('1002584655', 'Luis', 'Pérez', 'Calle Flores 45', '3206543218', 2, 'activo'),
('1098568948', 'Carla', 'Rodríguez', 'Av. Central 678', '3112334458', 3, 'activo');

-- ------CARRITO---------------------------

INSERT INTO Carrito (id_empleado, fecha_creacion, estado) 
VALUES 
(1, '2024-10-02 10:00:00', 'pendiente'),
(2, '2024-10-02 11:30:00', 'finalizado');

-- -----CARRITO PRODUCTO-------

INSERT INTO Carrito_Producto (id_carrito, id_producto, cantidad, precio) 
VALUES 
(1, 1, 2, 12.50),   -- Base Líquida
(1, 3, 1, 10.00),   -- Polvo Compacto
(2, 5, 1, 6.50),    -- Delineador Líquido
(2, 7, 2, 9.25);    -- Rímel

-- ----VENTA------------------
INSERT INTO Ventas (numero_venta, id_empleado, fecha, total_venta, estado)
VALUES 
('VTA001', 2, '2024-10-02 12:00:00', 25.75, 'completada'),
('VTA002', 1, '2024-10-02 14:00:00', 18.50, 'completada');

-- ------VENTA PRODUCTO-----------------

INSERT INTO Ventas_Producto (id_venta, id_producto, cantidad, precio_unidad)
VALUES 
(1, 1, 2, 12.50),   -- Base Líquida
(1, 3, 1, 10.00),   -- Polvo Compacto
(2, 5, 1, 6.50),    -- Delineador Líquido
(2, 7, 2, 9.25);    -- Rímel

-- ----USUARIO---------------------

INSERT INTO Usuario (nombre_usuario, password, token_jwt, id_empleado, estado)
VALUES 
('ana.gomez', 'password1', NULL, 1, 'activo'),
('luis.perez', 'password2', NULL, 2, 'activo'),
('carla.rodriguez', 'password3', NULL, 3, 'activo');
  
