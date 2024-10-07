package com.example.ColorPop.Service;

import com.example.ColorPop.Model.Carrito;
import com.example.ColorPop.Repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;

    public List<Carrito> getAllCarritos(){
        return carritoRepository.findAll();
    }

    public Optional<Carrito> getCarritoById(Long id){
        return carritoRepository.findById(id);
    }

    public Carrito saveCarrito(Carrito carrito){
        return carritoRepository.save(carrito);
    }

    public void deleteCarrito(Long id){
        carritoRepository.deleteById(id);
    }

    public Carrito updateCarrito(Long id, Carrito carritoDetails){
        Carrito carrito = carritoRepository.findById(id).orElseThrow();

        carrito.setId_usuario(carritoDetails.getId_usuario());
        carrito.setId_producto(carritoDetails.getId_producto());
        carrito.setCantidad(carritoDetails.getCantidad());
        carrito.setPrecio_unitario(carritoDetails.getPrecio_unitario());

        return carritoRepository.save(carrito);
    }
}
