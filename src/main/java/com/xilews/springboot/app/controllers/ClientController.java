package com.xilews.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

import javax.validation.Valid;

import com.xilews.springboot.app.models.dao.IClientDao;
import com.xilews.springboot.app.models.entity.Client;

@Controller
@SessionAttributes("client")
@RequestMapping({ "/client", "/clients" })
public class ClientController {

	@Autowired
	private IClientDao clientDao;

	@GetMapping("/list")
	public String showClients(Model model) {

		model.addAttribute("title", "List of Clients");
		model.addAttribute("clients", clientDao.findAll());

		return "client/list";
	}

	@GetMapping("/create")
	public String showForm(Map<String, Object> model) { // Example using "Map" instead of "Model"

		Client client = new Client();

		model.put("client", client);
		model.put("title", "Insert a new client");
		model.put("buttonTitle", "Save Client");

		return "client/form";
	}

	@PostMapping("/form")
	public String save(@Valid Client client, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("title", "Insert a new client");
			model.addAttribute("buttonTitle", "Save Client");
			return "client/form";
		}

		clientDao.save(client);
		status.setComplete();
		return "redirect:/clients/list";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {

		Client client = clientDao.findOne(id);

		if (client == null) {
			return "redirect:/clients/list";
		}

		model.addAttribute("client", client);
		model.addAttribute("title", "Edit " + client.getFirstName());
		model.addAttribute("buttonTitle", "Update Client");
		return "client/form";
	}

	@GetMapping("/profile/{id}")
	public String singleClient(@PathVariable Long id, Model model) {

		Client client = null;
		String fullName;

		client = clientDao.findOne(id);

		if (client == null) {
			return "redirect:/clients/list";
		} 

		fullName = client.getFirstName() + " " + client.getLastName();
		model.addAttribute("client", client);
		model.addAttribute("title", fullName);

		return "client/single";

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {

		if (id > 0) {
			clientDao.deleteOne(id);
		}

		return "redirect:/clients/list";
	}

}
