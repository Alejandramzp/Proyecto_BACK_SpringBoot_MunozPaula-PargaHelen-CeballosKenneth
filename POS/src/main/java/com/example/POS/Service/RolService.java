package com.example.POS.Service;

import com.example.POS.Model.RolModel;
import com.example.POS.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired

    private RolRepository rolRepository;

    // Obtener todos
    public List<RolModel> getAllRol(){
        return rolRepository.findAll();
    }

    // Obtener por id
    public Optional<RolModel> getRolById(long id){
        return rolRepository.findById(id);
    }

    // Guardar
    public RolModel saveRol (RolModel rol){
        return rolRepository.save(rol);
    }

    //Actualizar
    public RolModel actualizarRol(Long id, RolModel rolDetalles) {
        RolModel rol = rolRepository.findById(id).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        rol.setNombre_rol(rolDetalles.getNombre_rol());
        return rolRepository.save(rol);
    }

    // Eliminar
    public void eliminarRol (Long id){
        rolRepository.deleteById(id);
    }
}