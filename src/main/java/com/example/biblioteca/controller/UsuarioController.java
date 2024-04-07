package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.biblioteca.model.Emprestimo;
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
    
    Usuario usuario = new Usuario();
    model.addAttribute("usuario", usuario);
    String showDiv = "formUsuario";
    model.addAttribute("showDiv", showDiv);

    return "index";
  }

  @RequestMapping("/addUsuario")
  public String addUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {

    List<Usuario> usuariosVerificar = usuarioService.getListaUsuarios();
    for (Usuario usuarioVerificar : usuariosVerificar) {
      if (usuarioVerificar.getNome().equals(usuario.getNome())) {
        String showDiv = "listaUsuarios";
        String mensagem = "Usuário já cadastrado!";
        model.addAttribute("showDiv", showDiv);
        model.addAttribute("usuarios", usuariosVerificar);
        model.addAttribute("mensagem", mensagem);
        return "index";
      }
    }
    usuarioService.salvarUsuario(usuario);
    List<Usuario> usuarios = usuarioService.getListaUsuarios();
    model.addAttribute("usuarios", usuarios);
    String showDiv = "listaUsuarios";
    model.addAttribute("showDiv", showDiv);

    return "index";
  }

  @RequestMapping("/getListaUsuarios")
  public String getListaUsuarios(Model model) {

    List<Usuario> usuarios = usuarioService.getListaUsuarios();
    model.addAttribute("usuarios", usuarios);
    String showDiv = "listaUsuarios";
    model.addAttribute("showDiv", showDiv);

    return "index";
  }

  @RequestMapping("/deletarUsuario")
  public String deletarUsuario(Integer id, Model model) {

    Usuario usuario = usuarioService.getUsuarioById(id);
    List<Emprestimo> emprestimos = emprestimoService.getListaEmprestimos();
    for (Emprestimo emprestimo : emprestimos) {
      if (emprestimo.getUsuario().getId().equals(usuario.getId())) {
        emprestimoService.deletarEmprestimo(emprestimo);
        // usuarioService.deletarUsuario(usuario);
        // String showDiv = "listaUsuarios";
        String mensagem = "Emprestimo(s) do usuário apagado(s)!";
        // model.addAttribute("showDiv", showDiv);
        // model.addAttribute("usuarios", usuarioService.getListaUsuarios());
        model.addAttribute("mensagem", mensagem);
        // return "index";
      }
    }
    usuarioService.deletarUsuario(usuario);
    List<Usuario> usuarios = usuarioService.getListaUsuarios();
    model.addAttribute("usuarios", usuarios);
    String showDiv = "listaUsuarios";
    model.addAttribute("showDiv", showDiv);

    return "index";
  }

}
