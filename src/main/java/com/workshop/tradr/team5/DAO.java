package com.workshop.tradr.team5;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mysql.jdbc.Util;


public class DAO {
	
	public int addCustomer (Customer obj) throws ClassNotFoundException  {		
			
			String dbUrl = "jdbc:mysql://localhost:3306/tradr?allowMultiQueries=true&useSSL=false";
	        String dbClass = "com.mysql.jdbc.Driver";
	        String userdb = "root" , passdb = "";
	        
	        int i=0;
	        try {
	            
	            Class.forName(dbClass);
	            Connection con = DriverManager.getConnection(dbUrl, userdb, passdb); 
	            String query = "INSERT into tradr.customer VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	            PreparedStatement pst = con.prepareStatement(query);
	            pst.setInt(1, 0);
	            pst.setString(2, obj.customer_name);
	            pst.setString(3, obj.username);
	            pst.setString(4, obj.password);
	            pst.setString(5, obj.secretQ);
	            pst.setString(6, obj.secretA);
	            pst.setDate(7, java.sql.Date.valueOf(obj.dob));
	            pst.setString(8, obj.gender);
	            pst.setString(9, obj.invest_trader);
	            pst.setInt(10 , Integer.parseInt(obj.household_id));
	            pst.setString(11, "General");
	            
	            i=pst.executeUpdate();
	            con.close();
	        }
	        catch (SQLException e) {
	                        e.printStackTrace();
	        }     
	        
	        return i;
		}
	
	 public ArrayList<CreditDebitDetails> getCreditDebitDetails () throws ClassNotFoundException  {		
			
			String dbUrl = "jdbc:mysql://localhost:3306/tradr?allowMultiQueries=true&useSSL=false";
	        String dbClass = "com.mysql.jdbc.Driver";
	        String userdb = "root" , passdb = "";
	        String query1 = "SELECT CUSTOMER_ID,CUSTOMER_NAME FROM tradr.customer;";
	        ArrayList<CreditDebitDetails> list = new ArrayList<CreditDebitDetails>();
	        
	        try {
	            
	            Class.forName(dbClass);
	            Connection con = DriverManager.getConnection(dbUrl, userdb, passdb); 
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(query1);
	            
	            while (rs.next()) {
	                        int customer_id = rs.getInt("CUSTOMER_ID");  
	                        String customer_name = rs.getString("CUSTOMER_NAME");  
	                        double total_balance = 0.0;
	                        if(customer_id > 0)  
	                        	total_balance = getTotalAmount(customer_id);                      	
	                        
	                        CreditDebitDetails obj = new CreditDebitDetails(customer_id, customer_name,total_balance);
	                    	list.add(obj);
	             }	            
	            con.close();
	        }
	        catch (SQLException e) {
	                        e.printStackTrace();
	        } 
	        
	        return list;
		}
	 
	 public int CreditOrDebitDB(CreditOrDebit obj) throws ClassNotFoundException  {		
			
			String dbUrl = "jdbc:mysql://localhost:3306/tradr?allowMultiQueries=true&useSSL=false";
	        String dbClass = "com.mysql.jdbc.Driver";
	        String userdb = "root" , passdb = "";
	        java.sql.Date Date = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
	        
	        
	        try {
	            
	        	
	        	Class.forName(dbClass);
	            Connection con = DriverManager.getConnection(dbUrl, userdb, passdb); 
	            Statement stmt = con.createStatement();
	            String query = "INSERT into tradr.customer_cash VALUES(?,?,?,?,?)";
	            PreparedStatement pst = con.prepareStatement(query);
	            pst.setInt(1, Integer.parseInt(obj.customer_id));
	            pst.setDate(2, Date);
	            pst.setString(3, obj.option);
	            pst.setString(4, "DEPOSIT");
	            pst.setDouble(5 , Double.parseDouble(obj.debitorcredit));
	            int i=pst.executeUpdate();
	            con.close();
	        
	        }
	        catch (SQLException e) {
	                        e.printStackTrace();
	        } 
	        
	        return 1;
		}  
	 
	 public double getTotalAmount(int customer_id) throws ClassNotFoundException  {
		 
		 String dbUrl = "jdbc:mysql://localhost:3306/tradr?allowMultiQueries=true&useSSL=false";
	     String dbClass = "com.mysql.jdbc.Driver";
	     String userdb = "root" , passdb = "";
	 	 String query2 = "SELECT CREDIT_OR_DEBIT,AMOUNT FROM tradr.customer_cash where CUSTOMER_ID = "+customer_id;
     	 double total_balance= 0.0;  
		
     	 try {
     		
			Class.forName(dbClass);
	        Connection con = DriverManager.getConnection(dbUrl, userdb, passdb);
	        Statement stmt = con.createStatement();
	        ResultSet res2 = stmt.executeQuery(query2);
     		
     		while(res2.next()) {
     				
     				String action = res2.getString("CREDIT_OR_DEBIT");
     				double amount = res2.getDouble("AMOUNT");
     				
     				if(action.equals("CREDIT"))
     					total_balance += amount;
     				else
     					total_balance -= amount;
     		}
     	}
     	catch (SQLException  e) {
             e.printStackTrace();
     	}
		 return total_balance;
	 }
	 
	 public String getSecretQuestion (String obj) throws ClassNotFoundException
		{
			String dbUrl = "jdbc:mysql://localhost:3306/tradr?allowMultiQueries=true&useSSL=false";
	        String dbClass = "com.mysql.jdbc.Driver";
	        String userdb = "root" , passdb = "";
	        String str="";
	        try
	        {
	        	Class.forName(dbClass);
	            Connection con = DriverManager.getConnection(dbUrl, userdb, passdb); 
	            String query="select SECRET_QUESTION from tradr.customer where CUSTOMER_LOGIN_NAME=\""+obj+'\"';
	            PreparedStatement pst = con.prepareStatement(query);
	            Statement st=con.createStatement();
	            
	            //pst.setString(1, obj);
	            
	            //Statement smt=con.createStatement();
	            ResultSet rs = st.executeQuery(query);
	            //System.out.println(rs.getString(1));
				while(rs.next())
					str=rs.getString(1);
					System.out.println(" loggggg" +str);
					con.close();
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }  
			return str;
		}
	 
	 public void changePassword (String secans,String npwd) throws ClassNotFoundException
		{
			String dbUrl = "jdbc:mysql://localhost:3306/tradr?allowMultiQueries=true&useSSL=false";
	        String dbClass = "com.mysql.jdbc.Driver";
	        String userdb = "root" , passdb = "";
	        
	        try
	        {
	        	Class.forName(dbClass);
	            Connection con = DriverManager.getConnection(dbUrl, userdb, passdb); 
	            String query="UPDATE tradr.customer SET CUSTOMER_LOGIN_PASSWORD=\""+npwd+"\" WHERE SECRET_ANSWER=\""+secans+"\"";
	            Statement smt=con.createStatement();
	            smt.executeUpdate(query);
	            con.close();
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	        }
		}

}
