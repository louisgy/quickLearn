package com.quicklearn.web.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.quicklearn.web.service.DateOrderingInterface;
import com.quicklearn.web.service.PasswordMatchInterface;



@Documented
@Retention(RUNTIME)
@Target({ TYPE, ANNOTATION_TYPE })
@Constraint(validatedBy = DateOrderingValidator.class)
public  @interface DateOrdering {
	String message() default "start date can not be later than end date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

class DateOrderingValidator implements ConstraintValidator<DateOrdering, DateOrderingInterface>{



	@Override
	public boolean isValid(DateOrderingInterface obj, ConstraintValidatorContext context) {
		DateOrderingInterface dateEntity = (DateOrderingInterface)obj;
		if(dateEntity.getDateStart().compareTo(dateEntity.getDateEnd()) < 0 )
			return true;
		else
		return false;
	}
	
}
