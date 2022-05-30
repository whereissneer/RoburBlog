package ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import pl.roburblog.blog.Service.PostService;
import pl.roburblog.blog.entity.Post;
import pl.roburblog.blog.repository.PostRepository;

public class PostServiceImpl implements PostService{
	
	@Autowired 
	private PostRepository postRepository;

	@Override
	public Post getById(Long id) {
		return postRepository.getReferenceById(id);
	}
	
	

}
