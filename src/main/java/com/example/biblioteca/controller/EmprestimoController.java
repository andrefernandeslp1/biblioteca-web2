package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    Emprestimo emprestimo = new Emprestimo();
    model.addAttribute("emprestimo", emprestimo);
    model.addAttribute("livros", livroService.getListaLivros());
    model.addAttribute("usuarios", usuarioService.getListaUsuarios());
    String showDiv = "formEmprestimo";
    model.addAttribute("showDiv", showDiv);

    return "index";
  }

  @RequestMapping("/addEmprestimo")
  public String addEmprestimo(@ModelAttribute("emprestimo") Emprestimo emprestimo, Model model) {

    List<Emprestimo> emprestimosVerificar = emprestimoService.getListaEmprestimos();
    for (Emprestimo emprestimoVerificar : emprestimosVerificar) {
      if (emprestimoVerificar.getLivro().getId().equals(emprestimo.getLivro().getId())) {
        if (emprestimoVerificar.getDevolvido() == false) {
          String showDiv = "listaEmprestimos";
          String mensagem = "Livro já emprestado!";
          model.addAttribute("showDiv", showDiv);
          model.addAttribute("emprestimos", emprestimosVerificar);
          model.addAttribute("mensagem", mensagem);
          return "index";
        }
        // String showDiv = "listaEmprestimos";
        // String mensagem = "Livro já emprestado!";
        // model.addAttribute("showDiv", showDiv);
        // model.addAttribute("emprestimos", emprestimosVerificar);
        // model.addAttribute("mensagem", mensagem);
        // return "index";
      }
    }

    emprestimoService.salvarEmprestimo(emprestimo);
    List<Emprestimo> emprestimos = emprestimoService.getListaEmprestimos();
    model.addAttribute("emprestimos", emprestimos);
    String showDiv = "listaEmprestimos";
    model.addAttribute("showDiv", showDiv);

    return "index";
  }

  @RequestMapping("/getListaEmprestimos")
  public String getListaEmprestimos(Model model) {

    List<Emprestimo> emprestimos = emprestimoService.getListaEmprestimos();
    model.addAttribute("emprestimos", emprestimos);
    String showDiv = "listaEmprestimos";
    model.addAttribute("showDiv", showDiv);

    return "index";
  }

  @RequestMapping("/devolverEmprestimo") 
  public String devolverEmprestimo(Model model, Integer id) {
    
    Emprestimo emprestimo = emprestimoService.getEmprestimoById(id);
    emprestimo.setDevolvido();
    emprestimoService.salvarEmprestimo(emprestimo);
        
    List<Emprestimo> emprestimos = emprestimoService.getListaEmprestimos();
    model.addAttribute("emprestimos", emprestimos);
    String showDiv = "listaEmprestimos";
    model.addAttribute("showDiv", showDiv);

    return "index";
  }

}
