package com.manik.apis.services;

import java.util.List;

import com.manik.apis.payloads.UserDto;


public interface UserService {
	
	UserDto registerNewUser(UserDto userDto);
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(	UserDto user, Integer id);
	
    UserDto getUserById(Integer id);
    
    List<UserDto> getAllUsers();
    
    void deleteUserById(Integer id);
	
	
	
	

}
