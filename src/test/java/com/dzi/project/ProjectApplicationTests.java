package com.dzi.project;

import com.dzi.project.models.User;
import com.dzi.project.repositories.UserRepository;
import com.dzi.project.services.LogInService;
import com.dzi.project.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectApplicationTests {

	@Mock
	private UserRepository userRepository;
	private ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

	@InjectMocks
	private UserService userService;

	@Test
	void whenLogInWithValidCredentialsThenReturnTrue() {
		// Arrange
		String username = "testUser";
		String password = "testPassword";

		// Act
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		when(userRepository.findByUsername(username)).thenReturn(user);

		LogInService logInService = new LogInService(userRepository);

		// Assert
		assertTrue(logInService.logIn(username, password));
	}

	@Test
	void whenLogInWithNullUserThenReturnFalse() {
		// Arrange
		String username = "testUser";
		String password = "testPassword";

		// Act
		when(userRepository.findByUsername(username)).thenReturn(null);

		LogInService logInService = new LogInService(userRepository);

		// Assert
		assertFalse(logInService.logIn(username, password));
	}

	@Test
	public void testIsUsernameAvailableWhenUsernameIsAvailable() {
		// Arrange
		String username = "newUser";

		// Act
		boolean result = userService.isUsernameAvailable(username);

		// Assert
		assertTrue(result);
	}


	@Test
	public void testCreateUser() {
		// Arrange
		User existingUser = new User("existingUser", "password");
		when(userRepository.saveAndFlush(any())).thenReturn(existingUser);
		userService = new UserService(userRepository);
		// Act
		userService.createUser(existingUser);

		// Assert
		verify(userRepository, times(1)).saveAndFlush(userArgumentCaptor.capture());
		assertEquals(existingUser.getUsername(), userArgumentCaptor.getValue().getUsername());
	}

	@Test
	public void testEditUser() {
		// Arrange
		User existingUser = new User("existingUser", "password");
		when(userRepository.save(any())).thenReturn(existingUser);
		userService = new UserService(userRepository);
		// Act
		userService.editUser(existingUser);

		// Assert
		verify(userRepository, times(1)).save(userArgumentCaptor.capture());
		assertEquals(existingUser.getUsername(), userArgumentCaptor.getValue().getUsername());
	}

}
