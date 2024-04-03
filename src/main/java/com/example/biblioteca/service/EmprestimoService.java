package com.example.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.repository.EmprestimoRepository;

@Component
public class EmprestimoService {
  
  @Autowired
  EmprestimoRepository emprestimoRepository;

  public void salvarEmprestimo(Emprestimo emprestimo) {
    emprestimoRepository.save(emprestimo);
  }

  public void deletarEmprestimo(Emprestimo emprestimo) {
    emprestimoRepository.delete(emprestimo);
  }

  public List<Emprestimo> getListaEmprestimos() {
    return emprestimoRepository.findAll();
  }

  public Emprestimo getEmprestimoById(Integer id) {
    return emprestimoRepository.findById(id).map(emprestimo -> {
      return emprestimo;
    }).orElseThrow(() -> new RuntimeException("Emprestimo não encontrado"));
  }
  
}
