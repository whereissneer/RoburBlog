package pl.roburblog.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.roburblog.blog.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUserName(String userName);
	
	Optional<User> findById(Long id);
}
