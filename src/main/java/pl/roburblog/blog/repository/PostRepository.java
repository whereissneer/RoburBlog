package pl.roburblog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.roburblog.blog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
