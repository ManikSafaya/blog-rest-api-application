package com.manik.apis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manik.apis.entities.Category;
import com.manik.apis.entities.Post;
import com.manik.apis.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	//List<Post> findByTitleContaining(String keyword);
	@Query("select p from Post p where p.title like :key ")
	List<Post> searchPostsByTitle(@Param("key") String keyword);

}
