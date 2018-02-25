package pl.tweeter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.tweeter.entity.Comment;
import pl.tweeter.entity.Tweet;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

	Comment findByTweetId(int id);

	List<Comment> findByTweet(Tweet tweet);
	
	Comment findById(int id);
}
