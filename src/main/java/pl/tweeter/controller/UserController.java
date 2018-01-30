package pl.tweeter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.tweeter.entity.User;
import pl.tweeter.repository.UserRepo;

@Controller("/user")
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepo userRepo;

	@GetMapping("/add")
	public String home(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "formUser";
	}

	@PostMapping("/add")
	public String addNew(@Valid @ModelAttribute User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "formUser";
		} else {
			userRepo.save(user);
			return "redirect:/";
		}
	}

}
