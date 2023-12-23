package emsi.projet.gateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import emsi.projet.gateway.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
