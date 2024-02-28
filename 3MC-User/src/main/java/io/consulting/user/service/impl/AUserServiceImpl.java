package io.consulting.user.service.impl;

import io.consulting.user.entity.metier.AUser;
import io.consulting.user.repository.AUserRepository;
import io.consulting.user.service.AUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AUserServiceImpl implements AUserService {

	final
	AUserRepository AUserRepository;

	@Autowired
	public AUserServiceImpl(AUserRepository AUserRepository) {
		this.AUserRepository = AUserRepository;
	}

	@Override
	public List<AUser> getAll() {
		return AUserRepository.findAll();
	}

	@Override
	public ResponseEntity<String> delete(Long id) {
		try {
			AUserRepository.deleteById(id);
			return new ResponseEntity<>("User supprimé", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error Cause: " + e.getCause());
			System.out.println("Error Message: " + e.getMessage());
			return new ResponseEntity<>("An error has occured: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public AUser getUser(Long id) {
		if (AUserRepository.findById(id).isPresent())
			return AUserRepository.findById(id).get();
		else return null;
	}

	@Override
	public List<AUser> getByName(String name) {
		return AUserRepository.findByName(name);
	}

	@Override
	public List<AUser> getByNumber(Long number) {
		return AUserRepository.findByNumber(number);
	}

	@Override
	public List<AUser> getByMail(String mail) {
		return AUserRepository.findByMail(mail);
	}

}
