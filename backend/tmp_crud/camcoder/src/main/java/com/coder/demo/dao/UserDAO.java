package com.coder.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coder.demo.vo.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{
	User findByUserCode(@Param("userCode") long userCode);
	User findByUserId(@Param("userId") String userId);
	List<User> findAll();
}
