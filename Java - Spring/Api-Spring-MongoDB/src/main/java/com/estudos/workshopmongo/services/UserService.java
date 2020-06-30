package com.estudos.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.estudos.workshopmongo.domain.User;
import com.estudos.workshopmongo.dto.UserDTO;
import com.estudos.workshopmongo.repository.UserRepository;
import com.estudos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repositorio;

	public Page<User> findAll(Pageable pageable) {
		return repositorio.findAll(pageable);
	}

	public User findById(String id) {

		Optional<User> user = repositorio.findById(id);

		if (!user.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}

		return user.get();
	}

	public User insert(User user) {
		return repositorio.insert(user);
	}
	
	public void delete(String id) {
		findById(id);
		repositorio.deleteById(id);
	}
	
	public User update(User user) {
		User oldUser = findById(user.getId());
		updateData(oldUser, user);
		return repositorio.save(oldUser);
	}
	
	private void updateData(User oldUser, User user) {
		oldUser.setName(user.getName());
		oldUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
