package emsi.projet.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import emsi.projet.client.entities.Client;
import emsi.projet.client.repositories.ClientRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
		
	}
	CommandLineRunner initialiserBaseH2(ClientRepository clientRepository) {
        return args -> {
        	clientRepository.save(new Client(Long.parseLong("1"), "Rabab", "SELIMANI", Float.parseFloat("23")));
        	clientRepository.save(new Client(Long.parseLong("2"), "Anas", "Maataoui", Float.parseFloat("22")));
        	clientRepository.save(new Client(Long.parseLong("3"), "mikel", "busa", Float.parseFloat("22")));

        };
	}

}
