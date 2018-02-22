package pl.tweeter.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column
	@NotNull
	String username;

	@Column
	@NotNull
	String password;

	@Column
	@Email
	@NotNull
	String email;
	
	@Column
	@NotNull
	String accType = "basic";
	//(admin, basic)
	
	@OneToMany(mappedBy = "user")
	private List<Tweet> tweets = new ArrayList<Tweet>();
	
	
	@OneToMany(mappedBy = "user")
	private List<Comment> comments = new ArrayList<Comment>();
	

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getUsername() {
		return username;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public boolean checkPassword(String pass) {
		return BCrypt.checkpw(pass, this.password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}
	
	
}
