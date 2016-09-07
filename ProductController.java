package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.shopping.DAO.ProductDAO;
import com.project.shopping.Model.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;

	
	@Autowired
	 private Product product;
	 
	 @RequestMapping(value="/products", method=RequestMethod.GET)
	 public String listProducts(Model model)
	 {
		 model.addAttribute("product",product);
		 model.addAttribute("productList",this.productDAO.list() );
		 return "product";
		 
	 }
	 @RequestMapping(value="/product/add", method=RequestMethod.POST)
	 public String addProduct(@ModelAttribute("product")Product product)
	 {
		 productDAO.save(product);
		 return "product";
	 }
	 
	 
	 @RequestMapping(value="/product/update", method=RequestMethod.POST)
	 public String updateProduct(@ModelAttribute("product")Product product){
		productDAO.update(product) ;

		 return "product";
	 }
	 @RequestMapping("product/remove/{id}")
	 public  ModelAndView deleteProduct(@PathVariable("id") String id)throws Exception{
		
		 product=productDAO.get(id);
		 ModelAndView mv =new ModelAndView("product");
		 if(product==null)
		 {
			 mv.addObject("errror message","could not delete the product");
		 }
		 else
		 {
			 productDAO.delete(product);
		 }
		 return mv;
	 }
	 @RequestMapping("product/edit/{id}")
		 public ModelAndView editProduct(@ModelAttribute("product")Product product)
		 {
		 ModelAndView mv=new ModelAndView();
		 if(productDAO.get(product.getId())!=null)
		 {
			 productDAO.update(product);
			 mv.addObject("message","successfully updated");
		 }
		 else
		 {
			 mv.addObject("error message","could not update the record");
			 
			 
		 }
		 return mv;
		 		 
	 }


}
