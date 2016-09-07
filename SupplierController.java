package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.project.shopping.DAO.SupplierDAO;
import com.project.shopping.Model.Supplier;



@Controller
public class SupplierController {
	@Autowired
	private SupplierDAO supplierDAO;
	
	 @Autowired
	 private Supplier supplier;
	 
	 @RequestMapping(value="/suppliers", method=RequestMethod.GET)
	 public String listsuppliers(Model model)
	 {
		 model.addAttribute("supplier",supplier);
		 model.addAttribute("supplierList",this.supplierDAO.list() );
		 return "supplier";
		 
	 }
	 @RequestMapping(value="/supplier/add", method=RequestMethod.POST)
	 public String addSupplier(@ModelAttribute("supplier")Supplier supplier)
	 {
		 supplierDAO.save(supplier);
		 return "supplier";
	 }
	 
	 
	 @RequestMapping(value="/supplier/update", method=RequestMethod.POST)
	 public String updateSupplier(@ModelAttribute("supplier")Supplier supplier){
		supplierDAO.update(supplier) ;

		 return "supplier";
	 }
	 @RequestMapping("supplier/remove/{id}")
	 public  ModelAndView deleteSupplier(@PathVariable("id") String id)throws Exception{
		
		 supplier=supplierDAO.get(id);
		 ModelAndView mv =new ModelAndView("supplier");
		 if(supplier==null)
		 {
			 mv.addObject("errror message","could not delete the supplier");
		 }
		 else
		 {
			 supplierDAO.delete(supplier);
		 }
		 return mv;
	 }
	 @RequestMapping("supplier/edit/{id}")
		 public ModelAndView editSupplier(@ModelAttribute("supplier")Supplier supplier)
		 {
		 ModelAndView mv=new ModelAndView();
		 if(supplierDAO.get(supplier.getId())!=null)
		 {
			 supplierDAO.update(supplier);
			 mv.addObject("message","successfully updated");
		 }
		 else
		 {
			 mv.addObject("error message","could not update the record");
			 
			 
		 }
		 return mv;
		 		 
	 }

}
