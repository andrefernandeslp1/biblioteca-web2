package com.example.biblioteca.controller;

import org.springframework.stereotype.Controller;
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
  
}