
package session;

import dao.FormDAOIF;
import dao.FormSQLDAO;
import entities.Form;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "formBean")
@SessionScoped
public class AppFormBean implements Serializable{
    private Form form;
    List<Form> formAll;
    
    
    public AppFormBean() throws SQLException, ClassNotFoundException {
        this.form = new Form();
        this.formAll = new ArrayList<Form>();
    }

    public Form getForm() {
        return form;
    }

    public List<Form> getFormAll() throws Exception {
        return formAll = this.findAll();
    }
    
    public void save() throws SQLException, ClassNotFoundException, Exception {
        new FormSQLDAO().save(this.getForm());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Dados salvos com sucesso"));
    }
    
    public List<Form> findAll() throws Exception{
        formAll = (new FormSQLDAO().findAll());
        
        return formAll;
    }
    public Form findBySender() throws SQLException, ClassNotFoundException, Exception{
        form = (new FormSQLDAO().findBySender(this.form));
        
        return form;
    }
}
