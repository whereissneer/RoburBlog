package pl.roburblog.blog.Service;

import org.springframework.stereotype.Service;

import pl.roburblog.blog.entity.Post;

@Service
public interface PostService {
	Post getById(Long id);
}
