package com.example.POS.Service;

import com.example.POS.Model.RolModel;
import com.example.POS.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServicie {

    @Autowired

    private RolRepository rolRepository;

    // obtener todos los roles

    public List<RolModel> getAllRol(){
        return rolRepository.findAll();
    }


    // obtener por id
    public Optional<RolModel> getRolById(long id){
        return rolRepository.findById(id);
    }

    // guardar rol

    public RolModel saveRol (RolModel rol){
        return rolRepository.save(rol);
    }

    //actualizar rol

    public RolModel actualizarRol(Long id, RolModel rolDetalles) {
        // Buscar el rol por ID o lanzar una excepción si no existe
        RolModel rol = rolRepository.findById(id).orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        // Actualizar los detalles del rol con la información proporcionada
        rol.setNombre_rol(rolDetalles.getNombre_rol());

        // Guardar los cambios en el repositorio
        return rolRepository.save(rol);
    }

    // Eliminar Rol
    public void eliminarRol (Long id){
        rolRepository.deleteById(id);
    }
}