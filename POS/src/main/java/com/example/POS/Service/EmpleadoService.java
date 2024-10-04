package com.example.POS.Service;

import com.example.POS.Model.EmpleadoModel;
import com.example.POS.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    // Obtener todos
    public List<EmpleadoModel> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    // Obtener por ID
    public Optional<EmpleadoModel> getEmpleadoById(Long id) {
        return empleadoRepository.findById(id);
    }

    // Guardar
    public EmpleadoModel saveEmpleado(EmpleadoModel empleado) {
        return empleadoRepository.save(empleado);
    }

    // Actualizar
    public EmpleadoModel actualizarEmpleado(Long id, EmpleadoModel detallesEmpleado) {
        EmpleadoModel empleado = empleadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        empleado.setNumero_identificacion(detallesEmpleado.getNumero_identificacion());
        empleado.setNombres(detallesEmpleado.getNombres());
        empleado.setApellidos(detallesEmpleado.getApellidos());
        empleado.setDireccion(detallesEmpleado.getDireccion());
        empleado.setTelefono(detallesEmpleado.getTelefono());
        empleado.setRol(detallesEmpleado.getRol());
        empleado.setEstado(detallesEmpleado.getEstado());

        return empleadoRepository.save(empleado);
    }

    // Eliminar un empleado
    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}