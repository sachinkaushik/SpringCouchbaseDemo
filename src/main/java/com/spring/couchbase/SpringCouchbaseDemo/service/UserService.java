package com.spring.couchbase.SpringCouchbaseDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.couchbase.SpringCouchbaseDemo.document.User;
import com.spring.couchbase.SpringCouchbaseDemo.dto.UserDto;
import com.spring.couchbase.SpringCouchbaseDemo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public UserDto addUser(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		User nwUsr = userRepository.save(user);
		
		UserDto newUserDto= new UserDto();
		BeanUtils.copyProperties(nwUsr, newUserDto);
		
		return newUserDto;
	}


	public List<UserDto> getAllUser() {
		Iterable<User> users = userRepository.findAll();
		List<UserDto> userDtos = new ArrayList<>();
		for(User u: users){
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(u, userDto);
			userDtos.add(userDto);
		}
		return userDtos;
	}

}
