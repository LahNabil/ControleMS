package emsi.projet.gateway.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emsi.projet.gateway.models.CarResponse;
import emsi.projet.gateway.services.CarService;


@RestController
@RequestMapping("api/car")
public class CarController {

	@Autowired
    private CarService carService;
	
	
    @GetMapping
    public List<CarResponse> findAll(){
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public CarResponse findById(@PathVariable Long id) throws Exception {return carService.findById(id);}

    @PostMapping
    public void add(@RequestBody CarResponse car){carService.save(car);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {carService.delete(id);}

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody CarResponse carResponse) throws Exception {carService.update(carResponse,id);}
}
