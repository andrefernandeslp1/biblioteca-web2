package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.biblioteca.model.Editora;

public interface EditoraRepository extends JpaRepository<Editora,Integer>{
  
}
