package com.estudos.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.workshopmongo.domain.Post;
import com.estudos.workshopmongo.resources.util.URL;
import com.estudos.workshopmongo.services.PostService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/post")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Returns a Post"),
		    @ApiResponse(code = 404, message = "Post Not Found"),
	})
	@ApiOperation(value = "Return a post from the parameter")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<Post> findById(@PathVariable String id){
		
		Post post = postService.findById(id);
		
		return ResponseEntity.ok().body(post);
		
	}
	
	
	@ApiOperation(value = "Returns a post list using the title as a parameter")
	@ApiResponses(value = @ApiResponse(code = 200, message =  "Returns a post list"))
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text){
		
		text = URL.decodeParam(text);
		List<Post> posts = postService.findByTitle(text);
		
		return ResponseEntity.ok().body(posts);
	}
	
	
	@ApiOperation(value = "Returns a post list using the post text as a parameter")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Returns a post list"))
	@RequestMapping(value = "/bodysearch", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Post>> findByBody(@RequestParam(value="text", defaultValue = "") String text){
		
		text = URL.decodeParam(text);
		List<Post> posts = postService.findByBody(text);
		
		return ResponseEntity.ok().body(posts);	
	}
	
	
	@ApiOperation(value = "Returns a post list using the post text and dates as a parameter")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Returns a post list"))
	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Post>> fullsearch(
			@RequestParam(value="text", defaultValue = "") String text, 
			@RequestParam(value="minDate", defaultValue = "") String minDate, 
			@RequestParam(value="maxDate", defaultValue = "") String maxDate 
	) {
		
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		
		List<Post> posts = postService.fullSearch(text, min, max);
		return ResponseEntity.ok().body(posts);
	}
}
