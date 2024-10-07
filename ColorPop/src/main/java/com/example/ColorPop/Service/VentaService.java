package com.example.ColorPop.Service;

import com.example.ColorPop.Model.Venta;
import com.example.ColorPop.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

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
        venta.setId_empleado(ventaDetails.getId_empleado());
        venta.setFecha(ventaDetails.getFecha());
        venta.setTotal(ventaDetails.getTotal());

        return ventaRepository.save(venta);
    }

}
