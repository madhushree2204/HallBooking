package com.BookHall.User.dao;

import java.util.List;

import com.BookHall.User.models.UserInformation;

public interface IUserRegistrationDao {

	public List<UserInformation> GetUserData();
	public UserInformation  GetSingleUserInformation(String emailId);
	public UserInformation GetDataByEmailAndPhone(String email, String phone);
	
	public void NewUserRegistration(UserInformation userInfo);
	public void UpdateUserInormation(UserInformation userInfo);
}
