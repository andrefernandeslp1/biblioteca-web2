package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.biblioteca.model.Editora;
import com.example.biblioteca.service.EditoraService;
import com.example.biblioteca.service.LivroService;

@Controller
@RequestMapping("/editora")
public class EditoraController {
  
  @Autowired
  EditoraService editoraService;

  @Autowired
  LivroService livroService;

  @RequestMapping("/showForm")
  public String showFormEditora(Model model) {
    
    Editora editora = new Editora();
    model.addAttribute("editora", editora);
    String showDiv = "formEditora";
    model.addAttribute("showDiv", showDiv);

    return "index";
  }

  @RequestMapping("/addEditora")
  public String addEditora(@ModelAttribute("editora") Editora editora, Model model) {

    List<Editora> editorasVerificar = editoraService.getListaEditoras();
    for (Editora editoraVerificar : editorasVerificar) {
      if (editoraVerificar.getNome().equals(editora.getNome())) {
        String showDiv = "listaEditoras";
        String mensagem = "Editora já cadastrada!";
        model.addAttribute("showDiv", showDiv);
        model.addAttribute("editoras", editorasVerificar);
        model.addAttribute("mensagem", mensagem);
        return "index";
      }
    }

    editoraService.salvarEditora(editora);
    List<Editora> editoras = editoraService.getListaEditoras();
    model.addAttribute("editoras", editoras);
    String showDiv = "listaEditoras";
    model.addAttribute("showDiv", showDiv);

    return "index";
  }

  @RequestMapping("/getListaEditoras")
  public String getListaEditoras(Model model) {

    List<Editora> editoras = editoraService.getListaEditoras();
    model.addAttribute("editoras", editoras);
    String showDiv = "listaEditoras";
    model.addAttribute("showDiv", showDiv);

    return "index";
  }

  @RequestMapping("/deletarEditora")
  public String deletarEditora(Integer id, Model model) {

    return "editora/listaEditoras";
  }
  
}
