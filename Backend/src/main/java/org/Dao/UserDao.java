package org.Dao;
import org.model.User;
public interface UserDao {
	public void  insertUser(User user);
	public User findingbyemail(String emailid); 

}
