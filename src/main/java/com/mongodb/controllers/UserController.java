package com.mongodb.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.models.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@GetMapping
	public List<User> findAll() {
		User user1 = new User("1", "Lauro Miotto", "lauro@gmail.com");
		User user2 = new User("2", "Carlos", "carlos@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(user1, user2));
		return list;
	}

}
