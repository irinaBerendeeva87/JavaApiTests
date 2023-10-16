package org.example.Pet;

import io.restassured.response.ValidatableResponse;
import org.example.Client;

import static io.restassured.RestAssured.given;


public class PetClient extends Client {

    private static final String PATH = "/pet/";

    public ValidatableResponse addPet(Pet pet) {
        return given()
                .spec(getSpec())
                .body(pet)
                .when()
                .post(PATH)
                .then();
    }

    public ValidatableResponse deletePetFromTheStoreById(int petId) {
        return given()
                .spec(getSpec())//настраивает запрос который будет исполнен
                .body(petId)
                .when()
                .delete(PATH + petId)
                .then();
    }

    public ValidatableResponse findPetById(int petId) {
        return given()
                .spec(getSpec())
                .body(petId)
                .when()
                .get(PATH + petId)
                .then();
    }
}
