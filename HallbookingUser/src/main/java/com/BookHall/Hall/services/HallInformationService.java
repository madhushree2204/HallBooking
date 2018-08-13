package com.BookHall.Hall.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookHall.Hall.dao.IHallInformationDao;
import com.BookHall.Hall.models.HallInformation;
import com.BookHall.Hall.models.SingleHallDetails;

@Service("IHallInformationService")
@Transactional
public class HallInformationService implements IHallInformationService{

	@Autowired
	IHallInformationDao hallDao;
	
	public List<HallInformation> GetHallInformation(String loality, Date fromDate, Date todate) {
		return hallDao.GetHallInformation(loality, fromDate,todate);
	}

	public void NewHallAddition(HallInformation hallInfo) {
		hallDao.NewHallAddition(hallInfo);
		
	}

	public SingleHallDetails ExploreHallInformation(int hallId) {
		return hallDao.ExploreHallInformation(hallId);
	}

}
