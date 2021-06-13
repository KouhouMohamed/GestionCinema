package com.kouhou.jee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	public Role findByLabel(String label); 
}