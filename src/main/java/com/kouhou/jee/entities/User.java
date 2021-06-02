package com.kouhou.jee.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Size(max = 20,min = 3,message = "This feild should contient at least 3 chars")
	private String username;

	
	@Size(min = 8,message = "This feild should contient at least 8 chars")
	private String password;
	
	@Size(max = 30,min = 13,message = "This feild should contient at least 13 chars")
	private String email;
	
	private boolean enabled;
	
	@ManyToMany()
    @JoinTable(name = "USER_ROLES",
            joinColumns =@JoinColumn(name = "USER_ID"),
            inverseJoinColumns =@JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles = new HashSet<>();
}
