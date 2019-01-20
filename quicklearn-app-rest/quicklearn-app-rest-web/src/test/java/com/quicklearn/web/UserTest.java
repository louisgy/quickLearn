package com.quicklearn.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.quicklearn.domain.User;
import com.quicklearn.web.dto.UserDTO;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class UserTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	// Incorrect email format. Expected incorrect Email format input
	@Test
	void User_Email_Incorrect () throws JSONException {
		UserDTO user = new UserDTO("IncorrectEmailgmail.com","P4aRs#s2rt","P4aRs#s2rt","Peti","lastPety","admin");
		HttpEntity<UserDTO> entity = new HttpEntity<>(user,headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/newUser"),
				HttpMethod.POST, entity, String.class);
		JSONAssert.assertEquals("{fieldErrors:[{\"fieldName\":\"email\",\"message\":\"must be a well-formed email address\"}],globalErrors:[]}", response.getBody(), JSONCompareMode.LENIENT); // GOOD
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}
	
	// All input expected to be wrongly formatted.but password should match
	@Test
	void User_All_input_wrongly_formatted() throws JSONException {
		UserDTO user = new UserDTO("allwrongmail.com","P4aRs#","P4aRs#","P","t","an");
		HttpEntity<UserDTO> entity = new HttpEntity<>(user,headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/newUser"),
				HttpMethod.POST, entity, String.class);
		JSONAssert.assertEquals("{\"fieldErrors\":[{\"fieldName\":\"firstName\",\"message\":\"size must be between 2 and 32\"},{\"fieldName\":\"password\",\"message\":\"Password must be at least 8 characters in length.\"},{\"fieldName\":\"lastName\",\"message\":\"size must be between 2 and 32\"},{\"fieldName\":\"email\",\"message\":\"must be a well-formed email address\"}],\"globalErrors\":[]}", response.getBody(), false); // GOOD
	}
	
	// The password and matching password does not match. Expected error message :Passwords don't match
	@Test
	void User_Password_No_Match () throws JSONException {
		UserDTO user = new UserDTO("petiw@gmail.com","P4aRs#s2rgt","P4aRs#s2rt","Peti","lastPety","admin");
		HttpEntity<UserDTO> entity = new HttpEntity<>(user,headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/newUser"),
				HttpMethod.POST, entity, String.class);
		JSONAssert.assertEquals("{globalErrors:[{\"message\":\"Passwords don't match\"}]}", response.getBody(), JSONCompareMode.LENIENT); // GOOD
	}
	
	// Email already exist in the database. 
		@Test
		void Email_Exist_Already() throws JSONException {
			UserDTO user = new UserDTO("junior@gmail.com","P4aRs#s2rt","P4aRs#s2rt","Peti","lastPety","admin");
			HttpEntity<UserDTO> entity = new HttpEntity<>(user,headers);

			ResponseEntity<String> response = restTemplate.exchange(
					createURLWithPort("/newUser"),
					HttpMethod.POST, entity, String.class);
			String expected = "{fieldErrors:[{\"fieldName\":\"email\",\"message\":\"Email Already exist\"}],globalErrors:[]}";
			JSONAssert.assertEquals(expected, response.getBody(), false);
			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

		}

	// Correct parameters. User creation account expected to be successful
	@Test
	void Create_User_Correctly() throws JSONException {
		UserDTO user = new UserDTO("petifyw@gmail.com","P4aRs#s2rt","P4aRs#s2rt","Peti","lastPety","admin");
		HttpEntity<UserDTO> entity = new HttpEntity<>(user,headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/newUser"),
				HttpMethod.POST, entity, String.class);
		String expected = "{fieldErrors:[],globalErrors: [{\"message\":\"Account successfully created\"}]}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

	}
	
	// Correct parameters. User account updated
		@Test
		void Create_User_Updated_Correctly() throws JSONException {
			UserDTO user = new UserDTO("junior@gmail.com","P4aRs#s2rt","P4aRs#s2rt","Updated","withoutValidated","admin");
			HttpEntity<UserDTO> entity = new HttpEntity<>(user,headers);

			ResponseEntity<String> response = restTemplate.exchange(
					createURLWithPort("/updateUser"),
					HttpMethod.POST, entity, String.class);
			String expected = "{fieldErrors:[],globalErrors: [{\"message\":\"Account successfully updated\"}]}";
			JSONAssert.assertEquals(expected, response.getBody(), false);
			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		}
	

	@Test
	public void test () {
		UserDTO user = new UserDTO("peti2@gmail.com","P4aRs#s2rt","P4aRs#s2rt","Peti","lastPety","admin");
		// ResponseEntity <User> responseEntity = this.testRestTemplate.getForEntity("/newUser", User.class);
		ResponseEntity <String> responseEntity = this.testRestTemplate.postForEntity("/newUser", user, null, headers);
		// User user = responseEntity.getBody();
		 assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	private String createURLWithPort(final String uri) {
		return "http://localhost:" + port + uri;
	}

}
