package io.consulting.user.service;

import io.consulting.user.entity.metier.AUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AUserService {
	List<AUser> getAll();
	AUser getUser(Long id);
	ResponseEntity<String> delete(Long id);
	List<AUser> getByName(String name);
	List<AUser> getByNumber(Long number);
	List<AUser> getByMail(String mail);
}

