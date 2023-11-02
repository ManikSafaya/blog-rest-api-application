package com.manik.apis.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manik.apis.entities.Comment;
import com.manik.apis.entities.Post;
import com.manik.apis.exceptions.ResourceNotFoundException;
import com.manik.apis.payloads.CommentDto;
import com.manik.apis.repositories.CommentRepo;
import com.manik.apis.repositories.PostRepo;
import com.manik.apis.services.CommentService;


@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
    private CommentRepo commentRepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","postId",postId));
		 Comment comment = this.modelMapper.map(commentDto, Comment.class);
		 comment.setPost(post);
		 Comment savedComment = this.commentRepo.save(comment);
		 return this.modelMapper.map(savedComment, CommentDto.class);
	     
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId).
				orElseThrow(()->new ResourceNotFoundException("Comment", "commentId", commentId));
		this.commentRepo.delete(comment);
		

	}

}
