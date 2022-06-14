package pl.roburblog.blog.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;




@Configuration
public class SecurityConfiguration{

	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> {
				try {
					authz
						.antMatchers(HttpMethod.GET, "/styles/**").permitAll()
						.antMatchers(HttpMethod.GET, "/icons/**").permitAll()
						.antMatchers(HttpMethod.GET, "/").permitAll()
						.antMatchers(HttpMethod.GET, "/login").permitAll()
						.antMatchers(HttpMethod.GET, "/post/**").permitAll()
						.antMatchers(HttpMethod.POST, "/post/**").permitAll()
						.antMatchers(HttpMethod.GET, "/addNewPost").hasRole("ADMIN")
					    .anyRequest().authenticated()
					    .and()
					    //.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll()
					    .formLogin()
					    .and()
					    .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						.logoutSuccessUrl("/login").deleteCookies("JSESSIONID")
						.invalidateHttpSession(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
            );
        return http.build();
    }
    @Bean
    public UserDetailsService users() {
    	UserBuilder users = User.withDefaultPasswordEncoder();
    	UserDetails user = users
    		.username("user")
    		.password("password")
    		.roles("USER")
    		.build();
    	UserDetails admin = users
    		.username("admin")
    		.password("password")
    		.roles("USER", "ADMIN")
    		.build();
    	return new InMemoryUserDetailsManager(user, admin);
    }
    
    
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}