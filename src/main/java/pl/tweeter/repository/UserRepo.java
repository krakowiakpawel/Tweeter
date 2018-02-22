package pl.tweeter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.tweeter.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.email = :email AND u.password = :password")
	User findByPasswordAndEmail(@Param("email") String email, @Param("password") String password);

	User findById(int id);
	
	User findByEmail(String email);
}
