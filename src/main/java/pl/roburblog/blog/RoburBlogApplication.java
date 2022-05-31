package pl.roburblog.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = pl.roburblog.blog.repository.UserRepository.class)
public class RoburBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoburBlogApplication.class, args);
	}

}
