package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.FormSubmissionModel;
import com.test.service.IFormSubmissionService;

@RestController
@RequestMapping("/form")
public class FormSubmissionController {

	@Autowired
	private IFormSubmissionService FormSubmissionService;

	@PostMapping("/saveForm")
	public ResponseEntity<?> saveFormData(@RequestBody FormSubmissionModel formData) {
		ResponseEntity resp = null;
		try {
			if (formData.getId() != null && FormSubmissionService.isExitById(formData.getId())
					|| FormSubmissionService.isExitByEmail(formData.getEmail())
					|| FormSubmissionService.isExitBymobileNumber(formData.getMobileNumber())) {
				resp = new ResponseEntity<>("Id/Mobile Number/Email already Exist", HttpStatus.BAD_REQUEST);
			} else {
				FormSubmissionService.saveform(formData);
				resp = new ResponseEntity<>("Resource is created", HttpStatus.CREATED);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/detailsByName/{name}")
	public ResponseEntity<?> getByName(@PathVariable String name) {
		ResponseEntity resp = null;
		try {
			if (name != null && FormSubmissionService.isExitByName(name)) {
				List<FormSubmissionModel> detailsByName = FormSubmissionService.detailsByName(name);
				resp = new ResponseEntity<>(detailsByName, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/detailsByMobile/{mobileNumber}")
	public ResponseEntity<?> getByMobileNumber(@PathVariable String mobileNumber) {
		ResponseEntity resp = null;
		try {
			if (mobileNumber != null && FormSubmissionService.isExitBymobileNumber(mobileNumber)) {
				FormSubmissionModel detailsByMobileNumber = FormSubmissionService.detailsByMobileNumber(mobileNumber);
				resp = new ResponseEntity<>(detailsByMobileNumber, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/detailsByEmail/{email}")
	public ResponseEntity<?> getByEmail(@PathVariable String email) {
		ResponseEntity resp = null;
		try {
			if (email != null && FormSubmissionService.isExitByEmail(email)) {
				FormSubmissionModel detailsByEmail = FormSubmissionService.detailsByEmail(email);
				resp = new ResponseEntity<>(detailsByEmail, HttpStatus.OK);
			} else {
				resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
}
