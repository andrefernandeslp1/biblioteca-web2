package com.example.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OlaController {

  @GetMapping("/")
  public String showMenu() {
    return "menu";
  }
  
}
