package com.example.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.repository.AutorRepository;

@SpringBootApplication
public class BibliotecaApplication {

  @Autowired
  AutorRepository autorRepository;

  @Bean
  public CommandLineRunner init(){
    return args -> {

      autorRepository.save(new Autor("André", "Brasileiro"));



      

    };

  }

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

}
