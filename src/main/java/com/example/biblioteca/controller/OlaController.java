package com.example.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaController {

  @GetMapping("/")
  public String showMenu() {
    return "menu";
  }

  @RequestMapping("/index")
  public String showIndex() {
    return "index";
  }

  @RequestMapping("/mapeamento")
  public String showMapeamento(Model model) {

    String showDiv = "mapeamento";
    model.addAttribute("showDiv", showDiv);

    return "index";
  }
  
}
