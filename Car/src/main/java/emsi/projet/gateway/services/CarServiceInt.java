package emsi.projet.gateway.services;

import java.util.List;

import emsi.projet.gateway.models.CarResponse;

public interface CarServiceInt {
	
	List<CarResponse> findAll();
    CarResponse findById(Long id) throws Exception;
    void save(CarResponse car);
    void delete(Long id) throws Exception;

    void update(CarResponse carResponse, Long id) throws Exception;

}
