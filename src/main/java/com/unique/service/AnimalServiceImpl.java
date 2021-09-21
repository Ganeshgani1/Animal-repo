package com.unique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unique.entity.Animal;
import com.unique.repository.AnimalRepository;

@Service
public class AnimalServiceImpl implements AnimalsCrudService {
	@Autowired
	private AnimalRepository repo;
//
//	public Animal saveAnimal(Animal animal) {
//		return repo.save(animal);
//	}
//
//	public List<Animal> saveAnimals(List<Animal> animals) {
//		return repo.saveAll(animals);
//	}
//
//	public Animal getAnimalById(int id) {
//		return repo.findById(id).orElse(null);
//	}
//
//	public Animal getAnimalByName(String name) {
//		return repo.findByName(name);
//	}	
//
//	public String deleteAnimal(int id) {
//		repo.deleteById(id);
//		return "The Animal was deleted" + id;
//	}
//	public String deleteMultipleAnimal(List<Animal> animals){
//		 //repo.deleteAll(animals);
//		repo.deleteAllInBatch(animals);
//		 return "Multiple items Deleted Successfully" +animals;
//	}
//
//	public Animal updateAnimal(Animal animal) {
//		Animal existingAnimal = repo.findById(animal.getId()).orElse(null);
//		existingAnimal.setName(animal.getName());
//		existingAnimal.setPetName(animal.getPetName());
//		existingAnimal.setPrice(animal.getPrice());
//		return repo.save(existingAnimal);
//	}
//	public List<Animal> updateAllAnimals(List<Animal> animals){		
//		return repo.saveAll(animals);
//	}
//
//	public List<Animal> getAnimals(){		
//		return repo.findAll();
//	}

	public Animal crudOperations(Animal animals, int id, Byte flag) {
		try {
			if (id != 0 && flag == 0) {
				if (repo.existsById(id) == true) {
					Animal exist = repo.findById(animals.getId()).orElse(null);
					exist.setName(animals.getName());
					exist.setPetName(animals.getPetName());
					exist.setHabbit(animals.getHabbit());
					exist.setPrice(animals.getPrice());
					return repo.save(exist);
				} else {
					return repo.save(animals);
				}
			} else {
				repo.deleteById(id);
			}

			return null;

		} catch (Exception ex) {
			return null;
		}
	}

//@Override
//public Animal getAnimalsId(int id) {
//	// TODO Auto-generated method stub
//	return null;
//}
//@Override
//public Animal inSert(Animal animals) {
//	// TODO Auto-generated method stub
//	return null;
//}
//@Override
//public List<Animal> getAnimals() {
//	// TODO Auto-generated method stub
//	return null;
//}
//@Override
//public void upDate(int id, Animal animal) {
//	// TODO Auto-generated method stub
//	
//}
//@Override
//public void deleteID(int id) {
//	// TODO Auto-generated method stub
//	
//}

@Override
public Animal CrudAnimals(Animal animals, int id, Boolean flag) {
	try {
		if (id != 0 && flag ==false) {
			if (repo.existsById(id) == true) {
				Animal exist = repo.findById(animals.getId()).orElse(null);
				exist.setName(animals.getName());
				exist.setPetName(animals.getPetName());
				exist.setHabbit(animals.getHabbit());
				exist.setPrice(animals.getPrice());
				return repo.save(exist);
			} else {
				return repo.save(animals);
			}
		} else {
			repo.deleteById(id);
		}

		return null;

	} catch (Exception ex) {
		return null;
	}
	 
}

@Override
public List<Animal> CrudMultipleAnimals(List<Animal> animals, Integer id, Boolean flag) {
	try {
		if(id!=0&&flag==false) {
			if(repo.existsById(id)==true) {
				return repo.saveAll(animals);
			}
			else {
				return repo.saveAll(animals);
			}
		}else {
			 repo.deleteAllInBatch(animals);
		}
	return null;
	}
	catch(Exception ex){
		return null;
	}
}


	
}
//@RequestMapping(value = "/reptime/api/orders/{repGroupID}/{orderID}/detail/save", method = RequestMethod.POST)
//@JsonView(RepGroupMaintenanceDetailView.Summary.class)
//public ResponseEntity<OrderDetail> saveOrderDetailForRepGroup(@PathVariable("repGroupID") String repGroupID,
//@PathVariable("orderID") Long orderID, @RequestBody OrderDetail orderDetail, @RequestParam String manufacturerID,
//@RequestHeader(value = "Origin", name = "Origin", required = false) String origin)
//{
//OrderDetail savedDetail = orderService.createOrUpdateOrderDetail(repGroupID, orderID, orderDetail, manufacturerID, origin);
//if (savedDetail != null)
//{
//return new ResponseEntity<>(savedDetail, HttpStatus.OK);
//} else
//{
//return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//}
//}
//@Override
//public Animal getAnimal(Animal animals) {
//	// TODO Auto-generated method stub
//	return null;
//}
//@Override
//public Animal getAnimalsId(int id) {
//	// TODO Auto-generated method stub
//	return null;
//}
