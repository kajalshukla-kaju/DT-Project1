package org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.Dao.CategoryDao;
import org.Dao.ProductDao;
import org.Dao.SupplierDao;
import org.model.Category;
import org.model.Product;
import org.model.Supplier;
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
		ProductDao.addProduct(product);
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
		
	}
}
