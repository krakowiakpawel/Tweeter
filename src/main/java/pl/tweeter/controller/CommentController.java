package pl.tweeter.controller;

import java.time.LocalDateTime;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.tweeter.entity.Comment;
import pl.tweeter.entity.Tweet;
import pl.tweeter.entity.User;
import pl.tweeter.repository.CommentRepo;
import pl.tweeter.repository.TweetRepo;
import pl.tweeter.repository.UserRepo;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	TweetRepo tweetRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	CommentRepo commentRepo;

	@GetMapping("/")
	public String main() {

		return "test";
	}

	@GetMapping("/{id}")
	public String comment(@PathVariable int id, Model model) {
		Tweet tweet = tweetRepo.findById(id);
		List<Comment> comList = commentRepo.findByTweet(tweet);
		model.addAttribute("comList", comList);
		model.addAttribute("tweet", tweet);
		Comment comment = new Comment();
		model.addAttribute("comment", comment);
		return "comment";
	}

	@PostMapping("/{id}")
	public String addNew(@ModelAttribute Comment comment, BindingResult result, Model model, HttpServletRequest request,
			@PathVariable int id) {
		Tweet tweet = tweetRepo.findById(id);
		comment.setTweet(tweet);
		comment.setCreated(LocalDateTime.now());

		HttpSession sess = request.getSession();
		User user = (User) sess.getAttribute("user");
		comment.setUser(user);

		commentRepo.save(comment);

		return "redirect:/comment/" + id;
	}

	@GetMapping("/like/{id}")
	public String like(@PathVariable int id) {
		Comment comment = commentRepo.findById(id);

		int likes = comment.getLikes();

		comment.setLikes(likes + 1);
		commentRepo.save(comment);
		int tId = comment.getTweet().getId();

		return "redirect:/comment/" + tId;
	}

}
