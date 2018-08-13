package com.BookHall.User.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookHall.User.dao.IUserRegistrationDao;
import com.BookHall.User.models.UserInformation;

@Service("IUserRegistrationService")
@Transactional
public class UserRegistrationService implements IUserRegistrationService{

	@Autowired
	IUserRegistrationDao userDao;

	public List<UserInformation> GetUserInformation() {
		return userDao.GetUserData();
	}

	public UserInformation GetSingleUserInformation(String emailId) {
		return userDao.GetSingleUserInformation(emailId);
	}

	public void NewUserRegistration(UserInformation userInfo) {
		userDao.NewUserRegistration(userInfo);
		
	}

	public void UpdateUserInormation(UserInformation userInfo) {
		// TODO Auto-generated method stub
		
	}

	public UserInformation GetDataByEmailAndPhone(String emailId, String phoneNum) {
		return userDao.GetDataByEmailAndPhone(emailId, phoneNum);
	}
	
}
