package com.niit.shoppingcart;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.shopping.DAO.UserDAO;
import com.project.shopping.Model.User;

@Controller
public class UserController {
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	
	
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value="id") String id, @RequestParam(value="password") 
	String password,HttpSession session)
	{
		ModelAndView mv =new ModelAndView("home");
		boolean.isValidUser=userDAO.isValidUser(userID,password);
		if(isValidUser==true)
		{
			user=userDAO.get(userid);

			session.setAttribute("loggedInUser",user.getFirstname());
			session.setAttribute("loggedInUser",user.getId());
			session.setAttribute("user",user);
			if(user.getRole()==1)
			{
				mv.addObject("isAdmin",true);
			}
			else
			{
				mv.addObject("isAdmin",false);

			}
		}

}
