package com.example.biblioteca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.model.Editora;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.AutorRepository;
import com.example.biblioteca.repository.EditoraRepository;
import com.example.biblioteca.repository.LivroRepository;

@SpringBootApplication
public class BibliotecaApplication {

  @Autowired
  AutorRepository autorRepository;

  @Autowired
  LivroRepository livroRepository;

  @Autowired
  EditoraRepository editoraRepository;

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

      Livro livro1 = new Livro("It", "Terror", "1986", editora1);
      Livro livro2 = new Livro("Hamlet", "Drama", "1600", editora2);
      Livro livro3 = new Livro("Dom Casmurro", "Romance", "1899", editora3);
      
      List<Livro> livros1 = new ArrayList<>();
      livros1.add(livro1);
      List<Livro> livros2 = new ArrayList<>();
      livros2.add(livro2);
      List<Livro> livros3 = new ArrayList<>();
      livros3.add(livro3);

      autorRepository.save(autor1);
      autorRepository.save(autor2);
      autorRepository.save(autor3);

      List<Autor> autores1 = new ArrayList<>();
      autores1.add(autor1);
      List<Autor> autores2 = new ArrayList<>();
      autores2.add(autor2);
      List<Autor> autores3 = new ArrayList<>();
      autores3.add(autor3);

      livro1.setAutores(autores1);
      livro2.setAutores(autores2);
      livro3.setAutores(autores3);

      livroRepository.save(livro1);
      livroRepository.save(livro2);
      livroRepository.save(livro3);

      








    };

  }

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

}
