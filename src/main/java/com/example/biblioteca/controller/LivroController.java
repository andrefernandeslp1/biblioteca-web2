package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.service.AutorService;
import com.example.biblioteca.service.EditoraService;
import com.example.biblioteca.service.EmprestimoService;
import com.example.biblioteca.service.LivroService;

@Controller
@RequestMapping("/livro")
public class LivroController {
  
  @Autowired
  LivroService livroService;

  @Autowired
  AutorService autorService;

  @Autowired
  EditoraService editoraService;

  @Autowired
  EmprestimoService emprestimoService;

  @RequestMapping("/showForm")
  public String showFormLivro(Model model) {
    

    return "livro/formLivro";
  }

  @RequestMapping("/addLivro")
  public String addLivro(@ModelAttribute("livro") Livro livro, Model model) {

    return "livro/listaLivros";
  }

  @RequestMapping("/getListaLivros")
  public String getListaLivros(Model model) {

    List<Livro> livros = livroService.getListaLivros();
    model.addAttribute("livros", livros);
    return "livro/listaLivros";
  }

  @RequestMapping("/deletarLivro")
  public String deletarLivro(Integer id, Model model) {

    return "livro/listaLivros";
  }

}
