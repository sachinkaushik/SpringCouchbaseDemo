package com.spring.couchbase.SpringCouchbaseDemo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.couchbase.SpringCouchbaseDemo.dto.UserDto;
import com.spring.couchbase.SpringCouchbaseDemo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
		ResponseEntity<?> responseEntity = null;
		UserDto newUserDto = userService.addUser(userDto);
		if (Objects.nonNull(newUserDto))
			responseEntity = new ResponseEntity<>(newUserDto, HttpStatus.OK);
		else
			responseEntity = new ResponseEntity<>("User not created", HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllUser() {
		ResponseEntity<?> responseEntity = null;
		List<UserDto> users = userService.getAllUser();
		if (Objects.nonNull(users))
			responseEntity = new ResponseEntity<>(users, HttpStatus.OK);
		else
			responseEntity = new ResponseEntity<>("User not created", HttpStatus.BAD_REQUEST);
		return responseEntity;
	}
}
