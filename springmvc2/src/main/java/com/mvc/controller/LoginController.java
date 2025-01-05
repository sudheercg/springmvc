package com.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.model.User;

@Controller
public class LoginController {

    @RequestMapping("/checklogin")
    public String checkLogin(HttpServletRequest request) {

    	String username= request.getParameter("username");
    	String password= request.getParameter("password");

        // Validate credentials
        if ("admin@gmail.com".equals(username) && "admin@123".equals(password)) {
            return "success"; // Forward to success.jsp
        }

        // Add error message and return to login.jsp
      
        return "error";
    }
    
    
    @RequestMapping("/checklogin2")
    public String checkLogin2(HttpServletRequest request,Model model) {

    	String username= request.getParameter("username");
    	String password= request.getParameter("password");

        // Validate credentials
        if ("admin@gmail.com".equals(username) && "admin@123".equals(password)) {
            String data="Hello and Welcome "+username;
        	model.addAttribute("data",data);
        	return "welcome"; // Forward to success.jsp
        }else {

        // Add error message and return to login.jsp
        	 String data="Invalid Credentials!! ";
         	model.addAttribute("data",data);
        return "error2";
        }
    }
    
    
    

    @RequestMapping("/checklogin3")
    public String checkLogin3(@RequestParam String username, @RequestParam String password,Model model) {

    
        // Validate credentials
        if ("admin@gmail.com".equals(username) && "admin@123".equals(password)) {
            String data="Hello and Welcome "+username;
        	model.addAttribute("data",data);
        	return "welcome"; // Forward to success.jsp
        }else {

        // Add error message and return to login.jsp
        	 String data="Invalid Credentials!! ";
         	model.addAttribute("data",data);
        return "error2";
        }
    }
    
    
    @RequestMapping("/checklogin4")
    public String checkLogin3(@ModelAttribute User user,Model model) {
        // Validate credentials
        if ("admin@gmail.com".equals(user.getUsername()) && "admin@123".equals(user.getPassword())) {
            String data="Hello and Welcome "+user.getUsername();
        	model.addAttribute("data",data);
        	return "welcome"; // Forward to success.jsp
        }else {

        // Add error message and return to login.jsp
        	 String data="Invalid Credentials!! ";
         	model.addAttribute("data",data);
         	model.addAttribute("user",user);

        return "error2";
        }
    }
    
    
    
    
    
    
    
    
}
