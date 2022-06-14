package pl.roburblog.blog.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.roburblog.blog.Service.CommentService;
import pl.roburblog.blog.Service.PostService;
import pl.roburblog.blog.entity.Comment;
import pl.roburblog.blog.entity.Post;
import pl.roburblog.blog.entity.User;

@Controller
public class MainController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	CommentService commentService;

	@GetMapping({"/", ""})
	public String getMainPage(Model model) {
		model.addAttribute("posts", postService.getAllPosts());
		return "index";
	}
//	@GetMapping("/login")
//	public String getLoginPage(Model model) {
//		User user = new User();
//		model.addAttribute("user", user);
//		return "login";
//	}
	@GetMapping("/addNewPost")
	public String getNewPostForm() {
		return "newPostForm";
	}
	@GetMapping("/post/{id}")
	public String viewPost(Model model, @PathVariable Long id) {
		if(!commentService.getAllCommentsOfPost(id).isEmpty()) {
			model.addAttribute("comments", commentService.getAllCommentsOfPost(id));
		}
		Comment comment = new Comment();
		model.addAttribute("post", postService.getById(id));
		model.addAttribute("comment", comment);
		return "viewPost";
		
	}
	@RequestMapping(value="/post/{id}/addComment", method = {RequestMethod.GET, RequestMethod.POST})
	public String addComment(@PathVariable Long id, @ModelAttribute("comment") Comment comment) {
		Comment commentToSave = new Comment();
		commentToSave.setUser(comment.getUser());
		commentToSave.setCommentContent(comment.getCommentContent());
		commentToSave.setPostToMap(postService.getById(id));
		commentToSave.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		commentService.saveComment(commentToSave);
		return "redirect:/post/"+id;
	}
}
