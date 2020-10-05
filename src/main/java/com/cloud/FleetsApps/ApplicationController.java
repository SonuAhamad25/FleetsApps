package com.cloud.FleetsApps;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController 
{
	@GetMapping("/index")
	public String HomePage()
	{
		return "index";
	}
	
	@GetMapping("/login")
	public String Login()
	{
		return "login";
	}
	
	@GetMapping("/logout")
	public String Logout()
	{
		return "login";
	}
	
	@GetMapping("/register")
	public String Register()
	{
		return "register";
	}


}
