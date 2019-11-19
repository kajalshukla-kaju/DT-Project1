package org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.Dao.SupplierDao;
@Controller
@RequestMapping
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
	public ModelandView saveSuppData(@RequestParam("sid") String sid, @RequestParam("suppliername")String suppliername ) {
	ModelAndView mv = new ModelandView();
	Supplier supplier= new Supplier();
	supplier.setsid(sid);
	supplier.setSuppliername(suppliername);
	SupplierDaoImp.insertSupplier(supplier);
	mv.setViewName("status");
	return mv;
		}
	@RequestMapping(value = "/savecat", method = RequestMethod.POST)
	@Transactional
	public Modelandview saveCatData(@RequestParam("cid")String cid,@RequestParam ("Categoryname") String Categoryname )
	{
	ModelAndView mv = new ModelandView();
	Category  category = new Category();
	category.setcid(cid);
	category.setCategoryname(Categoryname);
	mv.setViewName("status");
	return mv;
		
	}
	
	@RequestMapping(value = "/saveProduct", method = ReqquestMethod.POST)
	@Transactional
	public ModelandView savePoductData(HttpServletRequest req,@RequestParam("file")MultipartFile file)
	{
		ModelandView mv=new ModelandView();
		Product product = new Product();
		product.setProductName(req.getParameter("productname"));
		product.setPrice(Float.parseFloat(req.getParameter("price")));
		product.setDescription(req.getParameter("description"));
		product.setStock(Integer.parseInt(req.getParameter("stock")));
		product.setCategory(CategoryDaoImp.searchbyid(req.getParameter("")));
		product.setSupplier(SupplierDaoImp.findBySupplierId(req.getParameter("")));
		
		String filepath=req.getSession().getServletContext().getRealPath("/");
		String filename = file.getOriginalFilename();
		product.setImage(filename);
		ProductDao.addProduct(product);
		System.out.println("File path" + filepath);
		
		
		
		
	}
}
