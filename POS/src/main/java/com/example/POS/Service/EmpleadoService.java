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

    // Obtener todos los empleados
    public List<EmpleadoModel> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    // Obtener un empleado por ID
    public Optional<EmpleadoModel> getEmpleadoById(Long id) {
        return empleadoRepository.findById(id);
    }

    // Guardar un nuevo empleado
    public EmpleadoModel saveEmpleado(EmpleadoModel empleado) {
        return empleadoRepository.save(empleado);
    }

    // Actualizar un empleado existente
    public EmpleadoModel actualizarEmpleado(Long id, EmpleadoModel detallesEmpleado) {
        EmpleadoModel empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        empleado.setNumero_identificacion(detallesEmpleado.getNumero_identificacion()); // Actualizar número de identificación
        empleado.setNombres(detallesEmpleado.getNombres()); // Actualizar nombres
        empleado.setApellidos(detallesEmpleado.getApellidos()); // Actualizar apellidos
        empleado.setDireccion(detallesEmpleado.getDireccion()); // Actualizar dirección
        empleado.setTelefono(detallesEmpleado.getTelefono()); // Actualizar teléfono
        empleado.setRol(detallesEmpleado.getRol()); // Actualizar rol
        empleado.setEstado(detallesEmpleado.getEstado()); // Actualizar estado

        return empleadoRepository.save(empleado); // Guardar los cambios
    }

    // Eliminar un empleado
    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}