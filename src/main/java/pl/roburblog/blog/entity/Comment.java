package pl.roburblog.blog.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String user;
	@Column(length = 65535,columnDefinition="Text")
	private String commentContent;
	private Timestamp createdAt;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="post_id", referencedColumnName = "id")
	private Post postToMap;

	public Comment() {
		super();
	}

	public Comment(String user, String commentContent, Timestamp createdAt, Post postToMap) {
		super();
		this.user = user;
		this.commentContent = commentContent;
		this.createdAt = createdAt;
		this.postToMap = postToMap;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Post getPostToMap() {
		return postToMap;
	}

	public void setPostToMap(Post postToMap) {
		this.postToMap = postToMap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commentContent, createdAt, id, postToMap, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(commentContent, other.commentContent) && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(id, other.id) && Objects.equals(postToMap, other.postToMap)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", user=" + user + ", commentContent=" + commentContent + ", createdAt="
				+ createdAt + ", postToMap=" + postToMap + "]";
	}

	
}
