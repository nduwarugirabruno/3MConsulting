package io.consulting.user.controller;

import io.consulting.user.entity.metier.User;
import io.consulting.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {

	final
	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(path = "/new")
	public ResponseEntity<User> create(@RequestBody User user){
		return userService.create(user);
	}

	@PutMapping(path = "/edit/{id}")
	public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id){
		return userService.update(user, id);
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		return userService.delete(id);
	}

	@GetMapping(path = "/read/all")
	public List<User> readAll(){
		return userService.getAll();
	}

	@GetMapping(path = "/read/id/{id}")
	public User readById(@PathVariable Long id){
		return userService.getUById(id);
	}

	@GetMapping("/read/name/{name}")
	public List<User> readByName(@PathVariable String name) {
		return userService.getByName(name);
	}

	@GetMapping("/read/numtel/{number}")
	public List<User> readByNumber(@PathVariable Long number) {
		return userService.getByNumber(number);
	}

	@GetMapping("/read/mail/{mail}")
	public List<User> readByMail(@PathVariable String mail) {
		return userService.getByMail(mail);
	}

}