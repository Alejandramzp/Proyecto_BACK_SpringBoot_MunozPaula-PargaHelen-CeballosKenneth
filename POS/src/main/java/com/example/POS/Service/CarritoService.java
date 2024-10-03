
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

    // Obtener todos los carritos
    public List<CarritoModel> getAllCarritos() {
        return carritoRepository.findAll();
    }

    // Obtener un carrito por ID
    public Optional<CarritoModel> getCarritoById(Long id) {
        return carritoRepository.findById(id);
    }

    // Guardar un nuevo carrito
    public CarritoModel saveCarrito(CarritoModel carrito) {
        return carritoRepository.save(carrito);
    }

    // Actualizar un carrito existente
    public CarritoModel actualizarCarrito(Long id, CarritoModel detallesCarrito) {
        CarritoModel carrito = carritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        carrito.setEstado(detallesCarrito.getEstado()); // Actualizar el estado del carrito
        carrito.setFecha_creacion(detallesCarrito.getFecha_creacion()); // Actualizar la fecha de creación

        return carritoRepository.save(carrito); // Guardar los cambios
    }

    // Eliminar un carrito
    public void eliminarCarrito(Long id) {
        carritoRepository.deleteById(id);
    }
}
