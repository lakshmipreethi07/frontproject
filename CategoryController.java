package com.niit.shoppingcart;

import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.shopping.DAO.CategoryDAO;
import com.project.shopping.Model.Category;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;
	 @Autowired
	 private Category category;
	 
	 @RequestMapping(value="/categories", method=RequestMethod.GET)
	 public String listCategories(Model model)
	 {
		 model.addAttribute("category",category);
		 model.addAttribute("categoryList",this.categoryDAO.list() );
		 return "category";
		 
	 }
	 @RequestMapping(value="/category/add", method=RequestMethod.POST)
	 public String addCategory(@ModelAttribute("category")Category category)
	 {
		 categoryDAO.save(category);
		 return "category";
	 }
	 
	 
	 @RequestMapping(value="/category/update", method=RequestMethod.POST)
	 public String updateCategory(@ModelAttribute("category")Category category){
		categoryDAO.update(category) ;

		 return "category";
	 }
	 @RequestMapping("category/remove/{id}")
	 public  ModelAndView deleteCategory(@PathVariable("id") String id)throws Exception{
		
		 category=categoryDAO.get(id);
		 ModelAndView mv =new ModelAndView("category");
		 if(category==null)
		 {
			 mv.addObject("errror message","could not delete the category");
		 }
		 else
		 {
			 categoryDAO.delete(category);
		 }
		 return mv;
	 }
	 @RequestMapping("category/edit/{id}")
		 public ModelAndView editCategory(@ModelAttribute("category")Category category)
		 {
		 ModelAndView mv=new ModelAndView();
		 if(categoryDAO.get(category.getId())!=null)
		 {
			 categoryDAO.update(category);
			 mv.addObject("message","successfully updated");
		 }
		 else
		 {
			 mv.addObject("error message","could not update the record");
			 
			 
		 }
		 return mv;
		 		 
	 }

}
