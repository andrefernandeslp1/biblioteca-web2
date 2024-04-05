package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.model.Editora;
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
    
    Livro livro = new Livro();
    model.addAttribute("livro", livro);
    List<Autor> autores = autorService.getListaAutores();
    model.addAttribute("autores", autores);
    List<Editora> editoras = editoraService.getListaEditoras();
    model.addAttribute("editoras", editoras);
    String showDiv = "formLivro";
    model.addAttribute("showDiv", showDiv);

    return "index";
  }

  @RequestMapping("/addLivro")
  public String addLivro(@ModelAttribute("livro") Livro livro, Model model) {

    List<Livro> livrosVerificar = livroService.getListaLivros();
    for (Livro livroVerificar : livrosVerificar) {
      if (livroVerificar.getTitulo().equals(livro.getTitulo())) {
        String showDiv = "listaLivros";
        String mensagem = "Livro já cadastrado!";
        model.addAttribute("showDiv", showDiv);
        model.addAttribute("livros", livrosVerificar);
        model.addAttribute("mensagem", mensagem);
        return "index";
      }
    }

    livroService.salvarLivro(livro);
    //atribuir livro a autores
    for (Autor autor : livro.getAutores()) {
      autor.getLivros().add(livro);
      autorService.salvarAutor(autor);
    }
    List<Livro> livros = livroService.getListaLivros();
    model.addAttribute("livros", livros);
    String showDiv = "listaLivros";
    model.addAttribute("showDiv", showDiv);
    
    return "index";
  }

  @RequestMapping("/getListaLivros")
  public String getListaLivros(Model model) {

    List<Livro> livros = livroService.getListaLivros();
    model.addAttribute("livros", livros);
    String showDiv = "listaLivros";
    model.addAttribute("showDiv", showDiv);
    
    return "index";
  }

  @RequestMapping("/deletarLivro")
  public String deletarLivro(Integer id, Model model) {

    return "livro/listaLivros";
  }

}
