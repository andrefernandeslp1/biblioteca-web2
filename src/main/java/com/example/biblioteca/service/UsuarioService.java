package com.example.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.UsuarioRepository;

@Component
public class UsuarioService {
  
  @Autowired
  UsuarioRepository usuarioRepository;

  public void salvarUsuario(Usuario usuario) {
    usuarioRepository.save(usuario);
  }

  public void deletarUsuario(Usuario usuario) {
    usuarioRepository.delete(usuario);
  }

  public List<Usuario> getListaUsuarios() {
    return usuarioRepository.findAll();
  }

  public Usuario getUsuarioById(Integer id) {
    return usuarioRepository.findById(id).map(usuario -> {
      return usuario;
    }).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
  }

}
