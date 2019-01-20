package com.quicklearn.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.quicklearn.web.Impl.CourseServiceImpl;
import com.quicklearn.web.dto.CourseDTO;

@Component
public class CourseValidator implements Validator {
	@Autowired
	private CourseServiceImpl courseServiceImpl;

	@Override
	public boolean supports(Class<?> clazz) {
		return CourseDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "categorie", "categorie.empty", "Category is empty");
		ValidationUtils.rejectIfEmpty(errors, "domain", "domain.empty", "Domain is empty");
		ValidationUtils.rejectIfEmpty(errors, "title", "title.empty", "Title is empty");
		ValidationUtils.rejectIfEmpty(errors, "description", "description.empty", "description is empty");
		ValidationUtils.rejectIfEmpty(errors, "code", "code.empty", "code is empty");
		CourseDTO t = (CourseDTO) target;
		
		if (!courseServiceImpl.isCodeExist(t.getCode()))
			errors.rejectValue("Code", "", "Categorie already used");

		if (!courseServiceImpl.isTitleExist(t.getTitle()))
			errors.rejectValue("title", "","Title already used");
	
		
	}

}
