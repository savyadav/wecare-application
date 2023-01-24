package com.carelifecoach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carelifecoach.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findById(String userId);

}
