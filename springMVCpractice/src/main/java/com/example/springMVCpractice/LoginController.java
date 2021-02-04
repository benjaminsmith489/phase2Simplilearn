package com.example.springMVCpractice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value ="/login")
	public String index(@RequestParam("name") String name, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
		boolean token = false;
		Iterable<User> itr = userRepository.findAll(); 
		for(User user : itr) {
			if(name.equals(user.getName()) && password.equals(user.getPassword())) {
				return "succes";
			}
		}
		System.out.println("Sorry ");
		return "sorry";
	}
}
