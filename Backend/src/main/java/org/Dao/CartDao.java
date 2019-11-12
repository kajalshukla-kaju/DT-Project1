package org.Dao;
import org.model.Cart;
import java.util.*;
public interface CartDao {
	public void  insertCart(Cart cart);
	public List<Cart> findingbycartid(String userid); 
	public void deleteCart (int cartID);
	public void update (Cart car);
	public Cart getCartById(int cartProductId, String usermail);
}
