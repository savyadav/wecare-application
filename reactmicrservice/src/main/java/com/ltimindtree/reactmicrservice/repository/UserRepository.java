package com.ltimindtree.reactmicrservice.repository;
import com.ltimindtree.reactmicrservice.entity.User;
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User, Integer> {

}
