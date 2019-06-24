package com.xilews.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import com.xilews.springboot.app.models.dao.IClientDao;
import com.xilews.springboot.app.models.entity.Client;

@Controller
@RequestMapping({"/client", "/clients"})
public class ClientController {
	
	@Autowired
	private IClientDao clientDao;
	
	@GetMapping("/list")
	public String showClients(Model model) {
		
		model.addAttribute("title", "List of Clients");
		model.addAttribute("clients", clientDao.findAll());
		
		return "client/list";
	}

	@GetMapping("/form")
	public String showForm(Map<String, Object> model) { //Example using "Map" instead of "Model"

		Client client = new Client();


		model.put("client", client);
		model.put("title", "Insert a new client");

		return "client/form";
	}

	@PostMapping("/form")
	public String save(Client client) { 

		 clientDao.save(client);

		 return "redirect:/clients/list";
	}

}
