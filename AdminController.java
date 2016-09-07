package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.shopping.DAO.CategoryDAO;
import com.project.shopping.DAO.ProductDAO;
import com.project.shopping.DAO.SupplierDAO;
import com.project.shopping.Model.Category;
import com.project.shopping.Model.Product;
import com.project.shopping.Model.Supplier;


@Controller
public class AdminController {
@Autowired
private  Product product;


@Autowired
private Supplier supplier;

@Autowired
private Category category;


@Autowired
private CategoryDAO categoryDAO;

@Autowired
private ProductDAO productDAO;

@Autowired
private SupplierDAO supplierDAO;


@RequestMapping("/manageCategories")
public ModelAndView categories(){
	ModelAndView mv= new ModelAndView("/home");
	mv.addObject("category",category);
	mv.addObject("isadminclickedcategories","true");
	mv.addObject("categoryList",categoryDAO.list());
	return mv;
	
	
}
@RequestMapping("/manageProduts")
public ModelAndView products(){
	ModelAndView mv= new ModelAndView("/home");
	mv.addObject("product",product);
	mv.addObject("isadminclickedproducts","true");
	mv.addObject("productList",productDAO.list());
	return mv;
	
	
}
@RequestMapping("/manageSuppliers")
public ModelAndView suppliers(){
	ModelAndView mv= new ModelAndView("/home");
	mv.addObject("supplier",supplier);
	mv.addObject("isadminclickedsuppliers","true");
	mv.addObject("supplierList",supplierDAO.list());
	return mv;
	
	
}





}
