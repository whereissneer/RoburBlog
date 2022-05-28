package pl.roburblog.blog.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> {
				try {
					authz
						.antMatchers(HttpMethod.GET, "/").permitAll()
						.antMatchers(HttpMethod.GET, "/login").permitAll()
					    .anyRequest().authenticated()
					    .and()
					    .formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
            );
        return http.build();
    }

}