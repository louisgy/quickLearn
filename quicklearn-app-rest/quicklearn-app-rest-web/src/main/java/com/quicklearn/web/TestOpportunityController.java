package com.quicklearn.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quicklearn.web.Impl.TestOpportunityServiceImpl;
import com.quicklearn.web.dto.TestOpportunityDTO;
import com.quicklearn.web.error.FieldErrorDTO;
import com.quicklearn.web.error.ValidationResultDTO;

@RestController
public class TestOpportunityController {
	
	@Autowired
	TestOpportunityServiceImpl testOpportunityServiceImpl;

	
	@PostMapping("/TestOpportunity")
	public  ResponseEntity<ValidationResultDTO>  saveTestOpportunity (@RequestBody TestOpportunityDTO newOpportunityDTO, BindingResult bindingResult) {

		ValidationResultDTO validationResultDto = new ValidationResultDTO();

		
		if(bindingResult.hasErrors()) {
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();

			List<FieldErrorDTO> fieldErrorDTOs = fieldErrors.stream().map(FieldErrorDTO::new)
					.collect(Collectors.toList());

			validationResultDto.setFieldErrors(fieldErrorDTOs);

			return new ResponseEntity<>(validationResultDto, HttpStatus.BAD_REQUEST);

		} else if (testOpportunityServiceImpl.saveTestOpportunity(newOpportunityDTO) != null) {

			validationResultDto.addGlobalError("Test Opportunity successfully created");

			return new ResponseEntity<>(validationResultDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationResultDTO(), HttpStatus.BAD_REQUEST);

	}
	
}
