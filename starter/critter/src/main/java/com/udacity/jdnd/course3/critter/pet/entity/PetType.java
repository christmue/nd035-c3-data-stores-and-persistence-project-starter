package com.udacity.jdnd.course3.critter.pet.entity;

/**
 * A example list of pet type metadata that could be included on a request to create a pet.
 * Adjusted based on this article to persist enum: https://www.baeldung.com/jpa-persisting-enums-in-jpa
 */

public enum PetType {
    CAT("C"), DOG("D"), LIZARD("L"), BIRD("B"), FISH("F"), SNAKE("S"), OTHER("O");

    private String code;

    private PetType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
