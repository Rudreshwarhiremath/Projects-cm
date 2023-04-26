package com.xworkz.pro.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.pro.entity.Technology;
import com.xworkz.pro.service.Techservice;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class TechnologyController {

	@Autowired
	private Techservice techservice;

	private List<String> list = Arrays.asList("MS-Windows", "Ubuntu", "Mac OS", "Fedora", "Solaris", "Free BSD",
			"Chrome OS", "CentOS", "Debian", "Deepin", "Linux");

	public TechnologyController() {
		log.info("Running in technology controller");
	}

	@GetMapping("/addTechnology")
	public String addTech(Model model) {
		model.addAttribute("type", list);
		return "add";
	}

	@PostMapping("/addTechnology")
	public String addList(String userId, Technology technology, Model model) {
		this.techservice.updateTechnology(userId, technology, model);
		model.addAttribute("type", list);
		model.addAttribute("techmsg", "Technology added sucessfully");
		model.addAttribute("tech", technology);
		return "add";
	}

	@GetMapping("/view")
	public String viewTechnology(@RequestParam String userId, Model model) {
		List<Technology> list = this.techservice.technology(userId);
		model.addAttribute("list", list);
		return "viewTechnology";
	}

	@GetMapping("/searchTechnology")
	public String searchTechnology(Model model, @RequestParam String userId, @RequestParam String teName,
			@RequestParam String teLangauge, @RequestParam String teVersion, @RequestParam String teSupportFrom,
			@RequestParam String teSupportTo, @RequestParam String teOwner, @RequestParam String teLicense,
			@RequestParam String teOpenSource, @RequestParam String teOsType) {
		List<Technology> list = this.techservice.searchTechnology(userId, teName, teLangauge, teVersion, teOwner,
				teSupportFrom, teSupportTo, teLicense, teOpenSource, teOsType);
		model.addAttribute("list", list);
		return "viewTechnology";
	}
}
