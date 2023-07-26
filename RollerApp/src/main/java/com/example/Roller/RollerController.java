package com.example.Roller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RollerController {
	private List<Roller> rollerList = new ArrayList<>();

	public List<Roller> getRollerList() {
		return rollerList;
	}


	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("rollerList", rollerList);
		return "index";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("roller", new Roller());
		return "add";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Roller roller) {
		rollerList.add(roller);
		System.out.println(rollerList.size());
		return "redirect:/";
	}
}
