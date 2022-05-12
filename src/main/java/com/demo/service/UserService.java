package com.demo.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.demo.dto.LoginDto;
import com.demo.dto.UpdatePasswordDto;
import com.demo.dto.UpdateUserDetailsDto;
import com.demo.dto.UserDto;
import com.demo.entity.UserEntity;
@Service
public class UserService {

	
	public JSONObject userResponse(String status,String message, String accessToken)
	        {
	 
	 
	        JSONObject obj=new JSONObject();
	        obj.put("status",status);
	        obj.put("message",message);
	        obj.put("accessToken",accessToken);
	        return obj;
	        }
	
	


	public void saveUserEntity(UserEntity user) {
		// TODO Auto-generated method stub
		
	}

	public void getUserSerive() {
		// TODO Auto-generated method stub
		
	}

	public void delateUser(int i) {
		// TODO Auto-generated method stub
		
	}

	public void saveUser(UserDto users) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(UpdateUserDetailsDto updateUserDto, int i) {
		// TODO Auto-generated method stub
		
	}




	public void getUser() {
		// TODO Auto-generated method stub
		
	}




	public void saveUser(UserEntity user) {
		// TODO Auto-generated method stub
		
	}




	public void verifylogin(LoginDto logInDto) {
		// TODO Auto-generated method stub
		
	}




	public void updateUserPassword(UpdatePasswordDto uDto, int i) {
		// TODO Auto-generated method stub
		
	}




	public void getUserById(int i) {
		// TODO Auto-generated method stub
		
	}
	 
	 
	        }


