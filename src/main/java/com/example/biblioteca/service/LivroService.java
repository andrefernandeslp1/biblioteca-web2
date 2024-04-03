package com.example.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;

@Component
public class LivroService {
  
  @Autowired
  LivroRepository livroRepository;

  public void salvarLivro(Livro livro) {
    livroRepository.save(livro);
  }

  public void deletarLivro(Livro livro) {
    livroRepository.delete(livro);
  }

  public List<Livro> getListaLivros() {
    return livroRepository.findAll();
  }

  public Livro getLivroById(Integer id) {
    return livroRepository.findById(id).map(livro -> {
      return livro;
    }).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
  }

}
