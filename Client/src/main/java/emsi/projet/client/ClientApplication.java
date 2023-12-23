package emsi.projet.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import emsi.projet.client.entities.Client;
import emsi.projet.client.repositories.ClientRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
		
	}
	@Bean
	CommandLineRunner intializeH2Database(ClientRepository clientRepository) {
		return args -> {
			clientRepository.save(new Client(Long.parseLong("1"), "Amine Safi", Float.parseFloat("23")));
			clientRepository.save(new Client(Long.parseLong("2"), "Amal Alaoui", Float.parseFloat("22")));
			clientRepository.save(new Client(Long.parseLong("3"), "Samir Rami", Float.parseFloat("22")));
		};
	}

}
