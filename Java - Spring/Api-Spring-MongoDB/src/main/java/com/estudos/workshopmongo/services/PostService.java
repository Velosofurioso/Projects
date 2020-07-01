package com.estudos.workshopmongo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.estudos.workshopmongo.domain.Post;
import com.estudos.workshopmongo.dto.PostDTO;
import com.estudos.workshopmongo.repository.PostRepository;
import com.estudos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repositorio;
	
	@Autowired
	private UserService uService;
	
	
	public Post findById(String id) {
		Optional<Post> post =  repositorio.findById(id);
		
		if (!post.isPresent()) {
			throw new ObjectNotFoundException("Post not found");
		}
		
		return post.get();
	}
	
	public Page<Post> findByBody(String text, Pageable pageable){
		return repositorio.findByBodyContainingIgnoreCase(text, pageable);
	}
	
	public Page<Post> findByTitle(String text, Pageable pageable){
		return repositorio.findByTitleRegexPage(text, pageable);
	}
	
	public Page<Post> fullSearch(String text, Date minDate, Date maxDate, Pageable pageable){
		maxDate = new Date(maxDate.getTime() + 24 *60 *60 *1000);
		
		return repositorio.fullSearch(text, minDate, maxDate, pageable);
	}
	
	public void delete(String id) {
		findById(id);
		repositorio.deleteById(id);
	}
	
	public Post insert(Post post) {
		return repositorio.insert(post);
	}
	
	public Post update(Post post) {
		Post oldPost = findById(post.getId());
		updateData(oldPost, post);
		return repositorio.save(oldPost);
	}
	
	public Post fromDTO(PostDTO postDTO) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		String name = uService.findNameById(postDTO.getAuthor().getId());
		
		if(name == null || name.isEmpty())
			throw new ObjectNotFoundException("User not found");
		
		
		postDTO.getAuthor().setName(name);
		
		try {
			return new Post(null, sdf.parse(postDTO.getDate()), postDTO.getTitle(), postDTO.getBody(), postDTO.getAuthor(), postDTO.getComments());
		} 
		
		catch (ParseException e) {
			return new Post(null, new Date(), postDTO.getTitle(), postDTO.getBody(), postDTO.getAuthor(), postDTO.getComments());
		} 
		
	}
	
	private void updateData(Post oldPost, Post post) {
		
		oldPost.setDate(post.getDate());
		oldPost.setTitle(post.getTitle());
		oldPost.setBody(post.getBody());
		oldPost.setAuthor(post.getAuthor());
		oldPost.setComments(post.getComments());
		
	}
	
}
