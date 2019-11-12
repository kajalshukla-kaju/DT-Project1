package org.Dao;
import org.model.Category;
import java.util.List;
public interface CategoryDao {
	public void addCategory(Category category);
	public Category searchbyid (Category cid);
	List<Category> retrieve();

}
