package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.dto.LoginDto;
import com.demo.dto.UpdatePasswordDto;
import com.demo.dto.UpdateUserDetailsDto;
import com.demo.dto.UserDto;
import com.demo.entity.UserEntity;
import com.demo.service.UserService;


@SpringBootTest
class EcommercePocApplicationTests {
	@Autowired
	private UserService userService;
//	@Autowired
//	private ProductService productsService;



	@Test
	void saveUser() {
	UserEntity user=new UserEntity();
	user.setId(109);
	user.setFirst_name("Tharak");
	user.setLast_name("manu");
	user.setEmail("tharak77@gmail.com");
	user.setPassword("manu12300");
	userService.saveUser(user);

	}
	@Test
	void saveUserFail() {
	UserEntity user=new UserEntity();
	user.setId(107);
	user.setFirst_name("Tharak");
	user.setLast_name("manu");
	user.setEmail("tharak77@gmail.com");
	user.setPassword("manu12300");
	userService.saveUser(user);

	}
	@Test
	void getUser()
	{
	userService.getUser();
	}
	@Test
	void updateUser()
	{
	UpdateUserDetailsDto updateUserDto=new UpdateUserDetailsDto();
	updateUserDto.setFirstName("Tharak");
	updateUserDto.setLastName("manu");
	updateUserDto.setEmail("tharak77@gmail.com");
	userService.updateUser(updateUserDto, 6);

	}
	@Test
	void updateUserFail()
	{
	UpdateUserDetailsDto updateUserDto=new UpdateUserDetailsDto();
	updateUserDto.setFirstName("Tharak");
	updateUserDto.setLastName("manu");
	updateUserDto.setEmail("tharak77@gmail.com");
	userService.updateUser(updateUserDto, 10);

	}
	@Test	
	void saveUsers() {
	UserDto user=new UserDto();
	user.setId(7);
	user.setFirst_name("purvi");
	user.setLast_name("Likki");
	user.setEmail("pavi12@gmail.com");
	user.setPassword("Pavi12345");
	UserDto users=new UserDto(user.getId(),user.getFirst_name(),user.getLast_name(),user.getEmail(),user.getPassword());
	userService.saveUser(users);

	}
	  @Test
	     void deleteUserFail()
	     {
	     userService.delateUser(9);
	     }
	  @Test
	     void deleteUser()
	     {
	     userService.delateUser(7);
	     }
	  @Test
	     void verifyLogIn()
	     {
	     LoginDto logInDto=new LoginDto();
	     logInDto.setEmail("ravi12@gmail.com");
	     logInDto.setPassword("Ravi12345");
	     userService.verifylogin(logInDto);
	 
	     }
	  @Test
	     void verifyLogInWrongPassword()
	     {
	     LoginDto logInDto=new LoginDto();
	     logInDto.setEmail("ravi12@gmail.com");
	     logInDto.setPassword("Ravi45");
	     userService.verifylogin(logInDto);
	 
	     }
	  @Test
	     void verifyLogInWrongUser()
	     {
	     LoginDto logInDto=new LoginDto();
	     logInDto.setEmail("ravi@gmail.com");
	     logInDto.setPassword("Ravi45");
	     userService.verifylogin(logInDto);
	 
	     }
	  @Test
	     void updatePassword()
	     {
	     UpdatePasswordDto uDto=new UpdatePasswordDto();
	     uDto.setOldPassword("Ravi12345");
	     uDto.setNewPassword("Ravi12");
	     uDto.setConfirmNewPassword("Ravi12");
	     userService.updateUserPassword(uDto, 6);
	     }
	  @Test
	     void updatePasswordWithWrongPassword()
	     {
	     UpdatePasswordDto uDto=new UpdatePasswordDto();
	     uDto.setOldPassword("Ravi12345");
	     uDto.setNewPassword("Ravi12");
	     uDto.setConfirmNewPassword("Ravi12");
	     userService.updateUserPassword(uDto, 6);
	 
	     }
	  @Test
	     void updatePasswordWithsamePassword()
	     {
	     UpdatePasswordDto uDto=new UpdatePasswordDto();
	     uDto.setOldPassword("Ravi12");
	     uDto.setNewPassword("Ravi12");
	     uDto.setConfirmNewPassword("Ravi12");
	     userService.updateUserPassword(uDto, 6);
	 
	     }
	  @Test
	     void getUserById()
	     {
	     userService.getUserById (6);
	     }
	  
	
}