package com.reto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reto.controller.UserController;
import com.reto.dao.User;

@SpringBootTest
public class UserControllerTest {

	
	@Test
	void contextListar() {
		
		UserController userController = new UserController();
		
		User result  = userController.listar();
		
		assertNotNull(result);
	}
}
