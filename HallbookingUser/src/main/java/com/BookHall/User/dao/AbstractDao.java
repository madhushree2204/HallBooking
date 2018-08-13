package com.BookHall.User.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.BookHall.Hall.models.HallInformation;
import com.BookHall.Hall.models.Services;
import com.BookHall.Hall.models.SingleHallDetails;
import com.BookHall.User.models.UserInformation;
import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor.GetterSetterReflection;

public abstract class AbstractDao {

	@Autowired
	private SessionFactory sessionFactory;

	UserInformation user;
	List<HallInformation> hallList;
	SingleHallDetails singelHallDetails;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(Object entity) {
		getSession().persist(entity);
	}

	public List<UserInformation> getUserInfo() {
		Query queryList = getSession().createQuery("from UserInformation");
		// Query queryList = getSession().createSQLQuery("CALL
		// updateInformation()").addEntity(UserInformation.class);
		List<UserInformation> user = queryList.list();
		return user;
	}

	public List<HallInformation> getHallInfo(String locality, Date fromDate, Date toDate) {
		// List<HallInformation> queryList = getSession().createQuery("from
		// HallInformation").list();
		System.out.println("getting data " + toDate);
		Query query = getSession().createSQLQuery("CALL getHallInformation(:address_locality, :from_date,:to_date)")
				.addEntity(HallInformation.class).setParameter("address_locality", locality)
				.setParameter("from_date", fromDate).setParameter("to_date", toDate);
		hallList = query.list();
		return hallList;
	}

	public UserInformation getSingleUserInfo(String emailId) {
		// Query query = getSession().createQuery("from " +
		// UserInformation.class.getName() + " where email = :emailId");
		// query.setParameter("emailId", emailId);// named parameter is the one which
		// you are sending data
		Query query = getSession().createSQLQuery("CALL GetSingleUserInformation(:email)")
				.addEntity(UserInformation.class).setParameter("email", emailId);

		user = (UserInformation) query.uniqueResult();
		System.out.println(user.getFirstName());
		return user;
	}

	public UserInformation GetDataByEmailAndPhone(String emailId, String phonenum) {
		Query query = getSession().createSQLQuery("CALL GetInfoByEmailDate(:email,:phonenumber)")
				.addEntity(UserInformation.class).setParameter("email", emailId).setParameter("phonenumber", phonenum);

		UserInformation user = (UserInformation) query.uniqueResult();
		System.out.println(user.getFirstName());
		return user;
	}

	public SingleHallDetails GetSingleHallInfo(int hallNum) {
		SingleHallDetails hallDetail= new SingleHallDetails();
		Query query=getSession().createSQLQuery("CALL ExploreSingleHallDetails(:hallid)")
				.addEntity(HallInformation.class).setParameter("hallid", hallNum);
			HallInformation info= (HallInformation) query.uniqueResult();
			
		Query query1 = getSession().createSQLQuery("call GetHallServiceinfo(:hallid)").addEntity(Services.class)
				.setParameter("hallid", hallNum);
		List<Services> serviceInfo = query1.list();	

		hallDetail.setHallName(info.getHallname());
		hallDetail.setDescription(info.getDescription());
		hallDetail.setLocality(info.getAddress_locality());
		hallDetail.setCity(info.getAddress_city());
		hallDetail.setState(info.getAddress_state());
		hallDetail.setCountry(info.getAddress_country());
		hallDetail.setPincode(info.getAddress_pincode());
		hallDetail.setAdvanceAmout(info.getAdvance_amount());
		hallDetail.setAmount(info.getAmount());
		hallDetail.setHallCapacity(info.getHall_capacity());
		hallDetail.setServices(serviceInfo);
		
		return hallDetail;
	}
}
