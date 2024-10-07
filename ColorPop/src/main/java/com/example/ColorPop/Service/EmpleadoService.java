package com.example.ColorPop.Service;

import com.example.ColorPop.Model.Empleado;
import com.example.ColorPop.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleados(){
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> getEmpleadoById(Long id){
        return empleadoRepository.findById(id);
    }

    public Empleado saveEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public void deleteEmpleado(Long id){
        empleadoRepository.deleteById(id);
    }

    public Empleado updateEmpleado(Long id, Empleado empleadoDetails){
        Empleado empleado = empleadoRepository.findById(id).orElseThrow();

        empleado.setIdentificacion(empleadoDetails.getIdentificacion());
        empleado.setNombres(empleadoDetails.getNombres());
        empleado.setApellidos(empleadoDetails.getApellidos());
        empleado.setDireccion(empleadoDetails.getDireccion());
        empleado.setTelefono(empleadoDetails.getTelefono());
        empleado.setRol(empleadoDetails.getRol());
        empleado.setEstado(empleadoDetails.getEstado());

        return empleadoRepository.save(empleado);
    }
}
