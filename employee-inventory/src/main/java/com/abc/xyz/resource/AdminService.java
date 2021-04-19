package com.abc.xyz.resource;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.xyz.model.AdminDetail;
import com.abc.xyz.repository.AdminDetailsRepository;

@Service
public class AdminService {
	@Autowired
	private AdminDetailsRepository adminRepository;

	@Transactional
	public AdminDetail saveAdminDetail(AdminDetail adminDetail) {
		return adminRepository.save(adminDetail);
	}
	
	@Transactional
	public List<AdminDetail> adminLogin(String emailId, String password) {
		return adminRepository.findByEmailIdAndPassword(emailId, password);
	}

	@Transactional
	public List<AdminDetail> getAdminData() {
		return adminRepository.findAll();
	}
}
