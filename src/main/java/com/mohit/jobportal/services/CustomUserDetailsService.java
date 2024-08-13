package com.mohit.jobportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mohit.jobportal.entity.Users;
import com.mohit.jobportal.repository.UsersRepository;
import com.mohit.jobportalutil.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UsersRepository usersRepository;

	@Autowired
	public CustomUserDetailsService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Could not found user"));
		return new CustomUserDetails(user);
	}
}