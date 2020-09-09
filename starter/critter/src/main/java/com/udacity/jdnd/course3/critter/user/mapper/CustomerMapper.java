package com.udacity.jdnd.course3.critter.user.mapper;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.user.dto.CustomerDTO;
import com.udacity.jdnd.course3.critter.user.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Customer DTOToEntity(CustomerDTO customerDTO) {
        Customer customerEntity = new Customer();
        customerEntity.setId(customerDTO.getId());
        customerEntity.setName(customerDTO.getName());
        customerEntity.setNotes(customerDTO.getNotes());
        customerEntity.setPhoneNumber(customerDTO.getPhoneNumber());
        return customerEntity;
    }

    public CustomerDTO entityToDTO(Customer customerEntity) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customerEntity.getId());
        customerDTO.setName(customerEntity.getName());
        customerDTO.setNotes(customerEntity.getNotes());
        customerDTO.setPhoneNumber(customerEntity.getPhoneNumber());
        customerDTO.setPetIds(getIds(customerEntity.getPets()));
        return customerDTO;
    }

    public List<CustomerDTO> entitiesToDTOs(List<Customer> customerEntities) {
        return customerEntities
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    private List<Long> getIds(List<Pet> customerPets) {
        return customerPets
                .stream()
                .map(Pet::getId)
                .collect(Collectors.toList());
    }

}
