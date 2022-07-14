package com.greatlearning.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.studentmanagement.entity.User;
import com.greatlearning.studentmanagement.repository.UserRepository;
import com.greatlearning.studentmanagement.security.MyUserDetails;

public class UserDetailServiceImpl implements UserDetailsService  {
	
	@Autowired
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	

	public UserDetailServiceImpl(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userRepository.getUserByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Not able to find the User");
		}
		System.out.println(user.getUsername()+" --------------"+user.getPassword());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return new MyUserDetails(user);
	}
	
	

}
