package com.BookHall.Hall.controllers;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
// @RequestMapping("/uploadfile")
public class ImageUploadController {

	@Autowired
	ServletContext context;

	@RequestMapping(value = "/uploadfile", method = RequestMethod.GET)
	public ModelAndView uploadImage() {
		ModelAndView model = new ModelAndView("fileupload");

		return model;
	}

	// @RequestMapping(value="fileupload", method= RequestMethod.POST)
	// public @ResponseBody Map<String, Object>
	// uploadfile(MultipartHttpServletRequest request,HttpServletResponse response)
	// {
	// Map<String, Object> map= new HashMap<String, Object>();
	// List<String> list = new ArrayList<String>();
	//
	// Iterator<String> itr= request.getFileNames();
	// MultipartFile mpf=null;
	//
	// while(itr.hasNext()) {
	// mpf = request.getFile(itr.next());
	// try {
	// FileCopyUtils.copy(mpf.getBytes(), new
	// FileOutputStream(context.getRealPath("/resource")+"/"+mpf.getOriginalFilename().replaceAll("
	// "," ")));
	// list.add(mpf.getOriginalFilename().replaceAll(" "," "));
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// map.put("Status", 200);
	// map.put("successfullupload", list);
	// return map;
	// }

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
	    modelMap.addAttribute("file", file);
	    return "fileUploadView";
	}

}
