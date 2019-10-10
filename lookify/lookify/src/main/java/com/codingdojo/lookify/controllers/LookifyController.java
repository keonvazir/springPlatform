package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.services.LookifyService;



@Controller
public class LookifyController {
	private final LookifyService lookifyService;
	  
	  public LookifyController(LookifyService lookifyService) {
	      this.lookifyService = lookifyService;
	  }
	@RequestMapping("/")
	public String home() {
		return "/index.jsp";
	}
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Lookify> songs = lookifyService.allSongs();
		model.addAttribute("songs", songs);
		model.addAttribute("song", new Lookify());
		return "dashboard.jsp";
	}
	@RequestMapping("/search/{name}")
	public String searchName(@PathVariable("name") String name) {
		return "/artist.jsp";
	}
	@RequestMapping("/search/topTen")
	public String topTen() {
		return "topten.jsp";
	}
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id) {
		return "/show.jsp";
	}
	@RequestMapping("/songs/new")
	public String addSong(Model model) {
		List<Lookify> songs = lookifyService.allSongs();
		model.addAttribute("songs", songs);
		model.addAttribute("song", new Lookify());
		return "/new.jsp";
	}
	@RequestMapping(value="/dashboard", method=RequestMethod.POST)
	public String createSong(@Valid @ModelAttribute("song") Lookify song, BindingResult result) {
		if (result.hasErrors()) {
			return "/new.jsp";
		}
		else {
			lookifyService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
}
