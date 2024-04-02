package com.example.biblioteca.model;

import java.util.List;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 100)
  private String nome;

  @Column(length = 100)
  private String nacionalidade;

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
  @JoinTable(name = "livro_autor",
  joinColumns = @JoinColumn(name = "id_autor"),
  inverseJoinColumns = @JoinColumn(name = "id_livro"))
  private List<Livro> livros;

  public Autor() {
  }

  public Autor(String nome, String nacionalidade) {
    this.nome = nome;
    this.nacionalidade = nacionalidade;
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

  public String getNacionalidade() {
    return nacionalidade;
  }

  public void setNacionalidade(String nacionalidade) {
    this.nacionalidade = nacionalidade;
  }

  public List<Livro> getLivros() {
    return livros;
  }

  public void setLivros(List<Livro> livros) {
    this.livros = livros;
  }

  @Override
  public String toString() {
    return "Autor{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", nacionalidade='" + nacionalidade + '\'' +
            ", livros=" + livros +
            '}';
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((livros == null) ? 0 : livros.hashCode());
    result = prime * result + ((nacionalidade == null) ? 0 : nacionalidade.hashCode());
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
        Autor other = (Autor) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (livros == null) {
            if (other.livros != null)
                return false;
        } else if (!livros.equals(other.livros))
            return false;
        if (nacionalidade == null) {
            if (other.nacionalidade != null)
                return false;
        } else if (!nacionalidade.equals(other.nacionalidade))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
}


