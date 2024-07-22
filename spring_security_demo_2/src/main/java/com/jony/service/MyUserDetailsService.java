package com.jony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jony.model.MyUser;
import com.jony.repo.UserRepository;
import com.jony.utillity.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		MyUser user = repo.findByUser(username);
		if (user==null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new MyUserDetails(user);
	}

}
