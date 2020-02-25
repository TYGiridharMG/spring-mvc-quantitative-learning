package com.tyss.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tyss.springmvc.beans.UserBean;
/**
 * This class is a controller which accepts request and forward it to jsp.
 * To declare a class as a controller we have to annotate the class with
 * @Controller. This will tell the spring to consider this class as controller
 * 
 * @author Giridhara
 *
 */
@Controller
public class SpringController {
	/**
	 * This method is a handler method.
	 * To make a method as handler method
	 * we have to annotate with @RequestMapping.
	 * ModelMap is class which is used to send some
	 * information to UI. It acts as a request attribute
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello(ModelMap map) {
		map.addAttribute("msg", "Hello Spring MVC!!!!!");
		return "index";
	}

	/**
	 * To specify the Http method for a handler method we can use
	 * @(Http Method)Mapping. For example @GetMapping, @PostMapping
	 * @PutMapping, etc. To get the query string we use @RequestParam
	 * 
	 * @param name
	 * @param sal
	 * @param map
	 * @return
	 */
	@GetMapping("/query")
	public String query(@RequestParam("name") String name, @RequestParam(name = "sal", required = false) Integer sal,
			ModelMap map) {
		map.addAttribute("name", name);
		map.addAttribute("sal", sal);
		return "query";
	}

	/**
	 * A handler method just to access the form.jsp
	 * 
	 * @return
	 */
	@GetMapping("/form")
	public String form() {
		return "form";
	}

//	@PostMapping("/form")
//	public String form(String name, String email, 
//			String password, String gender, ModelMap map) {
//		map.addAttribute("name", name);
//		map.addAttribute("email", email);
//		map.addAttribute("password", password);
//		map.addAttribute("gender", gender);
//		return "form-data";
//	}
	
	/**
	 * We can get the form data by using variables or
	 * we can use Bean object to get all the data at once
	 * 
	 * @param bean
	 * @param map
	 * @return
	 */
	@PostMapping("/form")
	public String form(UserBean bean, ModelMap map) {
		map.addAttribute("bean", bean);
		return "form-data";
	}
	
	/**
	 * We can send the data by path also.
	 * To get the data we use @PathVariable annotation
	 * This handler method is an example for that
	 * 
	 * @param name
	 * @param map
	 * @return
	 */
	@GetMapping("/path/{name}")
	public String path(@PathVariable("name") String name, ModelMap map) {
		map.addAttribute("name", name);
		return "path";
	}

	/**
	 * This controller handler method helps to create a cookie with a name api-key
	 * 
	 * @param response
	 * @return
	 */
	@GetMapping("/create-cookie")
	public String createCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("api-key", "Api-123456789qwerty");
		cookie.setMaxAge(24*7*60*60);
		response.addCookie(cookie);
		return "create-cookie";
	}

	/**
	 * This controller handler method to get the cookie with the name api-key
	 * 
	 * @param apiKey
	 * @param map
	 * @return
	 */
	@GetMapping("/get-cookie")
	public String getCookie(@CookieValue(name = "api-key", required = false) String apiKey, 
			ModelMap map) {
		map.addAttribute("cookieName", apiKey);
		return "get-cookie";
	}
	
	@GetMapping("/forward")
	public String forward() {
		return "forward:hello";
	}
	
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:http://www.google.com";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(String username, String password, ModelMap map, HttpServletRequest request) {
		if(username.equals("user") && password.equals("password")) {
			UserBean bean = new UserBean();
			bean.setName(username);
			bean.setPassword(password);
			bean.setEmail("user@domain.com");
			bean.setGender("A");
			HttpSession session = request.getSession();
			session.setAttribute("bean", bean);
			return "home";
		} else {
			map.addAttribute("msg", "Invalid Credentials");
			return "login";
		}
	}
	
	@GetMapping("/home")
	public String home(@SessionAttribute(name = "bean", required = false)UserBean bean) {
		if(bean==null) {
			return "login";
		}
		return "home";
	}
}
















