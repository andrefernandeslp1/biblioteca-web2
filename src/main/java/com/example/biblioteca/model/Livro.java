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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(length = 100)
  private String titulo;

  @Column(length = 100)
  private String genero;

  @Column(length = 100)
  private String ano;

  @ManyToOne
  @JoinColumn(name = "id_editora")
  private Editora editora;

  @OneToMany(mappedBy = "livro", fetch = FetchType.LAZY)
  private List<Emprestimo> emprestimos;

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
  @JoinTable(name = "livro_autor",
  joinColumns = @JoinColumn(name = "id_livro"),
  inverseJoinColumns = @JoinColumn(name = "id_autor"))
  private List<Autor> autores;

  public Livro() {
  }

  public Livro(String titulo, String genero, String ano, Editora editora) {
    this.titulo = titulo;
    this.genero = genero;
    this.ano = ano;
    this.editora = editora;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getAno() {
    return ano;
  }

  public void setAno(String ano) {
    this.ano = ano;
  }

  public Editora getEditora() {
    return editora;
  }

  public void setEditora(Editora editora) {
    this.editora = editora;
  }

  public List<Autor> getAutores() {
    return autores;
  }

  public void setAutores(List<Autor> autores) {
    this.autores = autores;
  }

  @Override
  public String toString() {
    return "Livro{" +
            "id=" + id +
            ", titulo='" + titulo + '\'' +
            ", genero='" + genero + '\'' +
            ", ano=" + ano +
            ", editora=" + editora +
            ", autores=" + autores +
            '}';
  }

  @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((ano == null) ? 0 : ano.hashCode());
      result = prime * result + ((autores == null) ? 0 : autores.hashCode());
      result = prime * result + ((editora == null) ? 0 : editora.hashCode());
      result = prime * result + ((genero == null) ? 0 : genero.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
      return result;
    }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Livro other = (Livro) obj;
    if (ano == null) {
      if (other.ano != null) {
        return false;
      }
    } else if (!ano.equals(other.ano)) {
      return false;
    }
    if (autores == null) {
      if (other.autores != null) {
        return false;
      }
    } else if (!autores.equals(other.autores)) {
      return false;
    }
    if (editora == null) {
      if (other.editora != null) {
        return false;
      }
    } else if (!editora.equals(other.editora)) {
      return false;
    }
    if (genero == null) {
      if (other.genero != null) {
        return false;
      }
    } else if (!genero.equals(other.genero)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (titulo == null) {
      if (other.titulo != null) {
        return false;
      }
    } else if (!titulo.equals(other.titulo)) {
      return false;
    }
    return true;
  }
  
}

