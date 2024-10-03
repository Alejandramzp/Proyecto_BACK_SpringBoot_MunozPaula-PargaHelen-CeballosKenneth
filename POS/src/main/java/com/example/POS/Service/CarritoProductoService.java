package com.example.POS.Service;
import com.example.POS.Repository.CarritoProductoRepository;
import com.example.POS.Model.CarritoProductoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class CarritoProductoService {

    @Autowired

    private CarritoProductoRepository carritoProductoRepository;

    //obteneer todos los carrosproducto

    public List<CarritoProductoModel> getAllCarritoProducto(){
        return carritoProductoRepository.findAll();
    }

    // Obtener por id

    public Optional<CarritoProductoModel> getCarritoProductoById(Long id){
        return carritoProductoRepository.findById(id);
    }

    // guardar mesas

    public CarritoProductoModel saveCarritoProducto (CarritoProductoModel carritoProducto){
        return carritoProductoRepository.save(carritoProducto);
    }
    // actualizar carrito Producto

    public CarritoProductoModel actualizarCarritoProducto (Long id, CarritoProductoModel carritoproductoDetalle){
        CarritoProductoModel carritoProducto = carritoProductoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto en el carrito no encintrado "));
        carritoProducto.setCantidad(carritoproductoDetalle.getCantidad()); // Actualizar la cantidad
        carritoProducto.setPrecio(carritoproductoDetalle.getPrecio()); // Actualizar el precio

        return carritoProductoRepository.save(carritoProducto); // Guardar los cambios
    }

    // Eliminar un producto del carrito
    public void eliminarCarritoProducto(Long id) {
        carritoProductoRepository.deleteById(id);
    }


}
