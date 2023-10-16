package org.example.Generators;

import net.datafaker.Faker;
import org.example.Pet.Category;

public class CategoryGenerator {
    public static Faker faker = new Faker();

    public static Category generateCategoryWithId(int id) {
        Category generated = new Category();
        generated.setId(id);
        generated.setName(faker.name().name());
        return generated;
    }
}
