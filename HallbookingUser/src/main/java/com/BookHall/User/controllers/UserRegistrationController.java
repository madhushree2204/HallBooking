package com.BookHall.User.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookHall.User.models.UserInformation;
import com.BookHall.User.services.IUserRegistrationService;

@RestController
@RequestMapping(value = "/user")
public class UserRegistrationController {
	@Autowired
	IUserRegistrationService userService;

	UserInformation user;
	
	// for single user data or fot login
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<UserInformation> GetUserData(@RequestParam("emailId") String emailId) { // @RequestParam("emailId")																						// String emailId
		
		System.out.println("getting data " + emailId);
		user = userService.GetSingleUserInformation(emailId);
		if (user == null) {
			return new ResponseEntity<UserInformation>(HttpStatus.NO_CONTENT);// You many decide to return
																				// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<UserInformation>(user, HttpStatus.OK);
	}

	// posting new user
	@RequestMapping(method = RequestMethod.POST)
	public String PostUserData(@RequestBody UserInformation userInfo) {
		System.out.println("username is " + userInfo.getFirstName());
		try {
			user = userService.GetDataByEmailAndPhone(userInfo.getEmail(),userInfo.getPhoneNumber());
			if(user ==null)
			{
				userService.NewUserRegistration(userInfo);
				return "DATA SAVED";
			}
		}
		catch(Exception exception) {
			//send specifically for email and phone number-- future changes need
			return "either email or phone number is already registered";
		}
		return "Data Saved";
	}
	
	
	//put -- update user profile
	@RequestMapping(method= RequestMethod.PUT)
	public String UpdateUserInformation( @RequestBody UserInformation userInfo) {
		System.out.println("updating user information " +userInfo.getFirstName());
		if(userInfo.getEmail()!= "") {
			
		}
		return "Updating data";
	}
}
