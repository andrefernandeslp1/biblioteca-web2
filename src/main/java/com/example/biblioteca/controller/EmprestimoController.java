package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.service.EmprestimoService;
import com.example.biblioteca.service.LivroService;
import com.example.biblioteca.service.UsuarioService;

@Controller
@RequestMapping("/emprestimo")
public class EmprestimoController {
  
  @Autowired
  EmprestimoService emprestimoService;

  @Autowired
  LivroService livroService;

  @Autowired
  UsuarioService usuarioService;

  @RequestMapping("/showForm")
  public String showFormEmprestimo(Model model) {
    

    return "emprestimo/formEmprestimo";
  }

  @RequestMapping("/addEmprestimo")
  public String addEmprestimo(@ModelAttribute("emprestimo") Emprestimo emprestimo, Model model) {

    return "emprestimo/listaEmprestimos";
  }

  @RequestMapping("/getListaEmprestimos")
  public String getListaEmprestimos(Model model) {

    List<Emprestimo> emprestimos = emprestimoService.getListaEmprestimos();
    model.addAttribute("emprestimos", emprestimos);
    return "emprestimo/listaEmprestimos";
  }

  @RequestMapping("/deletarEmprestimo")
  public String deletarEmprestimo(Integer id, Model model) {

    return "emprestimo/listaEmprestimos";
  }

}
