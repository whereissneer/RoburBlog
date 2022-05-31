package pl.roburblog.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.roburblog.blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	@Query(value="SELECT * FROM comment WHERE post_id =:post_id", nativeQuery = true)
	List<Comment> getCommentsByPost(@Param("post_id") Long post_id);
}
