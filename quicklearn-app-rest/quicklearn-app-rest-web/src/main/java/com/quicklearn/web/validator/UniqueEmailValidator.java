package com.quicklearn.web.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.quicklearn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.quicklearn.web.Impl.UserServiceImpl;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	private UserServiceImpl userServiceimpl;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		Optional <User> userOptional = Optional.ofNullable(userServiceimpl.findUserByEmail(value));
		
		if(userOptional.isPresent()) {
			System.out.println("Check email exist"+userOptional.get().getEmail()+"  AND "+value);
			return false;
		}
		else  {
			return true;
		}
	}

}
