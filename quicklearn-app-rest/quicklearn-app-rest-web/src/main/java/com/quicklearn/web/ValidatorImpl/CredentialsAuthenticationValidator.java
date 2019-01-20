package com.quicklearn.web.ValidatorImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.quicklearn.web.Impl.UserServiceImpl;

import com.quicklearn.web.validator.CredentialsAuthentication;
import com.quicklearn.web.service.UserValidationInterface;

public class CredentialsAuthenticationValidator implements ConstraintValidator<CredentialsAuthentication, UserValidationInterface> {

	
	@Autowired
	private UserServiceImpl userServiceimpl;

	@Override
	public void initialize(final CredentialsAuthentication constraintAnnotation) {
		//
	}

	@Override
	public boolean isValid(final UserValidationInterface obj, final ConstraintValidatorContext context) {

		return (userServiceimpl.authenticate(obj.getEmail(),obj.getPassword()));

	}
}
