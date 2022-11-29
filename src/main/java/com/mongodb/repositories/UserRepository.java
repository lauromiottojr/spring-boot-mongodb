package com.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
