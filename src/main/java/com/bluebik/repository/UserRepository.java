package com.bluebik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bluebik.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query(value="SELECT * FROM USERS u WHERE U.FIRST_NAME LIKE CONCAT('%',:query,'%')", nativeQuery=true)
List<User> searchUser(String query);
}
