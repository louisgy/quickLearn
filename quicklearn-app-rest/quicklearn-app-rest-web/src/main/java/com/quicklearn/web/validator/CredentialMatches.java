package com.quicklearn.web.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.quicklearn.web.ValidatorImpl.CredentialMatchesValidator;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, ANNOTATION_TYPE })
@Constraint(validatedBy = CredentialMatchesValidator.class)
public @interface CredentialMatches {
	String message() default "Password and Email dont match";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
