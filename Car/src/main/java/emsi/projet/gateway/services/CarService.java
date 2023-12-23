package emsi.projet.gateway.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import emsi.projet.gateway.entities.Car;
import emsi.projet.gateway.entities.Client;
import emsi.projet.gateway.models.CarResponse;
import emsi.projet.gateway.repositories.CarRepository;


@Service
public class CarService implements CarServiceInt {
	
		@Autowired
	    private CarRepository carRepository;
	    @Autowired
	    private RestTemplate restTemplate;
	    
	    private final String URL="http://localhost:8888/SERVICE-CLIENT";
	    @Override
	    public List<CarResponse> findAll() {
	        List<Car> cars = carRepository.findAll();
	        Client[] clients = restTemplate.getForObject(URL+"/api/client", Client[].class);
	        return cars.stream().map(car -> mapToCarResponse(car, clients)).toList();
	    }

	    private CarResponse mapToCarResponse(Car car, Client[] clients) {
	        Client foundClient = Arrays.stream(clients)
	                .filter(client -> client.getId() == car.getClient_id())
	                .findFirst()
	                .orElse(null);

	        return CarResponse.builder()
	                .id(car.getId())
	                .brand(car.getBrand())
	                .client(foundClient)
	                .matricule(car.getMatricule())
	                .model(car.getModel())
	                .build();
	    }

	    @Override
	    public CarResponse findById(Long id) throws Exception {
	        Car car= carRepository.findById(id).orElseThrow(()->new Exception("Invalid Car Id"));
	        Client client = restTemplate.getForObject(this.URL+"/api/client/"+car.getClient_id(),Client.class);
	        return CarResponse.builder()
	                .id(car.getId())
	                .brand(car.getBrand())
	                .client(client)
	                .matricule(car.getMatricule())
	                .model(car.getModel())
	                .build();
	    }

	    @Override
	    public void save(CarResponse car) {
	        Car car1 = new Car();
	        car1.setClient_id(car.getClient().getId());
	        car1.setModel(car.getModel());
	        car1.setBrand(car.getBrand());
	        car1.setMatricule(car.getMatricule());

	        carRepository.save(car1);
	    }

	    @Override
	    public void delete(Long id) throws Exception {
	        Car car = carRepository.findById(id).orElseThrow(()->new Exception("Invalid Id"));
	        carRepository.delete(car);
	    }

	    @Override
	    public void update(CarResponse carResponse, Long id) throws Exception {
	        Car car = carRepository.findById(id).orElseThrow(()->new Exception("Invalid ID"));
	        car.setClient_id(carResponse.getClient().getId());
	        car.setModel(carResponse.getModel());
	        car.setBrand(carResponse.getBrand());
	        car.setMatricule(carResponse.getMatricule());

	        carRepository.save(car);
	    }

}
