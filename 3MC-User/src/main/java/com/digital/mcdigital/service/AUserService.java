package com.digital.mcdigital.service;

import com.digital.mcdigital.entity.metier.AUser;

import java.util.List;

public interface AUserService {
	List<AUser> getAll();
	AUser getUser(Long id);
	String delete(Long id);
	List<AUser> getByName(String name);
	List<AUser> getByNumber(Long number);
	List<AUser> getByMail(String mail);
}

