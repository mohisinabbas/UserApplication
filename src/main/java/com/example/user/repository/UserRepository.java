
package com.example.user.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.user.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {
	
	Optional<User> findByPhone(String phone);
	
	User findById(int id);

	@Modifying
	@Query("delete from User where id = :id")
	void deleteUser(@Param("id") int id);
	
	
}
