package com.quicklearn.web.ValidatorImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.quicklearn.web.Impl.UserServiceImpl;
import com.quicklearn.web.dto.UserLoginDTO;
import com.quicklearn.web.validator.CredentialMatches;

public class CredentialMatchesValidator implements ConstraintValidator<CredentialMatches, Object> {
//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private UserServiceImpl userServiceimpl;

	@Override
	public void initialize(final CredentialMatches constraintAnnotation) {
		//
	}

	@Override
	public boolean isValid(final Object obj, final ConstraintValidatorContext context) {

		final UserLoginDTO user = (UserLoginDTO) obj;
		
		return userServiceimpl.authenticate(user);

		//return isCredentialCorrect(user);
	}

}
