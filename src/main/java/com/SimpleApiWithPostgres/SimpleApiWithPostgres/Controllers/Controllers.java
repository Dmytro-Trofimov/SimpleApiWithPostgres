

package com.SimpleApiWithPostgres.SimpleApiWithPostgres.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SimpleApiWithPostgres.SimpleApiWithPostgres.Repository.UserRepository;
import com.SimpleApiWithPostgres.SimpleApiWithPostgres.entity.User;


@RestController
@RequestMapping("/user")
public class Controllers {

	@Autowired
	UserRepository repo;
	
	@PostMapping()
	public void postUser(@RequestBody User user){
		repo.save(user);
	}

	
	@GetMapping("/{id}")
	public User getuser(@PathVariable int id){
		return repo.findById(id).get(); 
	}
	
	@GetMapping()
	public List<User> getAllUsers(){
		return repo.findAll();
	}
	
	@PutMapping("/{id}")
	public void changeUser(@PathVariable int id, @RequestBody User updateUser) {
		User user = repo.findById(id).get();
		if(user!=null) {
			user.setName(updateUser.getName());
			user.setCity(updateUser.getCity());
			user.setEmail(updateUser.getEmail());
		}
		repo.save(user);
	}
	
	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable int id) {
		repo.deleteById(id);
	}
	
}
