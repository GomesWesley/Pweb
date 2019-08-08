


package dao;

import entities.Form;
import java.util.Collection;
import java.util.List;

public interface FormDAOIF{
	public void save(Form form) throws Exception;
	public Form findBySender(Form form) throws Exception;
        public List<Form> findAll() throws Exception;
}
