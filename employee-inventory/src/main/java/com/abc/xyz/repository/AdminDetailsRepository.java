package com.abc.xyz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.xyz.model.AdminDetail;

public interface AdminDetailsRepository extends JpaRepository<AdminDetail, Long>{

	  List<AdminDetail> findByEmailIdAndPassword(String emailId, String password);
}
