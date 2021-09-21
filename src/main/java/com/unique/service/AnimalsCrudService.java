package com.unique.service;

import java.util.List;

import com.unique.entity.Animal;

public interface AnimalsCrudService {
 
//	public Animal inSert(Animal animals);
//	public Animal getAnimalsId(int id);
//	List<Animal> getAnimals();
//	void upDate(int id,Animal animal);
//	void deleteID(int id);
	 Animal CrudAnimals(Animal animals, int id, Boolean flag);
	 List<Animal> CrudMultipleAnimals(List<Animal> animals,Integer id,Boolean flag);
}
