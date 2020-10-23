package com.cassandrademo;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void saveUser() {
		List<User> users = new ArrayList<>();
		users.add(new User(64371, "Javan", "Bangalore", 50));
		users.add(new User(35231, "Ram", "Pune", 20));
		users.add(new User(86914, "Jayaa", "Mumbai", 30));
		users.add(new User(98541, "Lokesh", "Odisha", 25));
		repository.saveAll(users);
	}

	@GetMapping("/getAllUsers")
	public List<User> getUsers() {
		return repository.findAll();
	}

	@GetMapping("/getUserFilterByAge/{age}")
	public List<User> getUserFilterByAge(@PathVariable int age) {
		return repository.findByAgeGreaterThan(age);
	}
}