package pl.roburblog.blog.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	private String password;
	private String email;
	private String role = "ROLE_USER";
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private Set<Post> ownedPostsIds = new HashSet<>();
	
	
	public User() {
		super();
	}
	
	public User(String userName, String password, String email, String role, Set<Post> ownedPostsIds) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
		this.ownedPostsIds = ownedPostsIds;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<Post> getOwnedPostsIds() {
		return ownedPostsIds;
	}
	public void setOwnedPostsIds(Set<Post> ownedPostsIds) {
		this.ownedPostsIds = ownedPostsIds;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, ownedPostsIds, password, role, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(ownedPostsIds, other.ownedPostsIds) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + ", role="
				+ role + ", ownedPostsIds=" + ownedPostsIds + "]";
	}
	
	
}
