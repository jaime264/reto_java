package com.reto.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.stereotype.Service;

import com.reto.dao.User;

@Service
public class UserServiceImp implements IUserService{

	@Override
	public User restructurar() {
		String urlstr = "https://jsonplaceholder.typicode.com/comments";
		JsonArray results = listarJson(urlstr);
		List<String> data = new ArrayList<String>();
		User user = new User();

		Iterator<?> iterator = results.iterator();
		while (iterator.hasNext()) {
			JsonObject jsonObject = (JsonObject) iterator.next();

			String postId = jsonObject.get("postId").toString();
			String id = jsonObject.get("id").toString();
			String email = jsonObject.get("email").toString().replace('"', ' ').trim();

			String valor = postId + "|" + id + "|" + email;
			data.add(valor);
		}

		user.setData(data);

		return user;
	}

	private JsonArray listarJson(String urlstr) {

		JsonArray results = null;
		try {
			URL url = new URL(urlstr);
			InputStream is = url.openStream();
			JsonReader rdr = Json.createReader(new InputStreamReader(is, "UTF-8"));
			results = rdr.readArray();
			return results;
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}

		return results;
	}

}
