package pl.roburblog.blog.Service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import pl.roburblog.blog.entity.User;

@Service
public interface UserService extends UserDetailsService{
	User getByUserName(String userName);
	
	Optional<User> getById(Long id);
	
	
	
}
