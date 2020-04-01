package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Customer;
import com.pojo.EmployeeDao;
import com.pojo.User;

@Controller
public class ControllerDao {

	private ApplicationContext conn;
	
	@RequestMapping("/register1")
	public String view2(Model m )
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Customer  emp = conn.getBean("info", Customer.class);
		m.addAttribute("bean",emp);
		return "register";
	}

	
	@RequestMapping("/save")
	public String view3(@ModelAttribute("bean") Customer e,Model m )
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		obj.saveData(e);
		m.addAttribute("msg", "record inserted succesfully..");
		return "register";
	}
//display
	
	@RequestMapping("/display")	
	public String view191(Model m )
	{		
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao  obj = conn.getBean("dao", EmployeeDao.class);
		List list  = obj.displayData();
		if(!list.isEmpty())
		{
			m.addAttribute("data",list);
		}
		else {
		m.addAttribute("msg", "no data found..");
		}
		return "display";
	}
	
	//login
	
	@RequestMapping("/login1")
	public String view51(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Customer  obj = conn.getBean("info", Customer.class);
		m.addAttribute("bean",obj);
		return "login";
	}
   
	@RequestMapping("/logindata")
	public String login21(@ModelAttribute("bean") Customer  obj ,HttpServletRequest request,HttpServletResponse response,Model m) {
		
		// =  new Customer();
		obj.setCemail(request.getParameter("cemail"));
		obj.setCpass(request.getParameter("cpass"));
		
		String email = obj.getCemail();
		String pass = obj.getCpass();

		EmployeeDao  obj1 =  new EmployeeDao();
		
		List list = obj1.login(email,pass);
		if((list!=null) && (list.size()>0))
		{
			return "home";
		}
		else{
			m.addAttribute("msg","Please enter correct details");
			
		}
			//return "redirect:index.jsp";	
			return "login";
			
		}
	
}
