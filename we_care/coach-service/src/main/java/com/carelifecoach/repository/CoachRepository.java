package com.carelifecoach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carelifecoach.entity.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
	Coach findById(String userId);

}
