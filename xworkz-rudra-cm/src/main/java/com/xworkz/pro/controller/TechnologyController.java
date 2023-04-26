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
			"Chrome OS", "CentOS", "Debian", "Deepin");

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
		this.techservice.updateTechnology(userId, technology,model);
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

	@GetMapping("/techName")
	public String searchByTechName(Model model, @RequestParam String teName, @RequestParam String userId) {
		List<Technology> list = this.techservice.searchByTechName(teName, userId);
		model.addAttribute("list", list);
		return "viewTechnology";
	}
	@GetMapping("/techLanguage")
	public String searchByTechLanguage(Model model, @RequestParam String teLangauge, @RequestParam String userId) {
		List<Technology> list = this.techservice.searchByTechLanguage(teLangauge, userId);
		model.addAttribute("list", list);
		return "viewTechnology";
	}
	@GetMapping("/techVersion")
	public String searchByTechVersion(Model model, @RequestParam String teVersion, @RequestParam String userId) {
		List<Technology> list = this.techservice.searchByTechVersion(teVersion, userId);
		model.addAttribute("list", list);
		return "viewTechnology";
	}
	@GetMapping("/techSupportFrom")
	public String searchByTechSupportFrom(Model model, @RequestParam String teSupportFrom, @RequestParam String userId) {
		List<Technology> list = this.techservice.searchByTechSupportFrom(teSupportFrom, userId);
		model.addAttribute("list", list);
		return "viewTechnology";
	}
	@GetMapping("/techSupportTo")
	public String searchByTechSupportTo(Model model, @RequestParam String teSupportTo, @RequestParam String userId) {
		List<Technology> list = this.techservice.searchByTechSupportTo(teSupportTo, userId);
		model.addAttribute("list", list);
		return "viewTechnology";
	}
	@GetMapping("/techOwner")
	public String searchByTechOwner(Model model, @RequestParam String teOwner, @RequestParam String userId) {
		List<Technology> list = this.techservice.searchByTechOwner(teOwner, userId);
		model.addAttribute("list", list);
		return "viewTechnology";
	}
	@GetMapping("/techLicense")
	public String searchByTechLicense(Model model, @RequestParam String teLicense, @RequestParam String userId) {
		List<Technology> list = this.techservice.searchByTechLicense(teLicense, userId);
		model.addAttribute("list", list);
		return "viewTechnology";
	}
	@GetMapping("/techOpenSource")
	public String searchByTechOpenSource(Model model, @RequestParam String teOpenSource, @RequestParam String userId) {
		List<Technology> list = this.techservice.searchByTechOpenSource(teOpenSource, userId);
		model.addAttribute("list", list);
		return "viewTechnology";
	}
	@GetMapping("/techOsType")
	public String searchByTechOsType(Model model, @RequestParam String teOsType, @RequestParam String userId) {
		List<Technology> list = this.techservice.searchByTechOsType(teOsType, userId);
		model.addAttribute("list", list);
		return "viewTechnology";
	}

}
