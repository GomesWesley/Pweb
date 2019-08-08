/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entities.Form;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.list;
import java.util.List;


public class FormSQLDAO implements FormDAOIF {
    private static final String DRIVER_NAME = "org.hsqldb.jdbcDriver";
    private static final String DB_URI = "jdbc:hsqldb:hsql://localhost/";
    private static final String DB_USER = "SA";
    private static final String DB_PWD = "";
    private static final String INSERT = "INSERT INTO form(receiver, telephoneReceiver, emailReceiver, sender, telephoneSender, emailSender, data) VALUES(?,?,?,?,?,?,?)";
    private static final String FIND_ALL = "SELECT receiver, telephoneReceiver, emailReceiver, sender, telephoneSender, emailSender, data FROM form";
    private static final String SEARCH = "SELECT* FROM form WHERE sender = ?";
    
    public FormSQLDAO() throws SQLException, ClassNotFoundException {
        Class.forName(FormSQLDAO.DRIVER_NAME);
    }
			
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(FormSQLDAO.DB_URI,
                FormSQLDAO.DB_USER, FormSQLDAO.DB_PWD);
    }
    
    @Override
    public void save(Form form) throws Exception {
        java.util.Date dateU = form.getDate();
        java.sql.Date dateS = new java.sql.Date(dateU.getTime());
                
        PreparedStatement stmt = this.getConnection().prepareStatement(FormSQLDAO.INSERT);

        stmt.setString(1, form.getReceiver());
        stmt.setString(2, form.getTelephoneReceiver());
        stmt.setString(3, form.getEmailReceiver());
        stmt.setString(4, form.getSender());
        stmt.setString(5, form.getTelephoneSender());
        stmt.setString(6, form.getEmailSender());
        stmt.setDate(7, dateS);
        stmt.execute();
        stmt.close();

    }
    
    @Override
    public List<Form> findAll() throws Exception {
		List<Form> formAll = new ArrayList<Form>();
		PreparedStatement stmt = this.getConnection().prepareStatement(FormSQLDAO.FIND_ALL);
		ResultSet rSet = stmt.executeQuery();
		
		while(rSet.next()) {
                    Form form = new Form();
                    form.setReceiver(rSet.getString("receiver")); 
                    form.setTelephoneReceiver(rSet.getString("telephoneReceiver")); 
                    form.setEmailReceiver(rSet.getString("emailReceiver"));
                    form.setSender(rSet.getString("sender")); 
                    form.setTelephoneSender(rSet.getString("telephoneSender")); 
                    form.setEmailSender(rSet.getString("emailSender")); 
                    form.setDate(rSet.getDate("data"));
                    
                    formAll.add(form);	
                }	
		
		rSet.close();
		stmt.close();
		
		return formAll;
	}
    
    @Override
    public Form findBySender(Form form) throws SQLException{
        PreparedStatement stmt = this.getConnection().prepareStatement(FormSQLDAO.SEARCH);
        ResultSet rSet = stmt.executeQuery();
        
        stmt.setString(4, form.getSender());
        
        while( rSet.next() ) {
           form.setReceiver(rSet.getString("receiver")); 
           form.setTelephoneReceiver(rSet.getString("telephoneReceiver")); 
           form.setEmailReceiver(rSet.getString("emailReceiver"));
           form.setSender(rSet.getString("sender")); 
           form.setTelephoneSender(rSet.getString("telephoneSender")); 
           form.setEmailSender(rSet.getString("emailSender")); 
           form.setDate(rSet.getDate("data"));
        }
            
        return form;
    }
}

