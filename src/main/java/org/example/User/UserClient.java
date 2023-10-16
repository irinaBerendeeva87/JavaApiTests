package org.example.User;

import io.restassured.response.ValidatableResponse;
import org.example.Client;

import static io.restassured.RestAssured.given;

public class UserClient extends Client {
    private static final String PATH ="/user/";

    public ValidatableResponse createUser(User user){
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(PATH)
                .then();
    }

    public ValidatableResponse deleteUser(String userName){
        return given()
                .spec(getSpec())
                .body(userName)
                .when()
                .delete(PATH +userName)
                .then();
    }
}
