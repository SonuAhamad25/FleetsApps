package com.cloud.FleetsApps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.cloud.FleetsApps.models.User;

import com.cloud.FleetsApps.services.UserService;
@Controller
public class UserController {
@Autowired
private UserService userService;

@PostMapping(value="users/addNew")	
public RedirectView addNew(User user, RedirectAttributes redir)
{
	userService.save(user);
	
	RedirectView redirectView=new RedirectView("/login",true);
	redir.addFlashAttribute("message","Your Successfuly Registered! You Can now login");
	
	return redirectView;
	
}
}
