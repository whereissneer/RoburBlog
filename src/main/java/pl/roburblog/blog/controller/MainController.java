package pl.roburblog.blog.controller;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.roburblog.blog.Service.CommentService;
import pl.roburblog.blog.Service.PostService;
import pl.roburblog.blog.entity.Comment;
import pl.roburblog.blog.entity.Post;

@Controller
public class MainController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	CommentService commentService;

	@GetMapping({"/", ""})
	public String getMainPage(Model model) {
		
		List<Post> sortedPosts = new ArrayList<>();
		
		sortedPosts = postService.getAllPosts().stream()
				.sorted(Comparator.comparing(Post::getCreatedAt).reversed())
				.collect(Collectors.toList());
		model.addAttribute("posts", sortedPosts);
		return "index";
	}
	
//	@GetMapping("/login")
//	public String getLoginPage(Model model) {
//		User user = new User();
//		model.addAttribute("user", user);
//		return "login";
//	}
	
	@GetMapping("/addNewPostForm")
	public String getNewPostForm(Model model) {
		Post post = new Post();
		model.addAttribute("post", post);
		return "newPostForm";
	}
	
	@PostMapping("/addNewPost")
	public String addNewPost(@ModelAttribute("post") Post post, Principal principal) {
		post.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		postService.createPost(post);
		return "redirect:/";
	}
	
	@GetMapping("/post/{id}")
	public String viewPost(Model model, @PathVariable Long id) {
		if(!commentService.getAllCommentsOfPost(id).isEmpty()) {
			List<Comment> sortedComments = new ArrayList<>();
			sortedComments = commentService.getAllCommentsOfPost(id).stream()
					.sorted(Comparator.comparing(Comment::getCreatedAt).reversed())
					.collect(Collectors.toList());
			model.addAttribute("comments", sortedComments);
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
