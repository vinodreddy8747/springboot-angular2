package com.abc.xyz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.xyz.model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

	List<Token> findByEmailId(String email);

	List<Token> findByUserIDAndAuthenticationToken(int emailId, String token);
}
