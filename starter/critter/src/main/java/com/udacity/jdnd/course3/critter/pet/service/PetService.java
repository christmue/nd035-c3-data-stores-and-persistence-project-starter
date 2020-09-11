package com.udacity.jdnd.course3.critter.pet.service;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.repository.PetRepository;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import com.udacity.jdnd.course3.critter.user.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PetService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    CustomerRepository customerRepository;

    public Pet savePet(Pet pet) {
        Pet returnedPet = petRepository.save(pet);
        Customer customer = returnedPet.getCustomer();

        customer.addPet(returnedPet);
        customerRepository.save(customer);

        return returnedPet;
    }

    public Pet getPet(Long id) {
        return petRepository.getOne(id);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> getPetsByOwner(Customer customer) {
        return petRepository.findAllByOwner(customer);
    }
}
