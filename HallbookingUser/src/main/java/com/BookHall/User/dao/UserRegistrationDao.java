package com.BookHall.User.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.BookHall.User.models.UserInformation;

@Repository("IUserRegistrationDao")
public class UserRegistrationDao extends AbstractDao implements IUserRegistrationDao{

	public List<UserInformation> GetUserData() {
		return getUserInfo();
	}

	public UserInformation GetSingleUserInformation(String emailId) {
		return getSingleUserInfo(emailId);
	}

	public void NewUserRegistration(UserInformation userInfo) {
		persist(userInfo);
	}

	public UserInformation GetDataByEmailAndPhone(String emailId, String phonenum) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void UpdateUserInormation(UserInformation userInfo) {
		// TODO Auto-generated method stub
		
	}

	

}
