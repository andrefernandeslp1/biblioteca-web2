package com.example.biblioteca.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 100)
  private LocalDate dataEmprestimo;

  @Column(length = 100)
  private LocalDate dataDevolucao;

  @ManyToOne
  @JoinColumn(name = "id_usuario")
  private Usuario usuario;

  @ManyToOne
  @JoinColumn(name = "id_livro")
  private Livro livro;

  @Column(length = 100)
  private Boolean devolvido;

  public Emprestimo() {
    this.dataEmprestimo = LocalDate.now();
    this.devolvido = false;
  }

  public Emprestimo(Usuario usuario, Livro livro) {
    this.dataEmprestimo = LocalDate.now();
    this.usuario = usuario;
    this.livro = livro;
    this.devolvido = false;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDate getDataEmprestimo() {
    return dataEmprestimo;
  }

  public void setDataEmprestimo(LocalDate dataEmprestimo) {
    this.dataEmprestimo = dataEmprestimo;
  }

  public LocalDate getDataDevolucao() {
    return dataDevolucao;
  }

  public void setDataDevolucao(LocalDate dataDevolucao) {
    this.dataDevolucao = dataDevolucao;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Livro getLivro() {
    return livro;
  }

  public void setLivro(Livro livro) {
    this.livro = livro;
  }

  public Boolean getDevolvido() {
    return devolvido;
  }

  public void setDevolvido() {
    this.dataDevolucao = LocalDate.now();
    this.devolvido = true;
  }

  @Override
  public String toString() {
    return "Emprestimo{" +
            "id=" + id +
            ", dataEmprestimo='" + dataEmprestimo + '\'' +
            ", dataDevolucao='" + dataDevolucao + '\'' +
            ", usuario=" + usuario +
            ", livro=" + livro +
            ", devolvido=" + devolvido +
            '}';
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dataDevolucao == null) ? 0 : dataDevolucao.hashCode());
    result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((livro == null) ? 0 : livro.hashCode());
    result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
    result = prime * result + ((devolvido == null) ? 0 : devolvido.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Emprestimo other = (Emprestimo) obj;
    if (dataDevolucao == null) {
      if (other.dataDevolucao != null)
        return false;
    } else if (!dataDevolucao.equals(other.dataDevolucao))
      return false;
    if (dataEmprestimo == null) {
      if (other.dataEmprestimo != null)
        return false;
    } else if (!dataEmprestimo.equals(other.dataEmprestimo))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (livro == null) {
      if (other.livro != null)
        return false;
    } else if (!livro.equals(other.livro))
      return false;
    if (usuario == null) {
      if (other.usuario != null)
        return false;
    } else if (!usuario.equals(other.usuario))
      return false;
    if (devolvido == null) {
      if (other.devolvido != null)
        return false;
    } else if (!devolvido.equals(other.devolvido))
      return false;
    return true;
  }

}
