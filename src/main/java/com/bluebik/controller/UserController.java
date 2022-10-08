package com.bluebik.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bluebik.model.User;
import com.bluebik.service.UserServiceImpl;

@RestController
@RequestMapping("/")
public class UserController {
	@Autowired
	UserServiceImpl userserviceimpl;
	//Adding single User 
	@PostMapping("/")
	public ResponseEntity<User> newUser(@Valid @RequestBody User user)
	{
		return ResponseEntity.ok(this.userserviceimpl.createUser(user));
	}
	//Getting list of all user
	@GetMapping("/alluser")
	public List<User> allUser()
	{
		return userserviceimpl.allUser();
	}
	//Updating user information
	@PostMapping("/update/{userid}")
	public User update(@Valid @RequestBody User user,@PathVariable int userid)
	{
		userserviceimpl.updateUser(user, userid);
		return user;
		}
	//Deleting user using userid
	@DeleteMapping("/delete/{userid}")
	public void deleteUser(@PathVariable int userid)
	{
		userserviceimpl.deleteUser(userid);
	}
	//Searching user by firstname using JPQl  
	@GetMapping("/search")
	public ResponseEntity<List<User>> searchUser(@RequestParam("query") String query)
	{
		return ResponseEntity.ok(userserviceimpl.searchUser(query));
	}
	//Creating multiple Users
	@PostMapping("/multiuser")
	public ResponseEntity<List<User>> newUser(@Valid @RequestBody List<User> users)
	{
		return ResponseEntity.ok(this.userserviceimpl.saveAllUser(users));
	}
	//Deleting Multi User
	@DeleteMapping("/deletemulti/{userid}")
	public void deleteMultiUser(@PathVariable int[] userid)
	{ 
		userserviceimpl.deleteMultiUser(userid);
	}
	//Updating Multiple Users 
	@PostMapping("/updatemulti/{userid}")
	public User[] updateMulti(@Valid @RequestBody User[] user,@PathVariable int[] userid)
	{
		userserviceimpl.updateMultiUser(user, userid);
		return user;
		}
	

}
