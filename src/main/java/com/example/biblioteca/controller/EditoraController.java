package com.example.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/editora")
public class EditoraController {
  
  @Autowired
  EditoraService editoraService;

  @Autowired
  LivroService livroService;

  @RequestMapping("/showForm")
  public String showFormEditora(Model model) {
    

    return "editora/formEditora";
  }

  @RequestMapping("/addEditora")
  public String addEditora(@ModelAttribute("editora") Editora editora, Model model) {

    return "editora/listaEditoras";
  }

  @RequestMapping("/getListaEditoras")
  public String getListaEditoras(Model model) {

    List<Editora> editoras = editoraService.getListaEditoras();
    model.addAttribute("editoras", editoras);
    return "editora/listaEditoras";
  }

  @RequestMapping("/deletarEditora")
  public String deletarEditora(Integer id, Model model) {

    return "editora/listaEditoras";
  }
  
}
