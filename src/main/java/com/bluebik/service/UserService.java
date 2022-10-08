package com.bluebik.service;

import java.util.List;

import com.bluebik.model.User;

public interface UserService {
	public  User createUser(User user);
	public List<User> allUser();
	public User updateUser(User user,int userid);
	public void deleteUser(int id);
	public List<User> searchUser(String query);
	public List<User> saveAllUser(List<User> users);
	public void deleteMultiUser(int userid[]);
	public List<User> updateMultiUser(User[] user,int[] userid);

}

