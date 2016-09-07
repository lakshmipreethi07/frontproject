package com.niit.shoppingcart;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.shopping.Model.Category;
import com.project.shopping.Model.User;


@Controller
public class HomeController{
	@Autowired
	private Category category;
	
	@RequestMapping("/")
	public ModelAndView  onLoad(HttpSession session)
	{
		ModelAndView mv =new ModelAndView("/home");
		session.setAttribute("category", category);
		session.setAttribute("categoryList", CategoryDAO.List());
		System.out.println("size:"+CategoryDAO.List());
		return mv;
	}
	@RequestMapping("/user",method=RequestMethod.Post)
		public ModelAndView user(@ModelAttribute User userDetails){
			ModelAndView mv=new ModelAndView("/home");
			if(UserDAO.get(User.getId()==null)
	}
		}
