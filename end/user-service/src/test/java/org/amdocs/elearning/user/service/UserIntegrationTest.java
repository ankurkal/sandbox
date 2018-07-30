package org.amdocs.elearning.user.service;

import java.time.LocalDate;

import org.amdocs.elearning.user.service.user.User;
import org.amdocs.elearning.user.service.user.UserDetails;
import org.amdocs.elearning.user.service.user.UserType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getUserById_Match() throws Exception {
		final ResponseEntity<User> responseEntity = this.restTemplate
				.getForEntity("http://localhost:" + port + "/users/0", User.class);
		Assert.assertEquals(200, responseEntity.getStatusCodeValue());
		Assert.assertNotNull(responseEntity.getBody());
	}

	@Test
	public void getUserById_NoMatch() throws Exception {
		final ResponseEntity<User> responseEntity = this.restTemplate
				.getForEntity("http://localhost:" + port + "/users/abc", User.class);
		Assert.assertEquals(404, responseEntity.getStatusCodeValue());
		Assert.assertNull(responseEntity.getBody());
	}

	@Test
	public void createUser() throws Exception {

		final UserDetails user = new User(null, "firstName", "lastName", "M", UserType.PATRON, LocalDate.now());
		final ResponseEntity<User> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/users", user, User.class);

		Assert.assertEquals(201, responseEntity.getStatusCodeValue());
		Assert.assertNotNull(responseEntity.getBody());
	}
}
