package com.BookHall.Hall.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.BookHall.Hall.models.HallInformation;
import com.BookHall.Hall.models.SingleHallDetails;
import com.BookHall.User.dao.AbstractDao;

@Repository("IHallInformationDao")
public class HallInformationDao extends AbstractDao implements IHallInformationDao{

	public List<HallInformation> GetHallInformation(String locality, Date fromDate, Date todate) {
		return getHallInfo(locality,fromDate,todate);
	}

	public void NewHallAddition(HallInformation hallInfo) {
		persist(hallInfo);
		
	}

	public SingleHallDetails ExploreHallInformation(int hallId) {
		return GetSingleHallInfo(hallId);
	}

}
