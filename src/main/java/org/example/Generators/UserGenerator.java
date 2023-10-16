package org.example.Generators;

import net.datafaker.Faker;
import org.example.User.User;

public class UserGenerator {
    public static Faker faker = new Faker();

    public static User generateUser() {
        User generatedUser = new User();
        generatedUser.setId(faker.number().numberBetween(0, 99));
        generatedUser.setUsername(faker.name().name());
        generatedUser.setFirstName(faker.name().firstName());
        generatedUser.setLastName(faker.name().firstName());
        generatedUser.setEmail(faker.internet().emailAddress());
        generatedUser.setPassword(faker.internet().password());
        generatedUser.setPhone(faker.phoneNumber().phoneNumber());
        generatedUser.setUserStatus(1);
        return generatedUser;
    }
}
