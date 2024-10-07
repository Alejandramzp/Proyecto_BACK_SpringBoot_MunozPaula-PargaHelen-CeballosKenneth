USE ColorPop;

DELIMITER $$

CREATE TRIGGER after_producto_delete
AFTER DELETE ON productos
FOR EACH ROW
BEGIN
    INSERT INTO productos_resguardo (id, codigo_producto, nombre, descripcion, precio, cantidad_disponible)
    VALUES (OLD.id, OLD.codigo_producto, OLD.nombre, OLD.descripcion, OLD.precio, OLD.cantidad_disponible);
END$$

CREATE TRIGGER after_empleado_delete
AFTER DELETE ON empleados
FOR EACH ROW
BEGIN
    INSERT INTO empleados_resguardo (id, identificacion, nombres, apellidos, direccion, telefono, rol, estado)
    VALUES (OLD.id, OLD.identificacion, OLD.nombres, OLD.apellidos, OLD.direccion, OLD.telefono, OLD.rol, OLD.estado);
END$$

CREATE TRIGGER after_usuario_delete
AFTER DELETE ON usuarios
FOR EACH ROW
BEGIN
    INSERT INTO usuarios_resguardo (id, id_empleado, username, password)
    VALUES (OLD.id, OLD.id_empleado, OLD.username, OLD.password);
END$$

CREATE TRIGGER after_carrito_delete
AFTER DELETE ON carrito
FOR EACH ROW
BEGIN
    INSERT INTO carrito_resguardo (id, id_usuario, id_producto, cantidad, precio_unitario)
    VALUES (OLD.id, OLD.id_usuario, OLD.id_producto, OLD.cantidad, OLD.precio_unitario);
END$$

CREATE TRIGGER after_venta_delete
AFTER DELETE ON ventas
FOR EACH ROW
BEGIN
    INSERT INTO ventas_resguardo (id, numero_venta, id_empleado, fecha, total)
    VALUES (OLD.id, OLD.numero_venta, OLD.id_empleado, OLD.fecha, OLD.total);
END$$

CREATE TRIGGER after_detalle_venta_delete
AFTER DELETE ON detalles_venta
FOR EACH ROW
BEGIN
    INSERT INTO detalles_venta_resguardo (id, id_venta, id_producto, cantidad, precio_unidad)
    VALUES (OLD.id, OLD.id_venta, OLD.id_producto, OLD.cantidad, OLD.precio_unidad);
END$$

DELIMITER ;