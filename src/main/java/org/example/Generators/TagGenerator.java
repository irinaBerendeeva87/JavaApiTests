package org.example.Generators;

import net.datafaker.Faker;
import org.example.Pet.Tag;

public class TagGenerator {
    public static Faker faker = new Faker();

    public static Tag generateTagWithId(int id) {
        Tag generated = new Tag();
        generated.setId(id);
        generated.setName(faker.name().name());
        return generated;
    }
}
