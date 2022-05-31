package pl.roburblog.blog.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String postTitle;
	
	@Column(length = 65535,columnDefinition="Text")
	private String postContent;
	private Timestamp createdAt;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="author_id", referencedColumnName = "id")
	private User owner;
	
	@OneToMany(mappedBy = "postToMap", cascade = CascadeType.ALL)
	private Set<Comment> commentsIds = new HashSet<>();

	public Post() {
		super();
	}

	public Post(String postTitle, String postContent, Timestamp createdAt, User owner, Set<Comment> commentsIds) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.createdAt = createdAt;
		this.owner = owner;
		this.commentsIds = commentsIds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Set<Comment> getCommentsIds() {
		return commentsIds;
	}

	public void setCommentsIds(Set<Comment> commentsIds) {
		this.commentsIds = commentsIds;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commentsIds, createdAt, id, owner, postContent, postTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(commentsIds, other.commentsIds) && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(id, other.id) && Objects.equals(owner, other.owner)
				&& Objects.equals(postContent, other.postContent) && Objects.equals(postTitle, other.postTitle);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", postTitle=" + postTitle + ", postContent=" + postContent + ", createdAt="
				+ createdAt + ", owner=" + owner + ", commentsIds=" + commentsIds + "]";
	}

	

	
}
