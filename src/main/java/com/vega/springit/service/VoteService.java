package com.vega.springit.service;

import org.springframework.stereotype.Service;

import com.vega.springit.domain.Vote;
import com.vega.springit.repository.VoteRepository;

@Service
public class VoteService {
	
	private final VoteRepository voteRepository;

	public VoteService(VoteRepository voteRepository) {
		this.voteRepository = voteRepository;
	}
	
	public Vote save(Vote vote) {
		return voteRepository.save(vote);
	}
}
