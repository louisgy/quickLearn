package com.quicklearn.web.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.springframework.beans.factory.annotation.Autowired;

import com.quicklearn.web.Impl.UserServiceImpl;




@Documented
@Retention(RUNTIME)
@Target({FIELD, TYPE, ANNOTATION_TYPE })
@Constraint(validatedBy = StudentExistenceValidator.class)
public @interface StudentExistence {
	String message() default "Unable to identify student";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

class StudentExistenceValidator implements ConstraintValidator<StudentExistence, Integer> {
	@Autowired
	public UserServiceImpl userserviceImpl;
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		
		return userserviceImpl.studentExist(value);

	}
	
}

