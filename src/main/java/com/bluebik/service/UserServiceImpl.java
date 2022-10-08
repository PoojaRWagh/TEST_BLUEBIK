package com.bluebik.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebik.model.User;
import com.bluebik.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userrepository;
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userrepository.save(user);
	}

	@Override
	public List<User> allUser() {
		// TODO Auto-generated method stub
		return userrepository.findAll();
	}

	@Override
	public User updateUser(User user,int userid) {
		// TODO Auto-generated method stub
		User user1=userrepository.getById(userid);
		user1.setFirst_Name(user.getFirst_Name());
		user1.setLast_Name(user.getLast_Name());
		return userrepository.save(user1);
	}

	@Override
	public void deleteUser(int userid) {
		// TODO Auto-generated method stub
		User user1=userrepository.getOne(userid);
		userrepository.delete(user1);
	}

	@Override
	public List<User> searchUser(String query) {
		// TODO Auto-generated method stub
		List<User> user=userrepository.searchUser(query);
		return user;
	}

	@Override
	public List<User> saveAllUser(List<User> users) {
		// TODO Auto-generated method stub
		return userrepository.saveAll(users);
	}

	@Override
	public void deleteMultiUser(int[] userid) {
		// TODO Auto-generated method stub
			for(int i=0;i<userid.length;i++)
			{
				int id=userid[i];
				User user=userrepository.getById(id);
				userrepository.delete(user);
			}
		
	}

	@Override
	public List<User> updateMultiUser(User[] user, int[] userid) {
		List<User> newuser=new ArrayList();
		for (int i=0;i<user.length;i++) 
		{
		User user1=userrepository.getById(userid[i]);
		user1.setFirst_Name(user[i].getFirst_Name());
		user1.setLast_Name(user[i].getLast_Name());
		newuser.add(user1);
		}
		return userrepository.saveAll(newuser);
	}

}
