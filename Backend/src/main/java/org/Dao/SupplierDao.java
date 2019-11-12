package org.Dao;
import java.util.*;
import org.model.Supplier;

public interface SupplierDao {
	
	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
    public boolean updateSupplier(Supplier supplier);
     Supplier findBySupplierId(int sid);
   List<Supplier> retrieve();
    

}
