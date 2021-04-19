package com.abc.xyz.resource;

import java.util.List;
import java.util.Optional;

import javax.swing.plaf.ListUI;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abc.xyz.model.Employee;
import com.abc.xyz.model.Token;
import com.abc.xyz.repository.TokenRepository;


@Service
public class TokenService {
	@Autowired
	private TokenRepository tokenRepository;
	
	@Transactional
	public void saveUserEmail(String email, int adminId) {
		Token token = new Token();
		token.setEmailId(email);
		token.setUserID(adminId);
		tokenRepository.save(token);
	}

	@Transactional
	public ResponseEntity<Token> updateToken(String email, String authenticationToken, String secretKey) {
		List<Token> tokenData = tokenRepository.findByEmailId(email);

		if (tokenData != null && tokenData.size() > 0) {
			Token token = tokenData.get(0);
			token.setEmailId(email);
			token.setAuthenticationToken(authenticationToken);
			token.setSecretKey(secretKey);
			return new ResponseEntity<>(tokenRepository.save(token), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Transactional
	public List<Token> getTokenDetail(String email) {
		return tokenRepository.findByEmailId(email);
	}

	@Transactional
	public int tokenAuthentication(String token, int emailId) {
		List<Token> token1 = tokenRepository.findByUserIDAndAuthenticationToken(emailId, token);
		if(token1 != null) {
			return 1;
		}else {
			return 0;
		}
	}

}
