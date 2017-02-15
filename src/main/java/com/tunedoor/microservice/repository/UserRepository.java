package com.tunedoor.microservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tunedoor.microservice.model.User;

/**
 * 
 * @author Mohamed Saeed
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
