package com.BookHall.Hall.services;

import java.util.Date;
import java.util.List;

import com.BookHall.Hall.models.HallInformation;
import com.BookHall.Hall.models.SingleHallDetails;

public interface IHallInformationService {

	public List<HallInformation> GetHallInformation(String locality, Date fromDate, Date todate);
	public void NewHallAddition(HallInformation hallInfo);
	
	public SingleHallDetails ExploreHallInformation(int hallId);
}
