import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.Generators.PetGenerator;
import org.example.Pet.Pet;
import org.example.Pet.PetClient;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.example.Generators.PetGenerator.faker;
import static org.junit.Assert.assertEquals;

public class PetTest {
    private Pet pet;
    private PetClient petClient;
    private int id;
    private int petId;

    @Before
    public void setUp() {
        petClient = new PetClient();
        id = faker.number().numberBetween(0,99);
        pet = PetGenerator.generatePetWithId(id);
    }

    @DisplayName("Add new pet")
    @Test
    public void newPetCanBeAdded(){
        ValidatableResponse responseCreate = petClient.addPet(pet);
        int statusCode = responseCreate.extract().statusCode();
        int newID = responseCreate.extract().path("id");
        assertEquals("Status Code incorrect!",SC_OK, statusCode);
        assertEquals("ID don't equal",newID,id);

    }

    @DisplayName("Find pet by ID")
    @Test
    public void petCanBeFindByPetId(){
        ValidatableResponse responseFindPetInStore = petClient.findPetById(petId);
        int statusCode = responseFindPetInStore.extract().statusCode();
        String responseMessage = responseFindPetInStore.extract().path("message");
        assertEquals( "Pet was found ","Pet not found", responseMessage);
        assertEquals("Pet was found",SC_NOT_FOUND, statusCode);
    }

    @DisplayName("Delete pet by ID")
    @Test
    public void petCanBeDeletedById(){
        petClient.addPet(pet);
        petId = pet.getId();
        petClient.findPetById(petId);
        ValidatableResponse responseDelete = petClient.deletePetFromTheStoreById(petId);
        petClient.findPetById(petId);
        int statusCode = responseDelete.extract().statusCode();
        int responseCode = responseDelete.extract().path("code");
        assertEquals("Pet was found",SC_OK, statusCode);
        assertEquals("Pet was found",200, responseCode);

    }
}
