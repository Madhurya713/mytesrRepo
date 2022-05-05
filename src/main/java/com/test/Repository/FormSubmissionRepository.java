package com.test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.FormSubmissionModel;

public interface FormSubmissionRepository extends JpaRepository<FormSubmissionModel, Integer> {
	
	public List<FormSubmissionModel> findByName(String name);
		
	public FormSubmissionModel findByMobileNumber(String mobileNumber);
	
	public FormSubmissionModel findByEmail(String email);

	public Boolean existsByName(String name);
	
	public Boolean existsBymobileNumber(String mobileNumber);
	
	public Boolean existsByEmail(String email);
}
