package io.consulting.user.service;

import io.consulting.user.entity.metier.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
	ResponseEntity<User> create(User user);
	ResponseEntity<User> update(User user, Long id);
	ResponseEntity<String> delete(Long id);
	List<User> getAll();
	User getUById(Long id);
	List<User> getByName(String name);
	List<User> getByNumber(Long number);
	List<User> getByMail(String mail);
	ResponseEntity<User> login(String login, String password);
}

