package com.example.biblioteca.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "editora")
public class Editora {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 100)
  private String nome;

  @Column(length = 100)
  private String endereco;

  @OneToMany(mappedBy = "editora", fetch = FetchType.LAZY)
  private List<Livro> livros;

  public Editora() {
  }

  public Editora(String nome, String endereco) {
    this.nome = nome;
    this.endereco = endereco;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public List<Livro> getLivros() {
    return livros;
  }

  public void setLivros(List<Livro> livros) {
    this.livros = livros;
  }

  @Override
  public String toString() {
    return "Editora{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", endereco='" + endereco + '\'' +
            // ", livros=" + livros +
            '}';
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    // result = prime * result + ((livros == null) ? 0 : livros.hashCode());
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
    Editora other = (Editora) obj;
    if (endereco == null) {
      if (other.endereco != null)
        return false;
    } else if (!endereco.equals(other.endereco))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    // if (livros == null) {
    //   if (other.livros != null)
    //     return false;
    // } else if (!livros.equals(other.livros))
    //   return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    return true;
  }

}
