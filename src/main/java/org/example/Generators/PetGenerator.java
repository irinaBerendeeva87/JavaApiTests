package org.example.Generators;

import net.datafaker.Faker;
import org.example.Pet.Category;
import org.example.Pet.Pet;
import org.example.Pet.PetStatus;
import org.example.Pet.Tag;

import java.util.ArrayList;

public class PetGenerator {
    public static Faker faker = new Faker();

    public static Pet generatePetWithId(int id) {
        Tag tag = TagGenerator.generateTagWithId(faker.number().numberBetween(0, 99));
        Category category = CategoryGenerator.generateCategoryWithId(faker.number().numberBetween(0, 99));
        Pet generatedPet = new Pet();
        generatedPet.setId(id);
        generatedPet.setCategory(category);
        generatedPet.setName(faker.name().name());
        generatedPet.setPhotoUrls(new ArrayList<>());
        generatedPet.setTags(new ArrayList<Tag>() {{
            add(tag);
        }});
        generatedPet.setStatus(PetStatus.AVAILABLE);
        return generatedPet;
    }
}

