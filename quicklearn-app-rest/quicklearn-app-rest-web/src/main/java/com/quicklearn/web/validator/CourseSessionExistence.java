package com.quicklearn.web.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.springframework.beans.factory.annotation.Autowired;

import com.quicklearn.web.Impl.CourseSessionImpl;



@Documented
@Retention(RUNTIME)
@Target({FIELD, TYPE, ANNOTATION_TYPE })
@Constraint(validatedBy = CourseSessionExistenceValidator.class)
public @interface CourseSessionExistence {
	String message() default "Unable to identify Course Session";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

class CourseSessionExistenceValidator implements ConstraintValidator<CourseSessionExistence, Integer> {
	
	@Autowired
	CourseSessionImpl courseSessionImpl;
	
	
	@Override
	public boolean isValid(Integer sessionid, ConstraintValidatorContext context) {
		return courseSessionImpl.isSessionExist(sessionid);
	}
	
}
