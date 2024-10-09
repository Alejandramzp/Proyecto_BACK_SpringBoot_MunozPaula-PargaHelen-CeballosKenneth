package com.example.ColorPop.Service;

import com.example.ColorPop.Model.Detalle_Venta;
import com.example.ColorPop.Model.Producto;
import com.example.ColorPop.Model.Venta;
import com.example.ColorPop.Repository.Detalle_VentaRepository;
import com.example.ColorPop.Repository.ProductoRepository;
import com.example.ColorPop.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private Detalle_VentaRepository detalleVentaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public List<Venta> getAllVentas(){
        return ventaRepository.findAll();
    }

    public Optional<Venta> getVentaById(Long id){
        return ventaRepository.findById(id);
    }

    public Venta saveVenta(Venta venta){
        return ventaRepository.save(venta);
    }

    public void deleteVenta(Long id){
        ventaRepository.deleteById(id);
    }

    public Venta updateVenta(Long id, Venta ventaDetails){
        Venta venta = ventaRepository.findById(id).orElseThrow();

        venta.setNumero_venta(ventaDetails.getNumero_venta());
        venta.setFecha(ventaDetails.getFecha());
        venta.setTotal(ventaDetails.getTotal());

        return ventaRepository.save(venta);
    }

    // Método para agregar productos al detalle de venta y actualizar el total
    @Transactional
    public Venta agregarProductoADetalleVenta(Long ventaId, Long productoId, int cantidad) {
        // Obtener la venta
        Venta venta = ventaRepository.findById(ventaId).orElseThrow(() ->
                new RuntimeException("Venta no encontrada"));

        // Obtener el producto
        Producto producto = productoRepository.findById(productoId).orElseThrow(() ->
                new RuntimeException("Producto no encontrado"));

        // Crear un nuevo detalle de venta
        Detalle_Venta detalleVenta = new Detalle_Venta();
        detalleVenta.setId_venta(venta);
        detalleVenta.setId_producto(producto);
        detalleVenta.setCantidad(cantidad);
        detalleVenta.setPrecio_unidad(producto.getPrecio());

        // Guardar el detalle de venta
        detalleVentaRepository.save(detalleVenta);

        // Actualizar el total de la venta
        BigDecimal nuevoTotal = venta.getTotal().add(producto.getPrecio().multiply(BigDecimal.valueOf(cantidad)));
        venta.setTotal(nuevoTotal);

        // Guardar la venta actualizada
        return ventaRepository.save(venta);
    }

}
