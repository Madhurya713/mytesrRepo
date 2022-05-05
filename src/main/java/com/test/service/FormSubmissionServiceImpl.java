package com.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Repository.FormSubmissionRepository;
import com.test.model.FormSubmissionModel;
@Service
public class FormSubmissionServiceImpl implements IFormSubmissionService {
	
	
	@Autowired
	private FormSubmissionRepository formsubmissionRepo;
	
	@Override
	public void saveform(FormSubmissionModel formData) {
		formsubmissionRepo.save(formData);
	}

	

	@Override
	public List<FormSubmissionModel> detailsByName(String name) {
		List<FormSubmissionModel> findByName = formsubmissionRepo.findByName(name);
		return findByName;
	}

	@Override
	public Boolean isExitByName(String name) {
		Boolean existsByName = formsubmissionRepo.existsByName(name);
		return existsByName;
	}



	@Override
	public boolean isExitBymobileNumber(String mobileNumber) {
		Boolean existsBymobileNumber = formsubmissionRepo.existsBymobileNumber(mobileNumber);
		return existsBymobileNumber;
	}



	@Override
	public boolean isExitById(Integer id) {
		boolean existsById = formsubmissionRepo.existsById(id);
		return existsById;
	}



	@Override
	public FormSubmissionModel detailsByMobileNumber(String mobileNumber) {
		FormSubmissionModel findBymobileNumber = formsubmissionRepo.findByMobileNumber(mobileNumber);
		return findBymobileNumber;
	}



	@Override
	public FormSubmissionModel detailsByEmail(String email) {
		FormSubmissionModel findByEmail = formsubmissionRepo.findByEmail(email);
		return findByEmail;
	}



	@Override
	public boolean isExitByEmail(String email) {
		Boolean existsByEmail = formsubmissionRepo.existsByEmail(email);
		return existsByEmail;
	}

}
