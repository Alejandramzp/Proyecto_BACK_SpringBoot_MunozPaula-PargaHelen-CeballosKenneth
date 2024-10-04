package com.example.POS.Service;

import com.example.POS.Model.UsuarioModel;
import com.example.POS.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Obtener todos
    public List<UsuarioModel> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener  por ID
    public Optional<UsuarioModel> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Guardar
    public UsuarioModel saveUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    // Actualizar
    public UsuarioModel actualizarUsuario(Long id, UsuarioModel detallesUsuario) {
        UsuarioModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setNombre_usuario(detallesUsuario.getNombre_usuario());
        usuario.setPassword(detallesUsuario.getPassword());
        usuario.setToken_jwt(detallesUsuario.getToken_jwt());
        usuario.setEmpleado(detallesUsuario.getEmpleado());
        usuario.setEstado(detallesUsuario.getEstado());
        return usuarioRepository.save(usuario);
    }

    // Eliminar
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}