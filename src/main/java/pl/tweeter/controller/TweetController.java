package pl.tweeter.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.tweeter.entity.Tweet;
import pl.tweeter.entity.User;
import pl.tweeter.repository.TweetRepo;
import pl.tweeter.repository.UserRepo;

@Controller
@RequestMapping("/tweet")
public class TweetController {
	@Autowired
	TweetRepo tweetRepo;
	@Autowired
	UserRepo userRepo;

	@GetMapping("/add")
	public String add(Model model, HttpServletRequest request) {
		Tweet tweet = new Tweet();
		model.addAttribute("tweet", tweet);
		return "formTweet";
	}

	@PostMapping("/add")
	public String addNew(@Valid @ModelAttribute Tweet tweet, BindingResult result, Model model,
			HttpServletRequest request) {

		tweet.setCreated(LocalDateTime.now());

		HttpSession sess = request.getSession();
		User user = (User) sess.getAttribute("user");
		tweet.setUser(user);

		tweetRepo.save(tweet);
		return "redirect:/main";

	}

	@GetMapping("/like/{id}")
	public String like(@PathVariable int id) {
		Tweet tweet = tweetRepo.findById(id);

		int likes = tweet.getLikes();

		tweet.setLikes(likes + 1);
		tweetRepo.save(tweet);

		return "redirect:/main";
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