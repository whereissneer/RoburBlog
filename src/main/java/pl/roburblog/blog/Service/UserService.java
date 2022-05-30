package pl.roburblog.blog.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import pl.roburblog.blog.entity.User;

@Service
public interface UserService {
	Optional<User> getByUserName(String userName);
	
	Optional<User> getById(Long id);
	
	
	
}
