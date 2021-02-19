package com.reto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.reto.controller.UserController;
import com.reto.dao.User;
import com.reto.service.IUserService;
import com.reto.service.UserServiceImp;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	private MockMvc mvc;

	@InjectMocks
	private UserController userController;

	@Mock
	private IUserService userService;

	@BeforeEach
	public void setup() {
		mvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void canRestructureRequest() throws Exception {
		Mockito.when(userService.restructurar()).thenReturn(TestDataBuilder.buildResponse());

		MockHttpServletResponse response = mvc.perform(get("/user")).andReturn().getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}
	
	@Test
	public void whenCallMethodListarThenSuccess() {
		Mockito.when(userService.restructurar()).thenReturn(TestDataBuilder.buildResponse());
		
		ResponseEntity<User> response = userController.listar();
		assertThat(response.getStatusCode().equals(HttpStatus.OK));
		assertThat(response.getBody().getData().size() == 0);
	}

}
