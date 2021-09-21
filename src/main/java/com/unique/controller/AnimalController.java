package com.unique.controller;

import java.util.List;
import java.util.Optional;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.RequestPath;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unique.entity.Animal;
import com.unique.repository.AnimalRepository;

import com.unique.service.AnimalServiceImpl;
import com.unique.service.AnimalsCrudService;

@RestController
public class AnimalController {
	@Autowired
	private AnimalsCrudService service;
//	private AnimalRepository repository;	
	
//	@GetMapping("/Animals")
//	public List<Animal> findAllAnimals(){
//		return  repository.findAll();							
//	}
//	@GetMapping("/findAnimalById/{id}")
//	public ResponseEntity<Animal> findById(@PathVariable int id){
//		Optional<Animal> anyId=repository.findById(id);
//		if(anyId.isPresent()){
//			return new ResponseEntity<>(anyId.get(),HttpStatus.OK);
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}	
//	@PostMapping("/postAnimals/{animals}")
//	public List<Animal> savingAnimals(@RequestBody List<Animal> animals){
//		if(animals!=null) {
//			return repository.saveAll(animals);
//		}
//		return animals;
//	}
//	@DeleteMapping("/deleteById/{id}")
//	public String deleteById(@PathVariable int id) {
//		if(id!=0) {
//		   repository.deleteById(id);
//		   return "Deleted successfully"+id;
//		}
//		return +id+"Id not found";
//	}
	
	
//	@PostMapping("/addAnimal")
//	public Animal addAnimal(@RequestBody Animal animal) {
//		return service.saveAnimal(animal);
//	}
//
//	@PostMapping("/addAnimals")
//	public List<Animal> addAnimals(@RequestBody List<Animal> animals) {
//		return service.saveAnimals(animals);
//	}
//
//	@GetMapping("/Animals")
//	public List<Animal> findAllAnimals() {
//		return service.getAnimals();
//	}
//
//	@GetMapping("/findAnimalById/{id}")
//	public Animal findAnimalById(@PathVariable int id) {
//		return service.getAnimalById(id);
//	}
//
//	@GetMapping("/findAnimalByName/{name}")
//	public Animal findAnimalByName(@PathVariable String name) {
//		return service.getAnimalByName(name);
//	}
//
//	@PutMapping("/update")
//	public Animal updateAnimal(@RequestBody Animal animal) {
//		return service.updateAnimal(animal);
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public String deleteAnimalById(@PathVariable int id) {
//
//		return service.deleteAnimal(id);
//	}
//

//
//	@PutMapping("/updateMultipleAnimals")
//	public List<Animal> updateMultipleAnimals(@RequestBody List<Animal> animals) {
//		return service.updateAllAnimals(animals);
//	}

//   @RequestMapping(value= {"/","Animals","addAnimal","addAnimals","findAnimalById/{id}","findAnimalByName/{name}","update","delete/{id}","deleteMultiple/{animals}","updateMultipleAnimals"},method= {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.POST})
//   public void AnimalsCrud() {
//	   String method=RequestMethod.values().toString();
//	   RequestPath values=RequestPath.parse(method, method);
//	   String requestMapping= ((RequestMapping)AnimalController.class.getAnnotation(RequestMapping.class)).value()[0];
     
   
  // }
	
//	@PostMapping("/Animals/{animal}/{id}/{flag}")	
//	public Animal crudOperationsOnAnimals(@RequestBody Animal animal,@PathVariable("id") int id,@PathVariable("flag") Byte flag) {
//		return service.crudOperations(animal, id, flag);
//		
//	}
	
	@RequestMapping("/Animals/{animal}/{id}/{flag}")
	public ResponseEntity<Animal> crudOnAnimals(@RequestBody Animal animals,@PathVariable int id,@PathVariable Boolean flag){
		if(id!=0) {
		service.CrudAnimals(animals, id, flag);
		return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
			
	}
	
	@RequestMapping("/MultiAnimals/{animals}/{id}/{flag}")
	public ResponseEntity<Animal> CrudOnMultiAnimals(@RequestBody List<Animal> animals,@PathVariable int id,@PathVariable Boolean flag){
		if(id!=0) {
			service.CrudMultipleAnimals(animals, id, flag);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
			
	}
}
