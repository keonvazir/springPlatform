package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/search/topTen")
	public String topTen() {
		return "topten.jsp";
	}
	@RequestMapping("/songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Lookify song = lookifyService.findSong(id);
		model.addAttribute("song", song);
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
	
	
	@PostMapping("/search")
	public String artistName(Model model, @RequestParam(value="artist") String artist) {
		
	}
	
	@RequestMapping("/search")
	public String searchName(@RequestParam("artist") String artist, Model model) {
		List<Lookify> artistSongs = lookifyService.findByArtist(artist);
		model.addAttribute("artistSongs", artistSongs);
		return "/artist.jsp";
	}
	@Controller
    public class SongsController {
        // other methods removed for brevity
        @RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
        public String destroy(@PathVariable("id") Long id) {
            lookifyService.deleteSong(id);
            return "redirect:/dashboard";
        }
    }
	
}
