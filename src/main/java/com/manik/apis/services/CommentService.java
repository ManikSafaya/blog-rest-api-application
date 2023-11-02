package com.manik.apis.services;

import com.manik.apis.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto,Integer postId);
	void deleteComment(Integer commentId);

}
