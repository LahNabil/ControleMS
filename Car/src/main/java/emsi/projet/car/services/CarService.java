package emsi.projet.car.services;

import java.util.List;

import emsi.projet.car.models.CarResponse;

public interface CarService {
	
	List<CarResponse> findAll();
    CarResponse findById(Long id) throws Exception;
    void save(CarResponse car);
    void delete(Long id) throws Exception;

    void update(CarResponse carResponse, Long id) throws Exception;

}
