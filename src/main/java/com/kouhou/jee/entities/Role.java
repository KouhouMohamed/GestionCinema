<<<<<<< HEAD
package com.kouhou.jee.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
public class Role {
	
	public Role(Long id, @Size(min = 3, max = 10) String label) {
		super();
		this.id = id;
		this.label = label;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,unique = true)
	@Size(min = 3,max = 10)
	private String label;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<>();
	/*@Column(nullable = true)
	@OneToMany(mappedBy = "role")
	private List<User> users;
	*/
}
=======
package com.kouhou.jee.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
public class Role {
	
	public Role(Long id, @Size(min = 3, max = 10) String label) {
		super();
		this.id = id;
		this.label = label;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,unique = true)
	@Size(min = 3,max = 10)
	private String label;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<>();
	/*@Column(nullable = true)
	@OneToMany(mappedBy = "role")
	private List<User> users;
	*/
}
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
