package com.vega.springit.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vega.springit.domain.Link;
import com.vega.springit.repository.LinkRepository;

@Controller
public class LinkController {

	private static final Logger logger = LoggerFactory.getLogger(LinkController.class);
	private LinkRepository linkRepository;
	
	public LinkController(LinkRepository linkRepository) {
		this.linkRepository = linkRepository;
	}
	
	
	//List
	
//	@GetMapping("/")
//	private List<Link>	getLinks(){
//		return linkRepository.findAll();
//	}
	
	@GetMapping("/")
	public String list(Model model) {
		
		System.out.println(linkRepository.findAll().size());
		model.addAttribute("links", linkRepository.findAll());
		return "link/list";
	}
	
	
	//CRUD
	
	@PostMapping("/create")
	private Link create(@ModelAttribute Link link) {
		return linkRepository.save(link);
	}
	
	@GetMapping("/link/{id}")
	private String read(@PathVariable Long id, Model model) {
		 Optional<Link> link = linkRepository.findById(id);
		 
		 if(link.isPresent()) {
			 model.addAttribute("link", link.get());
			 model.addAttribute("success", model.containsAttribute("success"));
			 return "link/view";
		 }
		 else{
			 return "redirect:/";
		 }
	}
	
	@PutMapping("/{id}")
	private Link update(@PathVariable Long id) {
		return null;
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable Long id) {
		linkRepository.deleteById(id);
	}
	
	@GetMapping("/link/submit")
    public String newLinkForm(Model model) {
        model.addAttribute("link",new Link());
        return "link/submit";
    }

    @PostMapping("/link/submit")
    public String createLink(@Valid Link link, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        
    	if(bindingResult.hasErrors()) {
    		logger.info("Validation error were found while submitting link.");
    		model.addAttribute("link", link);
    		return "link/submit";
    	}else {
    		
    		linkRepository.save(link);
    		logger.info("Link saved successfully.");
    		redirectAttributes.addAttribute("id",link.getId())
    		.addFlashAttribute("success", true);
    		
    		return "redirect:/link/{id}";
    	}
    }
}
