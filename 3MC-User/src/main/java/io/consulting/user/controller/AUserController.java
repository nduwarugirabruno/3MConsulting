package io.consulting.user.controller;

import io.consulting.user.entity.metier.AUser;
import io.consulting.user.service.AUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/v1/auser")
public class AUserController {

	final
	AUserService auserService;

	@Autowired
	public AUserController(AUserService auserService) {
		this.auserService = auserService;
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		return auserService.delete(id);
	}

	@GetMapping(path = "/read")
	public List<AUser> readAllUser(){
		return auserService.getAll();
	}

	@GetMapping(path = "/read/id/{id}")
	public AUser readUser(@PathVariable Long id){
		return auserService.getUser(id);
	}

	@GetMapping("/read/name/{name}")
	public List<AUser> getUserByNom(@PathVariable String name) {
		return auserService.getByName(name);
	}

	@GetMapping("/read/numtel/{number}")
	public List<AUser> getUserByNumTel(@PathVariable Long number) {
		return auserService.getByNumber(number);
	}

	@GetMapping("/read/mail/{mail}")
	public List<AUser> getUserByMail(@PathVariable String mail) {
		return auserService.getByMail(mail);
	}

}