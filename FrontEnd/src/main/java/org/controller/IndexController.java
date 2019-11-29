package org.controller;

import org.Dao.CategoryDao;
import org.Dao.ProductDao;
import org.Dao.UserDao;
import org.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@Autowired
	UserDao UserDaoImp;
	
	@Autowired
	CategoryDao CategoryDaoImp;
	
	@Autowired
	ProductDao ProductDaoImp;
	
	@RequestMapping(value = "/")
	public String index() {
		return "index"; 
		
	}
	
	@RequestMapping(value = "/index",method = {RequestMethod.GET, RequestMethod.POST})
 public String home() {
		return "index";
		
	}	
	@RequestMapping(value = "/gotoRegister", method = RequestMethod.GET)
	public ModelAndView gotoRegister() {
		ModelAndView mv= new ModelAndView();
		mv.addObject("ussr", new User());
		mv.setViewName("register");
		
		return mv;
	}
	
	@RequestMapping(value = "/saveRegister",method = RequestMethod.POST)
	public ModelAndView saveRegister(@ModelAttribute("user")User user, BindingResult result)
	{
	ModelAndView mvc=new ModelAndView();
	if(result.hasErrors()) {
		mvc.setViewName("register");
		
	}else {
		user.setRole("ROLE_USER");
		UserDaoImp.insertUser(user);
		mvc.setViewName("index");
		
}
	return mvc;
	
		
	}	
@RequestMapping(value = "/viewCat")
public ModelAndView viewCategory(@RequestParam("cid")String cid) {
	ModelAndView mn = new ModelAndView();
	mn.addObject("prList", ProductDaoImp.retrieve(cid));
	mn.setViewName("productCustList");
	return mn;
	}
@RequestMapping(value = "/getLogin", method = RequestMethod.GET )
public ModelAndView getLogin() {
	ModelAndView mn = new ModelAndView();
	mn.setViewName("login");
	return mn;
	}
@RequestMapping(value = "/userLogged", method = {RequestMethod.GET,RequestMethod.POST})
public ModelAndView userLogged() {
	ModelAndView mn = new ModelAndView();
	mn.setViewName("redirect:/index");
	return mn;
	}
@RequestMapping(value = "/error", method = {RequestMethod.POST, RequestMethod.GET}) 
public ModelAndView error() {
	ModelAndView mn = new ModelAndView();
	mn.setViewName("error");
	return mn; 
	}
@RequestMapping(value = "/login", method = RequestMethod.GET)
public ModelAndView doLogin() {
	ModelAndView mn= new ModelAndView();
	mn.setViewName("login");
	return mn;
} 
@ModelAttribute
public void loadingCategory(Model model) {
	model.addAttribute("catList", CategoryDaoImp.retrieve());
}
}
