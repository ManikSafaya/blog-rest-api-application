package com.manik.apis.services;

import java.util.List;

import com.manik.apis.payloads.PostDto;
import com.manik.apis.payloads.PostResponse;

public interface PostService {

	// create
	PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);

	// update
	PostDto updatePost(PostDto postDto, Integer postId);

	// delete
	void deletePost(Integer postId);

	// get single post
	PostDto getPostById(Integer postId);

	// get all posts
	PostResponse getAllPosts(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	// get all posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	List<PostDto> getPostsByUser(Integer userId);

	// get Post by search-- >1st option
	//List<PostDto> getPostsBySearch(String keyword);
	
	// search posts by keyword --> 2nd option
	List<PostDto> searchPostsByKeyword(String keyword);
	
	

}
