import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.Generators.OrderGenerator;
import org.example.Order.Order;
import org.example.Order.OrderClient;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;

public class OrderTest {
    private Order order;
    private OrderClient orderClient;

    @Before
    public void setUp() {
        orderClient = new OrderClient();
        order = OrderGenerator.generateNewOrder();

    }

    @DisplayName("Create order")
    @Test
    public void orderCanBePlaced(){
        ValidatableResponse responseOrder = orderClient.createOrder(order);
        int orderIdAfter = responseOrder.extract().path("id");
        int statusCode = responseOrder.extract().statusCode();
        assertEquals("Status Code incorrect!",SC_OK, statusCode);
        assertEquals(order.getId(), orderIdAfter);

    }

    @DisplayName("Delete order")
    @Test
    public void orderCanBeDeleted(){
        ValidatableResponse responseOrder = orderClient.createOrder(order);
        int orderId = responseOrder.extract().path("id");
        ValidatableResponse deleteOrder = orderClient.deleteOrderByID(orderId);
        int statusCode = deleteOrder.extract().statusCode();
        int responseCode = deleteOrder.extract().path("code");
        assertEquals("Status Code incorrect!",SC_OK, statusCode);
        assertEquals("Code in response incorrect!",200, responseCode);

    }

    @DisplayName("Find order by ID")
    @Test
    public void orderCanBeFindById(){
        ValidatableResponse responseOrder = orderClient.createOrder(order);
        int petId = responseOrder.extract().path("petId");
        int orderId = responseOrder.extract().path("id");
        ValidatableResponse findCreatedOrder= orderClient.findOrderByID(orderId);
        int statusCode = findCreatedOrder.extract().statusCode();
        int responsePetID = findCreatedOrder.extract().path("petId" );
        assertEquals("Status Code incorrect!",SC_OK, statusCode);
        assertEquals("PetID incorrect!",petId, responsePetID);

    }
}
