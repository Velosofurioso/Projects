package com.estudos.workshopmongo.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.estudos.workshopmongo.domain.Post;
import com.estudos.workshopmongo.repository.PostRepository;
import com.estudos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repositorio;
	
	
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
	
}
