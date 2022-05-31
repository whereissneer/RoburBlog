package pl.roburblog.blog.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.roburblog.blog.Service.PostService;
import pl.roburblog.blog.entity.Post;
import pl.roburblog.blog.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired 
	private PostRepository postRepository;

	@Override
	public Post getById(Long id) {
		return postRepository.getReferenceById(id);
	}

	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}
	
	

}
