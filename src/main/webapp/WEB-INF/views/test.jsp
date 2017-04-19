<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import ="com.workshop.tradr.controller.*" 
    import ="com.workshop.tradr.team5.*"%>
<%
   String customer_name=request.getParameter("name");
   String username=request.getParameter("lname");
   String password=request.getParameter("lpassword");
   String secretQ=request.getParameter("secret_ques");
   String secretA=request.getParameter("answer");
   String dob=request.getParameter("dob");
   String gender=request.getParameter("gender");
   String house_id=request.getParameter("house_id");
   String invest_id=request.getParameter("invest_id");
   
   Customer constumer=new Customer(customer_name,username,password,secretQ,secretA,dob,gender,
		   house_id,invest_id);
   
   DAO database = new DAO();
   database.addCustomer(constumer);
%>   