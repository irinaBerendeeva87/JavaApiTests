package org.example;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Client {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    protected RequestSpecification getSpec(){
        return new RequestSpecBuilder()
                    .setContentType(ContentType.JSON)
                    .setBaseUri(BASE_URL)
                    .build();
        }
    }
