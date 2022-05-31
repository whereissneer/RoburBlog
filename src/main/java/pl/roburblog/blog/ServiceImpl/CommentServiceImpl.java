package pl.roburblog.blog.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.roburblog.blog.Service.CommentService;
import pl.roburblog.blog.entity.Comment;
import pl.roburblog.blog.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired CommentRepository commentRepository;
	
	@Override
	public List<Comment> getAllCommentsOfPost(Long postId) {
		return commentRepository.getCommentsByPost(postId);
	}
	
}
