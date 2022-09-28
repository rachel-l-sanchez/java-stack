package com.rachelsanchez.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rachelsanchez.lookify.models.Lookify;
import com.rachelsanchez.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	@RequestMapping("/")
	public String index(@ModelAttribute("song") Lookify song) {
		return "index.jsp";
	}
	
	public LookifyController() {
		
	}
	
	@RequestMapping("/look/all")
	public String addSong(@ModelAttribute("song") Lookify song, Model model) {
			List<Lookify> newSong = lookifyService.allSongs();
			model.addAttribute("songs", newSong);
			return "read.jsp";
	}
	
	@PostMapping("/create/song")
	public String processTravel(@ModelAttribute("song") Lookify song, Model model, BindingResult result) {
		
		if (result.hasErrors()) {
			return "create.jsp";
		}
		else {
			model.addAttribute("song", lookifyService.createSong(song));
			return "redirect:/all/songs";
		}
	}

	
	@DeleteMapping("/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		lookifyService.destroy(id);
		return "redirect:/all/songs";
	}
	
	public LookifyService getLookifyService() {
		return lookifyService;
	}
	public void setLookifyService(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	@GetMapping("/one/{id}/song")
	public String getOneSong(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", lookifyService.findSong(id));
		return "oneSong.jsp";
	}
	
	@GetMapping("/{artist}")
	public String getSongsByArtist(@PathVariable("artist") Lookify artist, Model model) {
		model.addAttribute("songs", ((LookifyService) lookifyService).findSongsByArtist(artist));
		return "oneSong.jsp";
	}
	
	@GetMapping("top/songs")
	public String topSongs(@ModelAttribute("rating") Long rating, Model model) {
		Long topRatings = (Long) rating;
		if (topRatings <11) {
			model.addAttribute("song", lookifyService.findSong(rating));
		} else {
			return "redirect:/look/all";
		}
		return "topSongs.jsp";
	}
}

