package com.vega.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vega.springit.domain.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
