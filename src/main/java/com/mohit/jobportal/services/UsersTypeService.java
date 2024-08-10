package com.mohit.jobportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.jobportal.entity.UsersType;
import com.mohit.jobportal.repository.UsersTypeRepository;

@Service
public class UsersTypeService {

	@Autowired
	private UsersTypeRepository usersTypeRepository;

	public List<UsersType> getAll() {
		return usersTypeRepository.findAll();
	}
}
