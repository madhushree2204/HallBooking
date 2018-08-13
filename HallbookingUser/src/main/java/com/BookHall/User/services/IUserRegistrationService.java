package com.BookHall.User.services;

import java.util.List;

import com.BookHall.User.models.UserInformation;

public interface IUserRegistrationService {

	public List<UserInformation> GetUserInformation();
	public UserInformation  GetSingleUserInformation(String emailI);
	public UserInformation GetDataByEmailAndPhone(String email, String phone);
	
	public void NewUserRegistration(UserInformation userInfo);
	public void UpdateUserInormation(UserInformation userInfo);
}
