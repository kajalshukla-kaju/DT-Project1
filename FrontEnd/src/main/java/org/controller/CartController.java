package org.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.Dao.CartDao;
import org.Dao.CategoryDao;
import org.Dao.OrderDao;
import org.Dao.ProductDao;
import org.Dao.SupplierDao;
import org.Dao.UserDao;
import org.model.Cart;
import org.model.Order;
import org.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class CartController {
@Autowired
CartDao CartDaoImp;

@Autowired
CategoryDao CategoryDaoImp;
@Autowired
OrderDao OrderDaoImp;
@Autowired
ProductDao ProductDaoImp;
@Autowired
SupplierDao SupplierDaoImp;
@Autowired
UserDao UserDaoImp;

@RequestMapping
public ModelAndView addtocart (HttpServletRequest req)
{
ModelAndView mav=new ModelAndView();
Principal prin = req.getUserPrincipal();
String userEmail = prin.getName();
try {
	int cartProductId = Integer.parseInt(req.getParameter("CartProductId"));
	Double price = Double.parseDouble(req.getParameter("price"));
	int qty= Integer.parseInt(req.getParameter("qty"));
	String pname = req.getParameter("pname");
	String imgName = req.getParameter("imgName");
	Cart cartexist = CartDaoImp.getCartById(cartProductId,userEmail);
	if(cartexist == null)
	{
		Cart cr = new Cart();
		cr.setCartprice(price);
		cr.setCartProductId(cartProductId);
		cr.setCartstock(qty);
		cr.setCartimage(imgName);
		cr.setCartproductname(pname);
		
	
	
	User u = UserDaoImp.findingbyemail(userEmail);
	cr.setCartuserDetail(u);
	CartDaoImp.insertCart(cr);
	}
	else if(cartexist != null)
	{
		Cart cr = new Cart();
		cr.setCartid(cartexist.getCartid());
		cr.setCartProductId(cartProductId);
		cr.setCartstock(cartexist.getCartstock()+qty);
		cr.setCartimage(imgName);
		cr.setCartproductname(pname);
		
		User u = UserDaoImp.findingbyemail(userEmail);
		cr.setCartuserDetail(u);
		CartDaoImp.update(cr);
			}
	mav.addObject("CartINFO", CartDaoImp.findingbycartid(userEmail));
	mav.setViewName("cart");
	return mav;
}catch (Exception e) {
	e.printStackTrace();
	mav.addObject("cartINFO", CartDaoImp.findingbycartid(userEmail));
    mav.setViewName("cart");
    return mav;
}
}
@RequestMapping
public ModelAndView checkoutProcess(HttpServletRequest req) 
{
ModelAndView mav = new ModelAndView();
Principal principal = req.getUserPrincipal();
String Useremailid = principal.getName();
User user = UserDaoImp.findingbyemail(Useremailid);
List<Cart> cart = CartDaoImp.findingbycartid(Useremailid);
mav.addObject("user", user);
mav.addObject("cart", cart);
return mav;
}

@RequestMapping
public ModelAndView invoiceprocess(HttpServletRequest req)
{
ModelAndView mav = new ModelAndView("invoice");
Order order = new Order();
Principal principal=req.getUserPrincipal();
String useremailid = principal.getName();
Double total= Double.parseDouble(req.getParameter("total"));
String payment = req.getParameter("payment");
User user= UserDaoImp.findingbyemail(useremailid);
order.setUser(user);
order.setTotal(total);
order.setPayment(payment);
OrderDaoImp.addorder(order);
mav.addObject("User", user);
mav.addObject(order);
return mav;
}

@RequestMapping
public ModelAndView orderprocess(HttpServletRequest req) {

	ModelAndView mav = new ModelAndView("ack");
	return mav;
	}
	@RequestMapping
	public String ack()
	{
		return "ack";
	}
	
@RequestMapping
public ModelAndView  deleteCart(@PathVariable("cartId")int cartId, HttpServletRequest req)
{
ModelAndView mav = new ModelAndView();
Principal principal = req.getUserPrincipal();
String useremailid = principal.getName();
CartDaoImp.deleteCart(cartId);
mav.addObject("CartInfo", CartDaoImp.findingbycartid(useremailid));
mav.setViewName("cart");
return mav;
}
@RequestMapping
public ModelAndView gotocart(HttpServletRequest req)
{
ModelAndView mav= new ModelAndView();
Principal principal = req.getUserPrincipal();
String useremailid = principal.getName();
mav.addObject("cart Info", CartDaoImp.findingbycartid(useremailid));
mav.setViewName("cart");
return mav;
}
}


