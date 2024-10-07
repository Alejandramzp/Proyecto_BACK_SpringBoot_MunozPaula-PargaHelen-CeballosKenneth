package com.example.ColorPop.Service;

import com.example.ColorPop.Model.Detalle_Venta;
import com.example.ColorPop.Repository.Detalle_VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Detalle_VentaService {
    @Autowired
    private Detalle_VentaRepository detalleVentaRepository;

    public List<Detalle_Venta> getAllDetalleVenta(){
        return detalleVentaRepository.findAll();
    }

    public Optional<Detalle_Venta> getDetalleVentaById(Long id){
        return detalleVentaRepository.findById(id);
    }

    public Detalle_Venta saveDetalleVenta(Detalle_Venta detalleVenta){
        return detalleVentaRepository.save(detalleVenta);
    }

    public void deleteDetalleVenta(Long id){
        detalleVentaRepository.deleteById(id);
    }

    public Detalle_Venta updateDetalleVenta(Long id, Detalle_Venta detalleVentaDetails){
        Detalle_Venta detalleVenta = detalleVentaRepository.findById(id).orElseThrow();

        detalleVenta.setId_venta(detalleVentaDetails.getId_venta());
        detalleVenta.setId_producto(detalleVentaDetails.getId_producto());
        detalleVenta.setCantidad(detalleVentaDetails.getCantidad());
        detalleVenta.setPrecio_unidad(detalleVentaDetails.getPrecio_unidad());

        return detalleVentaRepository.save(detalleVenta);
    }
}
