package com.workshop.tradr.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.RequestDispatcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.workshop.tradr.team5.CreditDebitDetails;
import com.workshop.tradr.team5.Customer;
import com.workshop.tradr.team5.DAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController
{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(final Locale locale, final Model model)
	{
		HomeController.logger.info("Logged");
		return "home";
	}
	
	@RequestMapping(value = { "/reg" }, method = RequestMethod.GET)
	public String reg(final Locale locale, final Model model)
	{
		HomeController.logger.info("Logged");
		return "register";
	}
	
	@RequestMapping(value = {"/","/register" }, method = RequestMethod.POST)
	public String register(final Locale locale, final Model model,@RequestParam("name") String n1,
			@RequestParam("lname") String n2,
			@RequestParam("lpassword") String n3,
			@RequestParam("secret_ques") String n4,
			@RequestParam("answer") String n5,
			@RequestParam("dob") String n6,
			@RequestParam("gender") String n7,
			@RequestParam("house_id") String n8,
			@RequestParam("invest_id") String n9
				) throws ClassNotFoundException
	{
		HomeController.logger.info("Logged");
		
		
		Customer obj = new Customer(n1,n2,n3,n4,n5,n6,n7,n8,n9);
		
//		Customer obj = new Customer("Akshay Kumar", "AkshayK", "twinkle", "Profession", "Acting", "1992-04-12" ,"m", "Hotel", "1");
		
		DAO database = new DAO();
		database.addCustomer(obj);
		
		return "login";
	}
	
	@RequestMapping(value = {"/","/creditordebit" }, method = RequestMethod.POST)
	public String  CreditOrDebit(final Locale locale, final Model model, @RequestParam("customer_id") String id,
			@RequestParam("name") String name,
			@RequestParam("amount") String amount,
			@RequestParam("debitorcredit") String debitorcredit,
			@RequestParam("option") String option) throws ClassNotFoundException
	{
		HomeController.logger.info("Logged");
		
		System.out.println("Check999" );
		
		System.out.println("1 : " + id);
		System.out.println("2 : " + name);
		System.out.println("3 : " + amount);
		System.out.println("4 : " + debitorcredit);
		System.out.println("5 : " + option);
		
		com.workshop.tradr.team5.CreditOrDebit obj = new com.workshop.tradr.team5.CreditOrDebit(id , name, amount, debitorcredit, option);
		
		
		
		System.out.println("Check0" );
		
		if(option == "DEBIT" && Double.parseDouble(amount) < Double.parseDouble(debitorcredit))
			return "DebitOrCredit_Team5";
		
		System.out.println("Check1" );
		
		DAO database = new DAO();
		database.CreditOrDebitDB(obj);
		
		System.out.println("Check2" );
			

		return "DebitOrCredit_Team5";
	}
	
	
	@RequestMapping(value = {"/populateDCFields" }, method = RequestMethod.GET)
	public String  populateDCFields(final Locale locale, final Model model) throws ClassNotFoundException
	{
		HomeController.logger.info("Logged");
	
		ArrayList<CreditDebitDetails> list = new ArrayList<CreditDebitDetails>();
		DAO database = new DAO();
		list = database.getCreditDebitDetails();
		String toDisplay ="";
		
		toDisplay+="<form action=\"creditordebit\" method=\"POST\" ";
		
//		toDisplay +="<tr>";
//		toDisplay+="<td>&nbsp;&nbsp;&nbsp;"+"Customer ID"+"</td>";
//		toDisplay+="<td>&nbsp;&nbsp;&nbsp;"+"Name"+"</td>";
//		toDisplay+="<td>&nbsp;&nbsp;&nbsp;"+"Bank Balance"+"</td>";
//		toDisplay+="<td>&nbsp;&nbsp;&nbsp;"+"Operation"+"</td>";
//		toDisplay +="<br><br></tr>";
//		
		
		
		
		for(CreditDebitDetails obj : list)  {
			
			System.out.println(obj.customer_id);
			System.out.println(obj.name);
			System.out.println(obj.amount);	

			toDisplay +="<tr>";
			toDisplay+="<td><input type=\"hidden\" name=\"customer_id\" value="+obj.customer_id+" /> </td>";	
			toDisplay+="<td><input type=\"hidden\" name=\"name\" value="+obj.name+" /> </td>";
			toDisplay+="<td><input type=\"hidden\" name=\"amount\" value="+obj.amount+" /> </td>";
			
			toDisplay+="<td>&nbsp;&nbsp;&nbsp;"+obj.customer_id+"</td>";
			toDisplay+="<td>&nbsp;&nbsp;&nbsp;"+obj.name+"</td>";
			toDisplay+="<td>&nbsp;&nbsp;&nbsp;"+obj.amount+"</td>";
			toDisplay+="<td> &nbsp;&nbsp;&nbsp; <input type=\"text\" name=\"debitorcredit\"/> </td>"
						+"<td>&nbsp;&nbsp;&nbsp; <input type=\"radio\" name=\"option\" value=\"CREDIT\">Credit</td>"
						+"<td> &nbsp;&nbsp;&nbsp; <input type=\"radio\" name=\"option\" value=\"DEBIT\">Debit</td>"
						+"<td> &nbsp;&nbsp;&nbsp; <input type=\"submit\" value=\"Submit\" /></td>";			       
			toDisplay +="<br><br></tr>";
		}
		
		toDisplay +="</form>";
		
		model.addAttribute("customer_amount",toDisplay);
		return "DebitOrCredit_Team5";
		
	}
	
	
	
	/**
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(final Locale locale, final Model model)
	{
		HomeController.logger.info("Logged");

		return "login";
	}
	
	
	@RequestMapping(value = "/forgotpwd", method = RequestMethod.GET)
	public String forgotpwd(final Locale locale, final Model model)
	{
		HomeController.logger.info("Logged Forgot");

		return "forgotpwd";
	}
		
	@RequestMapping(value = "/pwdchg", method = RequestMethod.GET)
	public String resetpwd(final Locale locale, final Model model,@RequestParam("secans") String ans,@RequestParam("npwd") String pwd)throws ClassNotFoundException
	{
		HomeController.logger.info("Logged Change");
		DAO database = new DAO();
		database.changePassword(ans,pwd);
		return "login";
	}

	@RequestMapping(value = "/resetpwd" , method = RequestMethod.GET)
	public String resetpwd(final Locale locale, final Model model,@RequestParam("id") String lname)throws ClassNotFoundException
	{
		HomeController.logger.info("Logged");
		DAO database = new DAO();
		String str=database.getSecretQuestion(lname);
		model.addAttribute("str",str);
		return "resetpwd";
	}
	/**
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/userManage", method = RequestMethod.GET)
	public String userManage(final Locale locale, final Model model)
	{
		HomeController.logger.info("Logged");

		return "about";
	}
}
