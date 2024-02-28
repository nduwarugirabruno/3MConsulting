package io.consulting.user.service;

import io.consulting.user.entity.metier.FreeLancer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FreeLancerService {
	ResponseEntity<FreeLancer> create(FreeLancer freeLancer);
	ResponseEntity<FreeLancer> update(FreeLancer freeLancer, Long id);
	ResponseEntity<String> delete(Long id);
	List<FreeLancer> getAll();
	FreeLancer getUById(Long id);
	List<FreeLancer> getByName(String name);
	List<FreeLancer> getByNumber(Long number);
	List<FreeLancer> getByMail(String mail);
	ResponseEntity<FreeLancer> login(String login, String password);
}

