package com.kouhou.jee;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.kouhou.jee.entities.Categorie;
import com.kouhou.jee.entities.Cinema;
import com.kouhou.jee.entities.Film;
import com.kouhou.jee.entities.Role;
import com.kouhou.jee.entities.Salle;
import com.kouhou.jee.entities.User;
import com.kouhou.jee.entities.Ville;
import com.kouhou.jee.repositories.CategorieRepository;
import com.kouhou.jee.repositories.CinemaRepository;
import com.kouhou.jee.repositories.FilmRepository;
import com.kouhou.jee.repositories.RoleRepository;
import com.kouhou.jee.repositories.SalleRepository;
import com.kouhou.jee.repositories.UserRepository;
import com.kouhou.jee.repositories.VilleRepository;
import com.kouhou.jee.response.VilleResponse;

@SpringBootApplication
@EnableAsync
public class ProjectJeeApplication implements CommandLineRunner {

	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	CategorieRepository categorieRepository;
	
	@Autowired
	private VilleRepository villeRepository;
	
	@Autowired
	private CinemaRepository cinemaRepository;
	
	@Autowired
	private SalleRepository salleRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectJeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Role user_role = new Role(null,"USER");
		Role admin_role = new Role(null,"ADMIN");
		
		User user1 = new User(null, "kouhou", "139168698", "medko24@gmail.com", true,null);
		Set<Role> roles1 = new HashSet<Role>();
		roles1.add(user_role);
		roles1.add(admin_role);
		user1.setRoles(roles1);
		
		User user2 = new User(null, "mohamed", "139168698", "medko24@hotmail.com", true,null);
		Set<Role> roles2 = new HashSet<Role>();
		roles2.add(user_role);
		user1.setRoles(roles2);
		
		
		Categorie cat1 = new Categorie(null, "comedy",null);
		Categorie cat2 = new Categorie(null, "drama",null);
		
		Ville ville1 = new Ville(null,"Tata",144,888,666,null);
		Ville ville2 = new Ville(null,"Akka",6646,8548,4885,null);
		
		Cinema cinema1 = new Cinema(null,"MKouhou",178,120,111,10,ville1,null);
		Cinema cinema2 = new Cinema(null,"KMohamed",144,200,411,5,ville2,null);
	
		Salle salle1 = new Salle(null,"D13",14,cinema1,null,null);
		Salle salle2 = new Salle(null,"D12",12,cinema2,null,null);
		
		roleRepository.save(user_role);
		roleRepository.save(admin_role);
		
		userRepository.save(user1);
		userRepository.save(user2);
		
		villeRepository.save(ville1);
		villeRepository.save(ville2);
		
		cinemaRepository.save(cinema1);
		cinemaRepository.save(cinema2);
		
		salleRepository.save(salle1);
		salleRepository.save(salle2);
		
		categorieRepository.save(cat1);
		categorieRepository.save(cat2);
		
		filmRepository.save(new Film(null,"Baba ALi",1.5,"Ahmed Ntama","Amazigh film","photo.jpg",new Date(),cat1,null));
		filmRepository.save(new Film(null,"Tofla Bihi",1.5,"Katltoum Joutan","Tachlhit film","photo2.jpg",new Date(),cat2,null));
	}

}
