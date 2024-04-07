package com.example.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.model.Editora;
import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.repository.EditoraRepository;
import com.example.biblioteca.repository.EmprestimoRepository;
import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.repository.UsuarioRepository;

@SpringBootApplication
public class BibliotecaApplication {

  @Autowired
  AutorRepository autorRepository;

  @Autowired
  LivroRepository livroRepository;

  @Autowired
  EditoraRepository editoraRepository;

  @Autowired
  UsuarioRepository usuarioRepository;

  @Autowired
  EmprestimoRepository emprestimoRepository;

  @Bean
  public CommandLineRunner init(){
    return args -> {

      Editora editora1 = new Editora("Editora Abril", "Brasil");
      Editora editora2 = new Editora("Editora Globo", "Brasil");
      Editora editora3 = new Editora("Editora Record", "Brasil");

      editoraRepository.save(editora1);
      editoraRepository.save(editora2);
      editoraRepository.save(editora3);

      Autor autor1 = new Autor("Stephen King", "EUA");
      Autor autor2 = new Autor("Shakespeare", "Reino Unido");
      Autor autor3 = new Autor("Machado de Assis", "Brasil");

      autorRepository.save(autor1);
      autorRepository.save(autor2);
      autorRepository.save(autor3);

      Livro livro1 = new Livro("It", "Terror", "1986", editora1);
      Livro livro2 = new Livro("Hamlet", "Drama", "1600", editora2);
      Livro livro3 = new Livro("Dom Casmurro", "Romance", "1899", editora3);
      Livro livro4 = new Livro("O Iluminado", "Terror", "1977", editora1);
      Livro livro5 = new Livro("Macbeth", "Drama", "1606", editora2);
      Livro livro6 = new Livro("Memórias Póstumas de Brás Cubas", "Romance", "1881", editora3);
      
      List<Livro> livros1 = new ArrayList<>();
      List<Livro> livros2 = new ArrayList<>();
      List<Livro> livros3 = new ArrayList<>();
      livros1.add(livro1);
      livros2.add(livro2);
      livros3.add(livro3);
      livros1.add(livro4);
      livros2.add(livro5);
      livros3.add(livro6);

      List<Autor> autores1 = new ArrayList<>();
      List<Autor> autores2 = new ArrayList<>();
      List<Autor> autores3 = new ArrayList<>();
      autores1.add(autor1);
      autores2.add(autor2);
      autores3.add(autor3);

      livro1.setAutores(autores1);
      livro2.setAutores(autores2);
      livro3.setAutores(autores3);
      livro4.setAutores(autores1);
      livro5.setAutores(autores2);
      livro6.setAutores(autores3);

      livroRepository.save(livro1);
      livroRepository.save(livro2);
      livroRepository.save(livro3);
      livroRepository.save(livro4);
      livroRepository.save(livro5);
      livroRepository.save(livro6);

      Usuario usuario1 = new Usuario("João", "joao@email.com");
      Usuario usuario2 = new Usuario("Maria", "maria@email.com");
      Usuario usuario3 = new Usuario("José", "jose@email.com");
      Usuario usuario4 = new Usuario("Ana", "ana@email.com");
      Usuario usuario5 = new Usuario("Pedro", "pedro@email.com");
      Usuario usuario6 = new Usuario("Carla", "carla@email.com");

      usuarioRepository.save(usuario1);
      usuarioRepository.save(usuario2);
      usuarioRepository.save(usuario3);
      usuarioRepository.save(usuario4);
      usuarioRepository.save(usuario5);
      usuarioRepository.save(usuario6);

      Emprestimo emprestimo1 = new Emprestimo(usuario1, livro1);
      Emprestimo emprestimo2 = new Emprestimo(usuario2, livro2);
      Emprestimo emprestimo3 = new Emprestimo(usuario3, livro3);

      emprestimoRepository.save(emprestimo1);
      emprestimoRepository.save(emprestimo2);
      emprestimoRepository.save(emprestimo3);

      
    };

  }

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

}
