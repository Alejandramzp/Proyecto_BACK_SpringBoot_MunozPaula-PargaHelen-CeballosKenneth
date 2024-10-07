package com.example.ColorPop.Service;

import com.example.ColorPop.Model.Usuario;
import com.example.ColorPop.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id){
        return usuarioRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario updateUsuario(Long id, Usuario usuarioDetails){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        usuario.setId_empleado(usuarioDetails.getId_empleado());
        usuario.setUsername(usuarioDetails.getUsername());
        usuario.setPassword(usuarioDetails.getPassword());

        return usuarioRepository.save(usuario);
    }
}
