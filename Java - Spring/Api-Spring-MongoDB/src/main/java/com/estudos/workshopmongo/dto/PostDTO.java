package com.estudos.workshopmongo.dto;

import java.io.Serializable;
import java.util.List;

public class PostDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String date;
	private String title;
	private String body;
	private AuthorDTO author;
	private List<CommentDTO> comments;
	
	
	public PostDTO() {
	}


	public PostDTO(String id, String date, String title, String body, AuthorDTO author, List<CommentDTO> comments) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
		this.comments = comments;	
	}
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public AuthorDTO getAuthor() {
		return author;
	}


	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}


	public List<CommentDTO> getComments() {
		return comments;
	}


	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}
	
	

}
