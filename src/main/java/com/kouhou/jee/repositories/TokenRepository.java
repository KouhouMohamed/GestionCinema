<<<<<<< HEAD
package com.kouhou.jee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.VerificationToken;

@Repository
public interface TokenRepository extends JpaRepository<VerificationToken, Long>{
	public VerificationToken findByToken(String token); 
}
=======
package com.kouhou.jee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kouhou.jee.entities.VerificationToken;

@Repository
public interface TokenRepository extends JpaRepository<VerificationToken, Long>{
	public VerificationToken findByToken(String token); 
}
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
