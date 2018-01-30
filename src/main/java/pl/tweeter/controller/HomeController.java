package pl.tweeter.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
	public String loginTry(HttpServletRequest request, Model model, @RequestParam String email,
			@RequestParam String password) {

		User user = userRepo.findByPasswordAndEmail(email, password);

		if (user == null) {
			model.addAttribute("wrong", "t");
			return "redirect:/login";
		} else {
			String accType = user.getAccType();
			HttpSession sess = request.getSession();
			sess.setAttribute("login", true);
			sess.setAttribute("accType", accType);
			sess.setAttribute("user", user);
			return "redirect:/main";
		}
	}

	@GetMapping("/main")
	public String home(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		List<Tweet> tList = tweetRepo.findByUser(user);
		model.addAttribute("tList", tList);
		return "main";
	}

	@GetMapping("/logout")
	public String logut(HttpServletRequest request) {
		HttpSession sess = request.getSession();
		sess.invalidate();
		return "redirect:/login";
	}

	@GetMapping("/")
	public String main() {
		return "main";
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
