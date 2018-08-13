package com.BookHall.Hall.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BookHall.Hall.models.HallInformation;
import com.BookHall.Hall.models.SingleHallDetails;
import com.BookHall.Hall.services.IHallInformationService;
import com.BookHall.User.models.UserInformation;

@RestController
//@RequestMapping(value = "/hall")
public class HallController {

	@Autowired
	IHallInformationService hallService;

	@RequestMapping(value = {"/hall"},method = RequestMethod.GET)
	public ResponseEntity<List<HallInformation>> GetHallInormation(@RequestParam("locality") String locality,
			@RequestParam("from") String fromdate, @RequestParam("to") String todate) throws ParseException {
		// @RequestParam("locality") String locality,@RequestParam("fromDate") Date
		// fromDate,@RequestParam("toDate") Date toDate
		List<HallInformation> hallList;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date fromDate = dateFormat.parse(fromdate);
			Date toDate = dateFormat.parse(todate);

			hallList = hallService.GetHallInformation(locality, fromDate, toDate);
			return new ResponseEntity<List<HallInformation>>(hallList, HttpStatus.OK);
	}

	@RequestMapping(value = "/hall",method = RequestMethod.POST)
	public String AddHallAddition(@RequestBody HallInformation hallInfo) {
		try {
			hallService.NewHallAddition(hallInfo);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return "hall is already registered";
		}
		return "Hall Added";
	}
	
	@RequestMapping(value = {"/explorehall"},method = RequestMethod.GET)// changing of path because the here here ambiguity will create during mapping
	public SingleHallDetails GetHallInormation(@RequestParam("hallId") int hallId) {
		System.out.println(hallId);
		SingleHallDetails details   =hallService.ExploreHallInformation(hallId);
			return details;
	}
}
