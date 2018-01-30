package pl.tweeter.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.tweeter.entity.User;
import pl.tweeter.repository.UserRepo;

public class UserConverter implements Converter<String, User> {
	@Autowired
	private UserRepo userRepo;

	public User convert(String source) {
		User User = userRepo.findById(Integer.parseInt(source));
		return User;
	}
}
