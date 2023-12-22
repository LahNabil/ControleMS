package emsi.projet.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import emsi.projet.client.entities.Client;
import emsi.projet.client.repositories.ClientRepository;

@RestController
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/clients")
	public List findAll() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/client/{id}")
	public Client findById(@PathVariable Long id) throws Exception{
		
		return this.clientRepository.findById(id).orElseThrow(()-> new Exception("Invalid id"));
	}

}
