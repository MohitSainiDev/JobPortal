package com.mohit.jobportal.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.jobportal.entity.JobSeekerProfile;
import com.mohit.jobportal.entity.RecruiterProfile;
import com.mohit.jobportal.entity.Users;
import com.mohit.jobportal.repository.JobSeekerProfileRepository;
import com.mohit.jobportal.repository.RecruiterProfileRepository;
import com.mohit.jobportal.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private JobSeekerProfileRepository jobSeekerProfileRepository;
	@Autowired
	private RecruiterProfileRepository recruiterProfileRepository;

	public Users addNew(Users users) {
		users.setActive(true);
		users.setRegistrationDate(new Date(System.currentTimeMillis()));
		Users savedUser = userRepository.save(users);
		int userTypeId = users.getUserTypeId().getUserTypeId();
		if (userTypeId == 1)
			recruiterProfileRepository.save(new RecruiterProfile(users));
		else
			jobSeekerProfileRepository.save(new JobSeekerProfile(users));

		return savedUser;
	}

	public Optional<Users> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
