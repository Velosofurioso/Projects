package com.estudos.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudos.workshopmongo.domain.Post;
import com.estudos.workshopmongo.domain.User;
import com.estudos.workshopmongo.dto.UserDTO;
import com.estudos.workshopmongo.services.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService uService;
	
	
	@ApiOperation(value = "Returns a list of users ")
	@ApiResponses(value = @ApiResponse(code = 200, message =  "Returns the list of users"))
	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> userList = uService.findAll();
		
		List<UserDTO> userListDTO = userList.stream()
									.map(x  -> new UserDTO(x))
									.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(userListDTO);
	}
	
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Returns a user"),
		    @ApiResponse(code = 404, message = "User Not Found"),
	})
	@ApiOperation(value = "Return a user from id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		
		User user = uService.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	
	@ApiOperation(value = "Return all user posts from id")
	@ApiResponses(value = @ApiResponse(code = 200, message = "Returns the list of user posts"))
	@RequestMapping(value = "/{id}/posts", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		
		User user = uService.findById(id);
		
		return ResponseEntity.ok().body(user.getPosts());
	}
	

	@ApiOperation(value = "Create a new User")
	@ApiResponses(value = @ApiResponse(code = 201, message = "Create a user from Json"))
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Void> insert(@RequestBody UserDTO user){
		
		User newUser = uService.fromDTO(user);
		newUser = uService.insert(newUser); 	
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();				
		return ResponseEntity.created(uri).build();
	}

	
	@ApiOperation(value = "Deletes a user by id")
	@ApiResponses(value = @ApiResponse(code = 204, message = "Deleted user"))
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		
		uService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@ApiOperation(value = "Updates a user's data")
	@ApiResponses(value = @ApiResponse(code = 204, message = "Updates a user by Id"))
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO UpdtUser){
		
		User oldUser = uService.fromDTO(UpdtUser);
		oldUser.setId(id);
		oldUser = uService.update(oldUser);
		
		return ResponseEntity.noContent().build();
	}
	
}