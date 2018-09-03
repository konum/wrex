package org.wrex.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.wrex.dao.UsersRepository;
import org.wrex.dto.UsersDTO;
import org.wrex.entities.Users;
import org.wrex.mappers.UserMapper;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	@Autowired
	private UsersRepository repo;
	
	@RequestMapping(value="/auth",method=RequestMethod.POST)
	public UsersDTO checkLogin(@RequestBody UsersDTO req) {
		Optional<Users> user = repo.findById(req.getUsername());
		if (user.isPresent() && user.get().getPassword().equals(req.getPassword())) {
			return UserMapper.INSTANCE.entityToDTO(user.get());
		}else
			return null;
			
	}
}
