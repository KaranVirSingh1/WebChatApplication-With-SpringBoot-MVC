/*
 * this page having handler methods for requests  
 * and these methods redirect to user on specific jsp page
 * 
 */

package com.nt.websocket.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.IUserDataService;
import com.nt.websocket.model.UserData;

@Controller
public class HomeController {

	@Autowired
	private IUserDataService service;

	public HomeController() {
		System.out.println("HomeController.HomeController() :: 0 param constructor ");
	}
	
	
	
	@RequestMapping(value="/homePage",method=RequestMethod.GET)// browsers 
	public String homePage() {
		System.out.println("ChatController.process() :: home page -- ");
		return "homePage";
	}

	
	@PostMapping("/show")
	public String login_page_data(Map<String,Object>map,		
			@ModelAttribute("cust") UserData cust) {

		System.out.println("HomeController.login_page_data() ::::::::::::"+cust.getUname()+" "+cust.getUpass());

		//use service class
		try {

			if(cust.getUname().equals("") || cust.getUpass().equals("")) {
				String resultMsg = "Kindly Provide proper Credentials For Login ";
				map.put("resultMsg",resultMsg );

				return "WrongInput";
			}
			else if(cust.getUname().equals("null") || cust.getUpass().equals("null")) {
				String resultMsg = "Kindly Provide proper Credentials For Login ";
				map.put("resultMsg",resultMsg );

				return "WrongInput";
			}
			else {
				String resultMsg = service.register(cust);
				//keep result in model attribute
				map.put("resultMsg", resultMsg);
				map.put("cname", cust.getUname());
				//return lvn
				return "finalPage";

			}
		}
		catch(Exception e) {
			return " finalPage ";
		}
		
	}//method
	
	@GetMapping("/backToHomePage")
	public String wrongInput() {
		
		return "homePage";
	}
	
}//class
