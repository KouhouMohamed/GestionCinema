<<<<<<< HEAD
package com.kouhou.jee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	public Role findByLabel(String label); 
}
=======
package com.kouhou.jee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	public Role findByLabel(String label); 
}
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
