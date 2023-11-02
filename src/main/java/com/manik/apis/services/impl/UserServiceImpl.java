package com.manik.apis.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.manik.apis.config.AppConstants;
import com.manik.apis.entities.Role;
import com.manik.apis.entities.User;
import com.manik.apis.exceptions.ResourceNotFoundException;
import com.manik.apis.payloads.UserDto;
import com.manik.apis.repositories.RoleRepo;
import com.manik.apis.repositories.UserRepo;
import com.manik.apis.services.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modeMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.userDtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		UserDto savedDtoUser = this.userToUserDto(savedUser);

		return savedDtoUser;

	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToUserDto(updatedUser);
		return userDto1;

	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		return this.userToUserDto(user);

	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = this.userRepo.findAll();
		return  users.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());

	}

	@Override
	public void deleteUserById(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);

	}

	public UserDto userToUserDto(User user) {

		UserDto userDto = new UserDto();
		userDto = this.modeMapper.map(user, UserDto.class);
		/*
		 * userDto.setId(user.getId()); userDto.setName(user.getName());
		 * userDto.setEmail(user.getEmail()); userDto.setPassword(user.getPassword());
		 * userDto.setAbout(user.getAbout());
		 */
		return userDto;

	}

	public User userDtoToUser(UserDto userDto) {
		User user = new User();
		user = this.modeMapper.map(userDto, User.class);
		/*
		 * user.setId(userDto.getId()); user.setName(userDto.getName());
		 * user.setEmail(userDto.getEmail()); user.setPassword(userDto.getPassword());
		 * user.setAbout(userDto.getAbout())
		 */;

		return user;

	}

	@Override
	public UserDto registerNewUser(UserDto userDto) {
		User user = this.modeMapper.map(userDto, User.class);
		
		
		// password encoding
		 user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		 
		 // get & set the role
		Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
		
		user.getRoles().add(role);
		
		User newUser = this.userRepo.save(user);
		
		return this.modeMapper.map(newUser, UserDto.class);
 
		 
		 
		 
		 
		
		
		
	}

}
