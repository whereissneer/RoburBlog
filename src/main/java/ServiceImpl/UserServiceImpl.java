package ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import pl.roburblog.blog.Service.UserService;
import pl.roburblog.blog.entity.User;
import pl.roburblog.blog.repository.UserRepository;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<User> getByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public Optional<User> getById(Long id) {
		return userRepository.findById(id);
	}

	

}
