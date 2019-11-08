package org.Dao;
import java.util.*;
import org.model.Supplier;

public interface SupplierDao {
	
	public boolean addSupplier(Supplier suppliername);
	public boolean deleteSupplier(Supplier suppliername);
    public boolean updateSupplier(Supplier suppliername);
     Supplier findBySupplierId(int sid);
   List<Supplier> retrieve();
    

}
