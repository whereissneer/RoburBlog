package pl.roburblog.blog.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.roburblog.blog.Service.UserService;
import pl.roburblog.blog.entity.User;
import pl.roburblog.blog.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User getByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public Optional<User> getById(Long id) {
		return userRepository.findById(id);
	}

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User user = userRepository.findByUserName(username); 
		if(user==null) {
			throw new UsernameNotFoundException("didnt find "+ username);
		}
		UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getUserName()).password(user.getPassword()).authorities("ADMIN").build();
		return userDetails;
		
	}

	

}
