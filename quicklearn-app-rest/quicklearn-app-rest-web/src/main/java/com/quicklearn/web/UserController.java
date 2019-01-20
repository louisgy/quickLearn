package com.quicklearn.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quicklearn.web.Impl.UserServiceImpl;
import com.quicklearn.web.dto.UserDTO;
import com.quicklearn.web.dto.UserLoginDTO;
import com.quicklearn.web.dto.UserPasswordReset;
import com.quicklearn.web.error.FieldErrorDTO;
import com.quicklearn.web.error.ValidationResultDTO;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("/newUser")
	public ResponseEntity<ValidationResultDTO> createNewUser(
			@Validated(UserDTO.updateUser.class) @RequestBody UserDTO newUserDTO, BindingResult bindingResult) {

		ValidationResultDTO validationResultDto = new ValidationResultDTO();

		if (bindingResult.hasErrors()) {

			if (bindingResult.hasGlobalErrors()) {

				ObjectError globalError = bindingResult.getGlobalError(); // Get the first Global Error, need to manage
																			// potential cases of
																			// more than one global error with using
																			// getGlobalErrors() instead
				validationResultDto.addGlobalError(globalError.getDefaultMessage());
			}

			List<FieldError> fieldErrors = bindingResult.getFieldErrors();

			List<FieldErrorDTO> fieldErrorDTOs = fieldErrors.stream().map(FieldErrorDTO::new)
					.collect(Collectors.toList());

			validationResultDto.setFieldErrors(fieldErrorDTOs);

			return new ResponseEntity<>(validationResultDto, HttpStatus.BAD_REQUEST);

		} else if (userServiceImpl.createUser(newUserDTO) != null) {

			validationResultDto.addGlobalError("Account successfully created");

			return new ResponseEntity<>(validationResultDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationResultDTO(), HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/signIn")
	public ResponseEntity<ValidationResultDTO> signInUser(
			@Validated(UserDTO.updateUser.class) @RequestBody UserLoginDTO userLoginDto, BindingResult bindingResult) {

		ValidationResultDTO validationResultDto = new ValidationResultDTO();

		if (bindingResult.hasErrors()) { // Use optional to re-write this section of code

			if (bindingResult.hasGlobalErrors()) {

				ObjectError globalError = bindingResult.getGlobalError(); // Get the first Global Error, need to manage
																			// potential cases of
																			// more than one global error with using
																			// getGlobalErrors() instead
				validationResultDto.addGlobalError(globalError.getDefaultMessage());
			}

			List<FieldError> fieldErrors = bindingResult.getFieldErrors();

			List<FieldErrorDTO> fieldErrorDTOs = fieldErrors.stream().map(FieldErrorDTO::new)
					.collect(Collectors.toList());

			validationResultDto.setFieldErrors(fieldErrorDTOs);

			return new ResponseEntity<>(validationResultDto, HttpStatus.BAD_REQUEST);

		} else {

			validationResultDto.addGlobalError("User Sign-in successfully");

			return new ResponseEntity<>(validationResultDto, HttpStatus.OK);

		}

	}

	@GetMapping("/resetPassword")
	public ResponseEntity<ValidationResultDTO> resetUserPassword(
			@Validated(UserDTO.updateUser.class) @RequestBody UserPasswordReset userLoginDto,
			BindingResult bindingResult) {

		ValidationResultDTO validationResultDto = new ValidationResultDTO();

		if (bindingResult.hasErrors()) {
			if (bindingResult.hasGlobalErrors()) {

				ObjectError globalError = bindingResult.getGlobalError(); // Get the first Global Error, need to manage
																			// potential cases of
																			// more than one global error with using
																			// getGlobalErrors() instead
				validationResultDto.addGlobalError(globalError.getDefaultMessage());

				List<FieldError> fieldErrors = bindingResult.getFieldErrors();

				List<FieldErrorDTO> fieldErrorDTOs = fieldErrors.stream().map(FieldErrorDTO::new)
						.collect(Collectors.toList());

				validationResultDto.setFieldErrors(fieldErrorDTOs);
			}
			return new ResponseEntity<>(validationResultDto, HttpStatus.BAD_REQUEST);

		} else if (userServiceImpl.resetPassword(userLoginDto.getEmail(), userLoginDto.getPassword()))
			return new ResponseEntity<>(validationResultDto, HttpStatus.OK);
		return new ResponseEntity<>(new ValidationResultDTO(), HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/updateUser")
	public ResponseEntity<ValidationResultDTO> updateUser(@Valid @RequestBody UserDTO newUserDTO,
			BindingResult bindingResult) {

		ValidationResultDTO validationResultDto = new ValidationResultDTO();

		if (bindingResult.hasErrors()) {

			if (bindingResult.hasGlobalErrors()) {

				ObjectError globalError = bindingResult.getGlobalError(); // Get the first Global Error, need to manage
																			// potential cases of
																			// more than one global error with using
																			// getGlobalErrors() instead
				validationResultDto.addGlobalError(globalError.getDefaultMessage());
			}

			List<FieldError> fieldErrors = bindingResult.getFieldErrors();

			List<FieldErrorDTO> fieldErrorDTOs = fieldErrors.stream().map(FieldErrorDTO::new)
					.collect(Collectors.toList());

			validationResultDto.setFieldErrors(fieldErrorDTOs);

			return new ResponseEntity<>(validationResultDto, HttpStatus.BAD_REQUEST);

		} else if (userServiceImpl.createUser(newUserDTO) != null) {

			validationResultDto.addGlobalError("Account successfully updated");

			return new ResponseEntity<>(validationResultDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ValidationResultDTO(), HttpStatus.BAD_REQUEST);
	}

}
