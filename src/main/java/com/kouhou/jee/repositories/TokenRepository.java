package com.kouhou.jee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.VerificationToken;

@Repository
public interface TokenRepository extends JpaRepository<VerificationToken, Long>{
	public VerificationToken findByToken(String token); 
}
