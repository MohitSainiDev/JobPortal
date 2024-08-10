package com.mohit.jobportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mohit.jobportal.entity.Users;
import com.mohit.jobportal.entity.UsersType;
import com.mohit.jobportal.services.UsersService;
import com.mohit.jobportal.services.UsersTypeService;

import jakarta.validation.Valid;

@Controller
public class UsersContoller {

	@Autowired
	private UsersTypeService usersTypeService;
	@Autowired
	private UsersService usersService;

	@GetMapping("/register")
	public String register(Model model) {
		List<UsersType> usersTypes = usersTypeService.getAll();
		model.addAttribute("getAllTypes", usersTypes);
		model.addAttribute("user", new Users());
		return "register";

	}

	@PostMapping("/register/new")
	public String userResgitration(@Valid Users users, Model model) {
		Optional<Users> optionalUsers = usersService.getUserByEmail(users.getEmail());
		if (optionalUsers.isPresent()) {
			model.addAttribute("error", "Email already registered ,try to login or register with other email");
			List<UsersType> usersTypes = usersTypeService.getAll();
			model.addAttribute("getAllTypes", usersTypes);
			model.addAttribute("user", new Users());
			return "register";
		}
		usersService.addNew(users);
		return "dashboard";
	}
}
