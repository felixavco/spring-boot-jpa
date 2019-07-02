package com.xilews.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.validation.Valid;

import com.xilews.springboot.app.models.entity.Client;
import com.xilews.springboot.app.models.service.IClientService;
import com.xilews.springboot.app.util.paginator.PageRender;

@Controller
@SessionAttributes("client")
@RequestMapping({ "/client", "/clients" })
public class ClientController {

	@Autowired
	private IClientService clientService;

	@GetMapping("/list")
	public String showClients(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		//* Creating "Pegeable" Object 
		Pageable pageRequest = PageRequest.of(page, 5);

		Page<Client> clients = clientService.findAll(pageRequest);
		
		PageRender<Client> pageRender = new PageRender<>("/clients/list", clients);

		model.addAttribute("title", "List of Clients");
		model.addAttribute("clients", clients);
		model.addAttribute("page", pageRender);

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
	public String save(
		@Valid Client client, 
		BindingResult result, 
		Model model, 
		@RequestParam("file") MultipartFile photo, 
		RedirectAttributes flash, 
		SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("title", "Insert a new client");
			model.addAttribute("buttonTitle", "Save Client");
			return "client/form";
		}

		System.out.println(photo);
		
		if(!photo.isEmpty()) {
			Path uploadsDirectory = Paths.get("src//main//resources//static/uploads");
			String rootPath = uploadsDirectory.toFile().getAbsolutePath();

			try {
				byte[] bytes = photo.getBytes();
				Path fullPath = Paths.get(rootPath + "//" + photo.getOriginalFilename());
				//* Writes the new file in the uploadsDirectory
				Files.write(fullPath, bytes);
								
				flash.addFlashAttribute("info", "file '" + photo.getOriginalFilename() + "' uploaded successfully!");

				client.setPhoto(photo.getOriginalFilename());

			} catch(IOException e) {
				e.printStackTrace();
			}
		}

		String flashMessage = (client.getId() != null) ? "Client Updated" : "Client successfully saved";

		clientService.save(client);
		status.setComplete();
		flash.addFlashAttribute("success", flashMessage);
		return "redirect:/clients/list";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model, RedirectAttributes flash) {

		Client client = clientService.findOne(id);

		if (client == null) {
			flash.addFlashAttribute("danger", "Client id: " + id + " not found");
			return "redirect:/clients/list";
		}

		model.addAttribute("client", client);
		model.addAttribute("title", "Edit " + client.getFirstName());
		model.addAttribute("buttonTitle", "Update Client");
		return "client/form";
	}

	@GetMapping("/profile/{id}")
	public String singleClient(@PathVariable Long id, Model model, RedirectAttributes flash) {

		Client client = null;
		String fullName;

		client = clientService.findOne(id);

		if (client == null) {
			flash.addFlashAttribute("danger", "Client id: " + id + " not found");
			return "redirect:/clients/list";
		} 

		fullName = client.getFirstName() + " " + client.getLastName();
		model.addAttribute("client", client);
		model.addAttribute("title", fullName);

		return "client/single";

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes flash) {

		if (id > 0) {
			clientService.deleteOne(id);
		}

		flash.addFlashAttribute("success", "Client deleted");
		return "redirect:/clients/list";
	}

}
