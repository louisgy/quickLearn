package com.quicklearn.web.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.quicklearn.web.service.PasswordMatchInterface;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, PasswordMatchInterface>{

	@Override
	public boolean isValid(PasswordMatchInterface obj, ConstraintValidatorContext context) {
		PasswordMatchInterface user = (PasswordMatchInterface)obj;
		return user.getPassword().equals(user.getMatchingPassword());
	}
	
}