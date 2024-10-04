package com.example.POS.Service;

import com.example.POS.Model.CarritoProductoModel;
import com.example.POS.Repository.CarritoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoProductoService {

    @Autowired
    private CarritoProductoRepository carritoProductoRepository;

    //Obtener todos
    public List<CarritoProductoModel> getAllCarritoProducto(){
        return carritoProductoRepository.findAll();
    }

    // Obtener por id
    public Optional<CarritoProductoModel> getCarritoProductoById(Long id){
        return carritoProductoRepository.findById(id);
    }

    // Guardar
    public CarritoProductoModel saveCarritoProducto (CarritoProductoModel carritoProducto){
        return carritoProductoRepository.save(carritoProducto);
    }

    // Actualizar
    public CarritoProductoModel actualizarCarritoProducto (Long id, CarritoProductoModel carritoproductoDetalle){
        CarritoProductoModel carritoProducto = carritoProductoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto en el carrito no encontrado"));
        carritoProducto.setCantidad(carritoproductoDetalle.getCantidad());
        carritoProducto.setPrecio(carritoproductoDetalle.getPrecio());

        return carritoProductoRepository.save(carritoProducto);
    }

    // Eliminar un producto del carrito
    public void eliminarCarritoProducto(Long id) {
        carritoProductoRepository.deleteById(id);
    }
}