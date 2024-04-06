package com.example.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.biblioteca.model.Autor;

public interface AutorRepository extends JpaRepository<Autor,Integer>{

  // recupera lista de autores do banco de dados
  @Query(value = "select a from Autor a")
  List<Autor> listarAutores();
  
}
