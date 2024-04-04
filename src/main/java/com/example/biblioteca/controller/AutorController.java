package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.service.AutorService;
import com.example.biblioteca.service.LivroService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/autor")
public class AutorController {
  
  @Autowired
  AutorService autorService;

  @Autowired
  LivroService livroService;

  // @RequestMapping("/showForm")
  // public String showFormAutor(Model model) {
    

  //   return "autor/formAutor";
  // }

  @RequestMapping("/showForm")
  public String showFormAutor(Model model) {
    
    Autor autor = new Autor();
    model.addAttribute("autor", autor);
    String showDiv = "formAutor";
    model.addAttribute("showDiv", showDiv);

    return "index";
  }
  
  @RequestMapping("/addAutor")
  public String addAutor(@ModelAttribute("autor") Autor autor, Model model) {

    return "autor/listaAutores";
  }

  @RequestMapping("/getListaAutores")
  public String getListaAutores(Model model) {

    List<Autor> autores = autorService.getListaAutores();
    model.addAttribute("autores", autores);
    String showDiv = "listaAutores";
    model.addAttribute("showDiv", showDiv);
    return "index";
  }

  @RequestMapping("/deletarAutor")
  public String deletarAutor(Integer id, Model model) {

    return "autor/listaAutores";
  }
}
