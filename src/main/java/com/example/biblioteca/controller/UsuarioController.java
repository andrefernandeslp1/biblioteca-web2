package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.service.EmprestimoService;
import com.example.biblioteca.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
  
  @Autowired
  UsuarioService usuarioService;

  @Autowired
  EmprestimoService emprestimoService;

  @RequestMapping("/showForm")
  public String showFormUsuario(Model model) {
    

    return "usuario/formUsuario";
  }

  @RequestMapping("/addUsuario")
  public String addUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {

    return "usuario/listaUsuarios";
  }

  @RequestMapping("/getListaUsuarios")
  public String getListaUsuarios(Model model) {

    List<Usuario> usuarios = usuarioService.getListaUsuarios();
    model.addAttribute("usuarios", usuarios);
    return "usuario/listaUsuarios";
  }

  @RequestMapping("/deletarUsuario")
  public String deletarUsuario(Integer id, Model model) {

    return "usuario/listaUsuarios";
  }

}
