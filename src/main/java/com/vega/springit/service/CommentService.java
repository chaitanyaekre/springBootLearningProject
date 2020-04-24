package com.vega.springit.service;

import org.springframework.stereotype.Service;

import com.vega.springit.domain.Comment;
import com.vega.springit.repository.CommentRepository;

@Service
public class CommentService {
	
	private final CommentRepository commentRepository;

	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}
	
}
