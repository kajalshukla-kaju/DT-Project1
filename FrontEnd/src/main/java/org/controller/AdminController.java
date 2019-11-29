package org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.Dao.CategoryDao;
import org.Dao.ProductDao;
import org.Dao.SupplierDao;
import org.model.Category;
import org.model.Product;
import org.model.Supplier;
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	SupplierDao SupplierDaoImp;
	
	@Autowired
	CategoryDao CategoryDaoImp;
	@Autowired
	ProductDao ProductDaoImp;
	
	@RequestMapping(value = "/adding", method = {RequestMethod.GET, RequestMethod.POST})
  public String adding()
  {
		return "AdminAdding";
		
  }

	@RequestMapping(value = "/saveSupp", method = RequestMethod.POST)
	@Transactional
	public ModelAndView saveSuppData(@RequestParam("sid") int sid, @RequestParam("suppliername")String suppliername ) {
	ModelAndView mv = new ModelAndView();
	Supplier supplier= new Supplier();
	supplier.setSid(sid);
	supplier.setSuppliername(suppliername);
	SupplierDaoImp.addSupplier(supplier);
	mv.setViewName("status");
	return mv;
		}
	@RequestMapping(value = "/savecat", method = RequestMethod.POST)
	@Transactional
	public ModelAndView saveCatData(@RequestParam("cid")int cid,@RequestParam ("Categoryname") String Categoryname )
	{
	ModelAndView mv = new ModelAndView();
	Category  category = new Category();
	category.setCid(cid);
	category.setCategoryname(Categoryname);
	mv.setViewName("status");
	return mv;
		
	}
	
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	@Transactional
	public ModelAndView savePoductData(HttpServletRequest req,@RequestParam("file")MultipartFile file)
	{
		ModelAndView mv=new ModelAndView();
		Product product = new Product();
		product.setProductname(req.getParameter("productname"));
		product.setPrice(Float.parseFloat(req.getParameter("price")));
		product.setDescription(req.getParameter("description"));
		product.setStock(Integer.parseInt(req.getParameter("stock")));
		product.setCategory(CategoryDaoImp.searchbyid(req.getParameter("")));
		product.setSupplier(SupplierDaoImp.findBySupplierId(req.getParameter("")));
		
		String filepath=req.getSession().getServletContext().getRealPath("/");
		String filename = file.getOriginalFilename();
		product.setImagename(filename);
		ProductDaoImp.addProduct(product);
		System.out.println("File path" + filepath);
		
		try {
			byte imagebyte[]=file.getBytes();
			BufferedOutputStream out= new BufferedOutputStream(new FileOutputStream(filepath+"/webapp/image/"+filename));
			out.write(imagebyte);
			out.close();
			}
		catch (Exception e) {
e.printStackTrace();
		}
	mv.addObject(product);
	mv.setViewName("redirect:/admin/productList?update");
return mv;		
	}

	@ModelAttribute
	public void loadingDataInPage(Model model){
		model.addAttribute("satList", SupplierDaoImp.retrieve());
		model.addAttribute("catList", CategoryDaoImp.retrieve());
		model.addAttribute("prodList", ProductDaoImp.retrieve());
	}
		
	@RequestMapping("/productList")
	public ModelAndView prodlist(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("prodList", ProductDaoImp.retrieve());	
		modelAndView.setViewName("productAdminList");
		return modelAndView;
	}

	@RequestMapping("/supplierList")
	public ModelAndView supplist(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("satList", SupplierDaoImp.retrieve());
		modelAndView.setViewName("suppAdminList");
		return modelAndView;
	}
			
	@RequestMapping("/categoryList")
	public ModelAndView catlist(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("catList", CategoryDaoImp.retrieve());
		modelAndView.setViewName("categoryAdminList");
		return modelAndView;
	}
			
	@RequestMapping("/deleteProd")
	public String deleteProduct(@RequestParam("pid")int pid){
		ProductDaoImp.deleteProduct(pid);
		return "redirect:/admin/productList?del";
	}
	
	@RequestMapping("/updateProd")
	public ModelAndView updateproduct(@RequestParam("pid") int pid){
				
		ModelAndView modelAndView = new ModelAndView();
		Product product = ProductDaoImp.searchbyid(pid);
		modelAndView.addObject("prod", product);
		modelAndView.addObject("cList", CategoryDaoImp.retrieve());
		modelAndView.addObject("sList",SupplierDaoImp.retrieve());
		modelAndView.setViewName("updateProduct");
		return modelAndView;
	}
				
	@RequestMapping(value="/productUpdate", method= RequestMethod.POST)
	public ModelAndView updateProd(HttpServletRequest request, @RequestParam("file")MultipartFile file){
				
		ModelAndView modelAndView = new ModelAndView();
		Product product = new Product();
		product.setProductid(Integer.parseInt(request.getParameter("productId")));

		product.setProductname(request.getParameter("productName"));
		product.setPrice(Float.parseFloat(request.getParameter("price")));
		product.setDescription(request.getParameter("description"));
		product.setStock(Integer.parseInt(request.getParameter("stock")));

		String category = request.getParameter("pCategory");
		String supplier = request.getParameter("pSupplier");

		product.setCategory(CategoryDaoImp.searchbyid(category));
		product.setSupplier(SupplierDaoImp.findBySupplierId(supplier));

		String filepath = request.getSession().getServletContext().getRealPath("/"); 
		String filename = file.getOriginalFilename();
		product.setImagename(filename);
		ProductDaoImp.update(product);

		System.out.println("File path"+ filepath);

		try{
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath+"/assets/images/"+filename));

			fos.write(imagebyte);
			fos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		modelAndView.addObject(product);
		modelAndView.setViewName("redirect:/admin/productList?update");
		return modelAndView;
	}
	




}
