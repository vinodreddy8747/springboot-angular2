package com.abc.xyz.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.xyz.model.AdminDetail;
import com.abc.xyz.model.Token;
import com.abc.xyz.resource.AdminService;
import com.abc.xyz.resource.TokenService;
import com.abc.xyz.util.GenerateToken;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class AdminApi {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private TokenService tokenService;
	
	GenerateToken generateToken = new GenerateToken();
	
	@PostMapping("/saveAdmin")
	public AdminDetail saveAdminDetail(@RequestBody AdminDetail adminDetail) {
		return adminService.saveAdminDetail(adminDetail);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Integer> login(@RequestBody AdminDetail adminDetail)
	{
		int status;
		HttpHeaders httpHeader = null;
	
		// Authenticate User.
		List<AdminDetail>  list = adminService.adminLogin(adminDetail.getEmailId(), adminDetail.getPassword());
		
		if(list != null && list.size() > 0) {
			status = list.get(0).getAdminID();
		}else {
			status = -1;
		}
		/*
		 * If User is authenticated then Do Authorization Task.
		 */
		if (list.size() > 0) 
		{
			/*
			 * Generate token.
			 */
			String tokenData[] = generateToken.createJWT(adminDetail.getEmailId(), "JavaTpoint", "JWT Token",
					adminDetail.getRole(), 43200000);
			
			// get Token.
			String token = tokenData[0];
			
			System.out.println("Authorization :: " + token);

			// Create the Header Object
			httpHeader = new HttpHeaders();

			// Add token to the Header.
			httpHeader.add("Authorization", token);

			// Check if token is already exist.
			List<Token> tokenList =  tokenService.getTokenDetail(adminDetail.getEmailId());
			long isUserEmailExists = 0;
			if(tokenList != null && tokenList.size() > 0) {
				isUserEmailExists = tokenList.get(0).getTokenID();
			}
			
			/*
			 * If token exist then update Token else create and insert the token.
			 */
			if (isUserEmailExists > 0) 
			{
				tokenService.updateToken(adminDetail.getEmailId(), token, tokenData[1]);
			} 
			else 
			{
				tokenService.saveUserEmail(adminDetail.getEmailId(), status);
				tokenService.updateToken(adminDetail.getEmailId(), token, tokenData[1]);
			}

			return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);
		} 
		
		// if not authenticated return  status what we get.
		else 
		{
			return new ResponseEntity<Integer>(status, httpHeader, HttpStatus.OK);
		}
		

	}
	
	
	@GetMapping("/getAdminData/{adminId}")
	public List<AdminDetail> getAdminData(@PathVariable int adminId, @RequestHeader("Authorization") String authorizationToken)
	{
		String token[] = authorizationToken.split(" ");
		int result = tokenService.tokenAuthentication(token[1], adminId);
		
		if (result > 0) {
			return adminService.getAdminData();
		} else {
			return null;
		}
	}
}
