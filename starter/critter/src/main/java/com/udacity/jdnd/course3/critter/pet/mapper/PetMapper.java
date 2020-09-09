package com.udacity.jdnd.course3.critter.pet.mapper;

import com.udacity.jdnd.course3.critter.pet.dto.PetDTO;
import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetMapper {

    public Pet DTOToEntity(PetDTO petDTO) {
        Pet petEntity = new Pet();
        petEntity.setId(petDTO.getId());
        petEntity.setName(petDTO.getName());
        petEntity.setNotes(petDTO.getNotes());
        petEntity.setBirthDate(petDTO.getBirthDate());
        petEntity.setPetType(petDTO.getType());
        return petEntity;
    }

    public PetDTO EntityToDTO(Pet petEntity) {
        PetDTO petDTO = new PetDTO();
        petDTO.setId(petEntity.getId());
        petDTO.setName(petEntity.getName());
        petDTO.setNotes(petEntity.getNotes());
        petDTO.setBirthDate(petEntity.getBirthDate());
        petDTO.setType(petEntity.getPetType());
        if (petEntity.getCustomer() != null) {
            petDTO.setOwnerId(petEntity.getCustomer().getId());
        }
        return petDTO;
    }

    public List<PetDTO> EntitiesToDTOs(List<Pet> petEntities) {
        return petEntities.stream()
                .map(this::EntityToDTO)
                .collect(Collectors.toList());
    }
}
