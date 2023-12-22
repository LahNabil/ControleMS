package emsi.projet.client.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import emsi.projet.client.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	

}
