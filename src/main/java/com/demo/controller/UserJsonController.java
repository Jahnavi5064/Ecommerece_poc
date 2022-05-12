package com.demo.controller;


import java.util.List;
import java.util.Optional;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.LoginDto;
import com.demo.dto.UpdatePasswordDto;
import com.demo.dto.UpdateUserDetailsDto;
import com.demo.entity.UserEntity;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;
@RestController
@RequestMapping("/ecom")
public class UserJsonController {
	
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserService userServ;

	@PostMapping("/saveUser")
	public JSONObject saveUser(@RequestBody UserEntity user)
	{
	UserEntity save = userRepo.save(user);
	if(save!=null)
	{
	JSONObject response = userServ.userResponse("ok","Registration was succesfull" , "eyJhbGciOiJIUzI1NiIsInR5aB...");
	return response;
	}
	else
	{
	JSONObject response = userServ.userResponse("Not ok","Registration was failed" , "eyJhbGciOiJIUzI1NiIsInR5aC...");
	return response;
	}

	}
	@GetMapping("/getUsers")
	public List<UserEntity> getUsers()
	{
	List<UserEntity> users = userRepo.findAll();
	return users;
	}

	@PostMapping("/verifyLogin")
	public JSONObject verifylogin(@RequestBody LoginDto users)
	{
	String email = users.getEmail();
	String password = users.getPassword();
	UserEntity user = userRepo.findByEmail(email);
	if(user!=null) {
	if(user.getEmail().equals(email)&& user.getPassword().equals(password))
	{
	JSONObject response = userServ.userResponse("ok","Log In was succesfull" , "eyJhbGciOiJIUzI1NiIsInR5cC...");
	return response;
	}

	else
	{
	JSONObject response = userServ.userResponse("Not ok","Please enter valid user name and password" , "eyJhbGciOiJIUzI1NiIsInR5cC1...");
	return response;
	}
	}
	
	else
	{
	JSONObject response = userServ.userResponse("Not ok","User does not exists Please enter valid user name" , "eyJhbGciOiJIUzI1NiIsInR5cC2...");
	return response;
	}
	}
	@DeleteMapping(value="/delete/{id}")
	public JSONObject delateUser(@PathVariable int id)
	{
		Optional<UserEntity> findById = userRepo.findById(id);
		UserEntity user = findById.get();
		if(user!=null)
		{
		userRepo.deleteById(id);
		JSONObject response = userServ.userResponse("ok","User record getting deleted" , "eyJhbGciOiJIUzI1NiIsInR5cC2...");
		return response;
		}
		else
		{
		JSONObject response = userServ.userResponse("Not ok","Unable to delete Please enter valid user Id" , "eyJhbGciOiJIUzI1NiIsInR5cC2...");
		return response;
		}
	}

	@PutMapping(value="updateUserPassword/{id}")
	public void updateUserPassword(@RequestBody UpdatePasswordDto updatePasswordDto ,@PathVariable int id)
	{
		UserEntity users=new UserEntity();
	String newPassword = updatePasswordDto.getNewPassword();
	String confirmNewPassword = updatePasswordDto.getConfirmNewPassword();
	Optional<UserEntity> findById = userRepo.findById(id);
	UserEntity user = findById.get();
	String firstName = user.getFirst_name();
	String lastName = user.getLast_name();
	String email = user.getEmail();
	if(user.getPassword().equals(updatePasswordDto.getOldPassword()))
	{
	if(newPassword.equals(confirmNewPassword))
	{
	users.setId(id);
	users.setFirst_name(firstName);
	users.setLast_name(lastName);
	users.setEmail(email);
	users.setPassword(newPassword);
	UserEntity save = userRepo.save(users);
	if(save!=null)
	{
	JSONObject response = userServ.userResponse("ok","Password getting updated" , "eyJhbGciOiJIUzI1NiIsInR5dC1...");
	return;
	}
}
	else
	{
	JSONObject response = userServ.userResponse("Not ok","Password not getting updated" , "eyJhbGciOiJIUzI1NiIsInR5dC2s...");
	return;
	}

	}
	else
	{
	JSONObject response = userServ.userResponse("Not ok","New password and conformed password both are not match" , "eyJhbGciOiJIUzI1NiIsInR5dC2s...");
	return;
	}
	}
}

	
//	else
//	{
//	JSONObject response = userServ.userResponse("Not ok"," Old password was in correct Please enter valid old password " , "eyJhbGciOiJIUzI1NiIsInR5cC2...");
//	return response;
//	}
//	}

	
	
