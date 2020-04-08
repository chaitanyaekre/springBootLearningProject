package com.vega.springit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vega.springit.domain.Link;
import com.vega.springit.repository.LinkRepository;

@RestController
@RequestMapping("/links")
public class LinkController {

	private LinkRepository linkRepository;
	
	public LinkController(LinkRepository linkRepository) {
		this.linkRepository = linkRepository;
	}
	
	
	//List
	
	@GetMapping("/")
	private List<Link>	getLinks(){
		return linkRepository.findAll();
	}
	
	//CRUD
	
	@PostMapping("/create")
	private Link create(@ModelAttribute Link link) {
		return linkRepository.save(link);
	}
	
	@GetMapping("/{id}")
	private Optional<Link> read(@PathVariable Long id) {
		return linkRepository.findById(id);
	}
	
	@PutMapping("/{id}")
	private Link update(@PathVariable Long id) {
		return null;
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable Long id) {
		linkRepository.deleteById(id);
	}
}
