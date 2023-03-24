package com.springboot.controller;

import com.springboot.entity.User;
import com.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	@GetMapping("/users")
	public String printUsers(Model model) {
		model.addAttribute("users", userService.findAll());
		return "user-list";
	}

	@GetMapping("/user-create")
	public String createUserForm() {
		return "user-create";
	}

	@PostMapping("/user-create")
	public String addUser(User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}

	@GetMapping("/user-delete/{id}")
	public String deleteUserFromTable(@PathVariable ("id") Long id) {
		userService.deleteById(id);
		return "redirect:/users";
	}

	@GetMapping("/user-update/{id}")
	public String updateUserForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.findById(id));
		return "user-update";
	}

	@PostMapping("/user-update")
	public String updateUser(User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}
}