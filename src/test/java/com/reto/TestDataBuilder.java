package com.reto;

import java.util.Collections;

import com.reto.dao.User;

public class TestDataBuilder {

	public static User buildResponse() {
		User user = new User();
		user.setData(Collections.emptyList());
		return user;
	}

}
