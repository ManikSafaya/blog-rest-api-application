package com.manik.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manik.apis.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
