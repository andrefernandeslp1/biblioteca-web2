package com.example.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.biblioteca.model.Editora;
import com.example.biblioteca.repository.EditoraRepository;

@Component
public class EditoraService {
  
  @Autowired
  EditoraRepository editoraRepository;

  public void salvarEditora(Editora editora) {
    editoraRepository.save(editora);
  }

  public void deletarEditora(Editora editora) {
    editoraRepository.delete(editora);
  }

  public List<Editora> getListaEditoras() {
    return editoraRepository.findAll();
  }

  public Editora getEditoraById(Integer id) {
    return editoraRepository.findById(id).map(editora -> {
      return editora;
    }).orElseThrow(() -> new RuntimeException("Editora não encontrada"));
  }
  
}
