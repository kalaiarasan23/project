package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.UsersRepository;
import com.example.demo.entityClasses.Users;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class UsersController {
	private final UsersRepository userRepository;

	public UsersController(UsersRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping
	public String login() {
		return "login";
	}
	
	@PostMapping
	public String afterLogin(@RequestParam("userName") String userName, HttpSession session, Model model) {
		Optional<Users> users = userRepository.findByUserName(userName);
		System.out.println(users);
		if(users.isPresent()) {
			session.setAttribute("users", users.get());
			return "redirect:/todos";
		}
		else {
			model.addAttribute("error", "Invalid username or password");
			return "/login";
		}
	}
}
