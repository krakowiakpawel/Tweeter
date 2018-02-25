package pl.tweeter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.tweeter.entity.Tweet;
import pl.tweeter.entity.User;

public interface TweetRepo extends JpaRepository<Tweet, Integer> {

List <Tweet> findByUser(User user);


Tweet findById(int id);
}
