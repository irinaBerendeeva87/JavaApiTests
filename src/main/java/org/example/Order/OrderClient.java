package org.example.Order;

import io.restassured.response.ValidatableResponse;
import org.example.Client;

import static io.restassured.RestAssured.given;

public class OrderClient extends Client {

    private static final String PATH_ORDER = "/store/order/";

    public ValidatableResponse createOrder(Order order) {
        return given()
                .spec(getSpec())
                .body(order)
                .when()
                .post(PATH_ORDER)
                .then();
    }

    public ValidatableResponse deleteOrderByID(int orderId) {
        return given()
                .spec(getSpec())
                .body(orderId)
                .when()
                .delete(PATH_ORDER + orderId)
                .then();
    }

    public ValidatableResponse findOrderByID(int orderId) {
        return given()
                .spec(getSpec())
                .body(orderId)
                .when()
                .get(PATH_ORDER + orderId)
                .then();
    }

}
