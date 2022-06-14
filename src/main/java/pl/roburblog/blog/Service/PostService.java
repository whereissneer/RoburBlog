package pl.roburblog.blog.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.roburblog.blog.entity.Post;

@Service
public interface PostService {
	Post getById(Long id);
	
	List<Post> getAllPosts();
	
	void createPost(Post post);
}
