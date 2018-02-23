package pl.tweeter.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.tweeter.entity.Tweet;
import pl.tweeter.entity.User;
import pl.tweeter.repository.TweetRepo;
import pl.tweeter.repository.UserRepo;
import pl.tweeter.service.Service;

@Controller
public class HomeController {
	@Autowired
	UserRepo userRepo;
	@Autowired
	TweetRepo tweetRepo;

	@GetMapping("/login")
	public String main(HttpServletRequest request, Model model, @RequestParam(required = false) String wrong) {

		if (wrong != null) {
			model.addAttribute("wrong", "Wrong password! Try again.");
		}

		HttpSession sess = request.getSession();
		Boolean login = (Boolean) sess.getAttribute("login");
		model.addAttribute("login", login);
		return "login";
	}

	@PostMapping("/login")
	public String loginTry(HttpServletResponse response, HttpServletRequest request, Model model, @RequestParam String email,
			@RequestParam String password) {

		User user = userRepo.findByEmail(email);

		if (user == null || !user.checkPassword(password)) {
			Service.setMessageCookie(response, "Wrong login/password, try again!", 10);
			
			return "redirect:/login";
		} else {
			HttpSession sess = request.getSession();
			String name = user.getUsername();
			Service.setMessageCookie(response, "Welcome " + name + "!", 3);
			sess.setAttribute("user", user);
			return "redirect:/main";
		}
	}

	@GetMapping("/logout")
	public String logut(HttpServletRequest request) {
		HttpSession sess = request.getSession();
		sess.invalidate();
		return "redirect:/login";
	}

	@GetMapping("/main")
	public String home(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		List<Tweet> tList = tweetRepo.findByUser(user);
		model.addAttribute("tList", tList);
		return "main";
	}

	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	@GetMapping("/test2")
	public String test2(HttpServletResponse response) throws IOException {
		Service.setMessageCookie(response, "redirect from test2", 20);
		return "test2";
	}

}
// Snippets

// @GetMapping("/home")
// public String home() {
// return "index";
// }
//
// @GetMapping("/hello")
// @ResponseBody
// public String hello() {
// return "Hello";
// }
