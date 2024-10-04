package com.example.POS.Service;

import com.example.POS.Model.CarritoModel;
import com.example.POS.Repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    // Obtener todos
    public List<CarritoModel> getAllCarritos() {
        return carritoRepository.findAll();
    }

    // Obtener
    public Optional<CarritoModel> getCarritoById(Long id) {
        return carritoRepository.findById(id);
    }

    // Guardar
    public CarritoModel saveCarrito(CarritoModel carrito) {
        return carritoRepository.save(carrito);
    }

    // Actualizar
    public CarritoModel actualizarCarrito(Long id, CarritoModel detallesCarrito) {
        CarritoModel carrito = carritoRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        carrito.setEstado(detallesCarrito.getEstado());
        carrito.setFecha_creacion(detallesCarrito.getFecha_creacion());

        return carritoRepository.save(carrito);
    }

    // Eliminar
    public void eliminarCarrito(Long id) {
        carritoRepository.deleteById(id);
    }
}
