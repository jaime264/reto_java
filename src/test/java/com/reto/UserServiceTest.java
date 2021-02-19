package com.reto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.reto.dao.User;
import com.reto.service.UserServiceImp;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserServiceImp userServiceImp;

	@Test
	public void whenCallMethodReestructurarThenSuccess() {
		User listaRestructurada = userServiceImp.restructurar();
		assertTrue(listaRestructurada.getData().size() > 0);
	}

}
