package com.quicklearn.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.quicklearn.web.dto.CourseDTO;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void Create_Course_Correctly() throws JSONException {
		CourseDTO courseDto = new CourseDTO("Java","Database","OCA Oracle Certification","Java cert","1Z0-808");
		HttpEntity<CourseDTO> entity = new HttpEntity<>(courseDto,headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/newCourse"),
				HttpMethod.POST, entity, String.class);
		JSONAssert.assertEquals("{globalErrors:[{\"message\":\"Account successfully created\"}]}", response.getBody(), JSONCompareMode.LENIENT); // GOOD
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	
	}
	
	private String createURLWithPort(final String uri) {
		return "http://localhost:" + port + uri;
	}
	
}
