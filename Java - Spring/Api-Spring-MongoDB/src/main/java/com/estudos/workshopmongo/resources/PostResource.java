package com.estudos.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
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
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size		
	){
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "post");
		
		text = URL.decodeParam(text);
		Page<Post> posts = postService.findByTitle(text, pageRequest);
		
		HttpHeaders header = new HttpHeaders();
		int next = posts.getNumber() + 1; 
		
		if (next < posts.getTotalPages()) 
			header.add("next-page", "http://localhost:8080/post/titlesearch?text="+text+"&page=" + next);
		
		return ResponseEntity.ok().headers(header).body(posts.getContent());
	}
	
	
	@ApiOperation(value = "Returns a post list using the post text as a parameter")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Returns a post list"))
	@RequestMapping(value = "/bodysearch", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Post>> findByBody(@RequestParam(value="text", defaultValue = "") String text,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "1") int size				
	){
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "post");
		
		text = URL.decodeParam(text);
		Page<Post> posts = postService.findByBody(text, pageRequest);
		
		HttpHeaders header = new HttpHeaders();
		int next = posts.getNumber() + 1; 
		
		if (next < posts.getTotalPages()) 
			header.add("next-page", "http://localhost:8080/post/bodysearch?text="+text+"&page=" + next);
		
		return ResponseEntity.ok().headers(header).body(posts.getContent());	
	}
	
	
	@ApiOperation(value = "Returns a post list using the post text and dates as a parameter")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Returns a post list"))
	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Post>> fullsearch(
			@RequestParam(value="text", defaultValue = "") String text, 
			@RequestParam(value="minDate", defaultValue = "") String minDate, 
			@RequestParam(value="maxDate", defaultValue = "") String maxDate,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "1") int size
	) {
		
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "post");
		
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		
		Page<Post> posts = postService.fullSearch(text, min, max, pageRequest);
		
		HttpHeaders header = new HttpHeaders();
		int next = posts.getNumber() + 1; 
		
		if (next < posts.getTotalPages()) 
			header.add("next-page", "http://localhost:8080/post/fullsearch?text="+text+
						"&minDate="+minDate+"&maxDate="+maxDate+"&page=" + next);
		
		
		return ResponseEntity.ok().headers(header).body(posts.getContent());
	}
}
