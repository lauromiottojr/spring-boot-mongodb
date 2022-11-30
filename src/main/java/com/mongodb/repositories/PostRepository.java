package com.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.models.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
