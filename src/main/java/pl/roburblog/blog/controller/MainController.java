package pl.roburblog.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pl.roburblog.blog.Service.PostService;
import pl.roburblog.blog.entity.User;

@Controller
public class MainController {
	
	@Autowired
	PostService postService;

	@GetMapping({"/", ""})
	public String getMainPage(Model model) {
		model.addAttribute("posts", postService.getAllPosts());
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
	@GetMapping("/post/{id}")
	public String viewPost(Model model, @PathVariable Long id) {
		model.addAttribute("post", postService.getById(id));
		return "viewPost";
		
	}
	
}
