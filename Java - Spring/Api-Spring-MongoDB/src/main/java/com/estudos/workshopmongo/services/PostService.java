package com.estudos.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return post.get();
	}
	
	public List<Post> findByTitle(String text){
		return repositorio.findByTitleContainingIgnoreCase(text);
	}
	
}
