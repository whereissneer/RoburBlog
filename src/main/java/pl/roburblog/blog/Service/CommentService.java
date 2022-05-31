package pl.roburblog.blog.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.roburblog.blog.entity.Comment;

@Service
public interface CommentService {
	List<Comment> getAllCommentsOfPost(Long postId);
	
	Comment saveComment(Comment comment);
}
