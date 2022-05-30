package pl.roburblog.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.roburblog.blog.entity.User;

@Controller
public class MainController {

	@GetMapping({"/", ""})
	public String getMainPage() {
		return "index";
	}
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	@GetMapping("/addNewPost")
	public String getNewPostForm() {
		return "newPostForm";
	}
	
}
