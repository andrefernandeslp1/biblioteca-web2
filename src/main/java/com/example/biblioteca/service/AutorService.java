package com.example.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.repository.AutorRepository;

@Component
public class AutorService {

  @Autowired
  AutorRepository autorRepository;

  public void salvarAutor(Autor autor) {
    autorRepository.save(autor);
  }

  public void deletarAutor(Autor autor) {
    autorRepository.delete(autor);
  }

  public List<Autor> getListaAutores() {
    // return autorRepository.findAll();
    return autorRepository.listarAutores();
  }

  public Autor getAutorById(Integer id) {
    return autorRepository.findById(id).map(autor -> {
      return autor;
    }).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
  }

  public List<Autor> getAutoresByIds(List<Integer> ids){
    return autorRepository.findAllById(ids);}
}
