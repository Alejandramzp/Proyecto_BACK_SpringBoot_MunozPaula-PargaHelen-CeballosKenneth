USE ColorPop;

-- funcion que permite calcular el 19% 
DELIMITER //

CREATE FUNCTION calcular_total_con_impuesto(subtotal DECIMAL(10, 2))
RETURNS DECIMAL(10, 2)
DETERMINISTIC
BEGIN
    DECLARE total DECIMAL(10, 2);
    SET total = subtotal + (subtotal * 0.19); -- Aplica el 19% de impuesto
    RETURN total;
END //

DELIMITER ;

SELECT * FROM ventas;

-- Evento para generar un descuento el dia de la mujer
CREATE EVENT aplicar_descuento_dia_mujer
ON SCHEDULE EVERY 1 YEAR
STARTS '2024-12-15 00:00:00'
ENDS '2024-12-15 23:59:59'
DO
  UPDATE carrito
  SET precio_unitario = precio_unitario * 0.5
  WHERE DATE(NOW()) = '2024-12-15';
  
-- Activacion del evento 
  SET GLOBAL event_scheduler = ON;
 
 -- Evento para generar descuetos en el niversario de la tienda
  CREATE EVENT aplicar_descuento_aniversario
ON SCHEDULE EVERY 1 YEAR
STARTS '2024-03-08 00:00:00'
ENDS '2024-03-08 23:59:59'
DO
  UPDATE ventas
  SET total = CASE
                WHEN total > 350000 THEN total * 0.5  -- 50% descuento
                WHEN total > 150000 THEN total * 0.8  -- 20% descuento
                WHEN total > 100000 THEN total * 0.9  -- 10% descuento
                ELSE total
              END
  WHERE DATE(fecha) = '2024-03-08';
  
-- procedimiento que muestre facturas con total sin iva y total con iva
DELIMITER $$

CREATE PROCEDURE mostrar_facturas()
BEGIN
  -- Ventas con su total sin IVA y con IVA
  SELECT 
    v.id AS id_venta,
    v.numero_venta,
    v.fecha,
    v.total AS total_sin_iva,
    ROUND(v.total * 1.19, 2) AS total_con_iva
  FROM ventas v;

  -- Detalle de las ventas
  SELECT 
    dv.id_venta,
    p.nombre AS producto,
    dv.cantidad,
    dv.precio_unidad,
    dv.cantidad * dv.precio_unidad AS subtotal
  FROM ventas dv
  JOIN productos p ON dv.id_producto = p.id;

END$$

DELIMITER ;

CALL mostrar_facturas();
