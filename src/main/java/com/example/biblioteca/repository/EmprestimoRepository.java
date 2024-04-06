package com.example.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.biblioteca.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo,Integer>{

    // recupera lista de emprestimos ativos
    @Query(value = "select e from Emprestimo e where e.devolvido = false")
    List<Emprestimo> listarEmprestimosAtivos();
  
}
