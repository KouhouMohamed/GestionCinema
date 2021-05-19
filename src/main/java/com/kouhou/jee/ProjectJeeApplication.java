package com.kouhou.jee;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kouhou.jee.entities.Film;
import com.kouhou.jee.repositories.FilmRepository;

@SpringBootApplication
public class ProjectJeeApplication implements CommandLineRunner {

	@Autowired
	private FilmRepository filmRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProjectJeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		filmRepository.save(new Film(null,"Baba ALi",1.5,"Ahmed Ntama","Amazigh film","photo.jpg",new Date(),null,null));
	}

}
