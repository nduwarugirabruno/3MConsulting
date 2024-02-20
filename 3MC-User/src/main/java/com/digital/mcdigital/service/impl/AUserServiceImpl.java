package com.digital.mcdigital.service.impl;

import com.digital.mcdigital.entity.metier.AUser;
import com.digital.mcdigital.repository.AUserRepository;
import com.digital.mcdigital.service.AUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
	public String delete(Long id) {
		AUserRepository.deleteById(id);
		return "l'user a été supprimé";
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
