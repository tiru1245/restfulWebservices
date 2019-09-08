package com.tiru.restfulwebservice.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tiru.restfulwebservice.beans.User;
import com.tiru.restfulwebservice.dao.UserDaoService;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userDaoService;

	//retriveAllUser
	@GetMapping(path="/user")

	public List<User> getAllUsers(){
		return userDaoService.findAll();
	}
	//retriveUserId
	@GetMapping(path="/user/{id}")
	public Resource<User> getUSer(@PathVariable Integer id) {
		User u= userDaoService.findOne(id);
		if(u==null)
		{
			throw new UserNotFoundException("id-"+id);
		}
		Resource<User> resource =new Resource<User>(u);
		
		ControllerLinkBuilder link= linkTo(methodOn(this.getClass()).getAllUsers());
		resource.add(link.withRel("all-user"));
		return resource;
	}
	//saveUser
		@PostMapping(path="/user/")
		public ResponseEntity<Object> getSave(@Valid @RequestBody User u) {
			 User saveUser=userDaoService.save(u);
			URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
			return  ResponseEntity.created(location).build();
		}
		
	
}
