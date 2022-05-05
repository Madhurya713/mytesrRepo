package com.test.service;

import java.util.List;
import java.util.Optional;

import com.test.model.FormSubmissionModel;

public interface IFormSubmissionService {

	public void saveform(FormSubmissionModel formData);

	

	public List<FormSubmissionModel> detailsByName(String name);
	
	public Boolean isExitByName(String name);

	public boolean isExitBymobileNumber(String mobileNumber);



	public boolean isExitById(Integer id);



	public FormSubmissionModel detailsByMobileNumber(String mobileNumber);



	public FormSubmissionModel detailsByEmail(String email);



	public boolean isExitByEmail(String email);

}
