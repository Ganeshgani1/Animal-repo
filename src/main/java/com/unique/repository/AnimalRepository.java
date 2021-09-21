package com.unique.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unique.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal,Integer> {

	//Animal findByName(String name);
	

}
