package com.example.springMVCpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value ="/add")
	public String addNewUser (@RequestParam String name, @RequestParam String password) {
		
		Iterable<User> list = userRepository.findAll();
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		boolean doesExist = false;
		for(User record : list){
			if(record.equals(user)) {
				doesExist = true;
				break;
			}
		}
		if(!doesExist) {
			userRepository.save(user);
			return "add";
		}
		return "userExists";
	}
}
