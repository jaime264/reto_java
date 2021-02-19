package com.reto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.dao.User;
import com.reto.service.IUserService;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	IUserService userService;

	@GetMapping
	public User listar() {

		return userService.restructurar();

	}
}
