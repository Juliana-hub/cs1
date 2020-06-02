package cn.edu.scujcc.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.scujcc.Api.UserController;
import cn.edu.scujcc.model.User;

import cn.edu.scujcc.service.UserService;

@RestController   
@RequestMapping("/user")
public class UserController {
	private static final Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService service;
	String tooken;
	@PostMapping("/register")		
    public User register(@RequestBody User u) {
		
		
		User saved=service.createUser(u);
		
		return saved;
	}
	@GetMapping("/login/{username}/{password}")
	public String login(@PathVariable String username,@PathVariable String password) {
		
		boolean status=service.getUser(username,password);
		if(status) {
			
			 tooken=service.checkIn(username);
			
		}
		
		return tooken;
	}



}
