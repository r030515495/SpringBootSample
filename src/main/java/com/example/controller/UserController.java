package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bean.User;
import com.example.dao.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/add") // Map ONLY GET Requests
	public String addNewUser(@ModelAttribute User user) {
		userRepository.save(user);
		return "redirect:all";
	}

	@RequestMapping("/all")
	public String all(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "userList";
	}

	@RequestMapping("/addPage")
	public String addPage(Model model) {
		model.addAttribute("user", new User());
		return "addPage";
	}

}
