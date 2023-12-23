package emsi.projet.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import emsi.projet.car.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
