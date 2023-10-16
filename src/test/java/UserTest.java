import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.Generators.UserGenerator;
import org.example.User.User;
import org.example.User.UserClient;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;
    private UserClient userClient;

    @Before
    public void setUp() {
        userClient = new UserClient();
        user = UserGenerator.generateUser();
    }

    @DisplayName("Create user")
    @Test
    public void userCanBeCreated() {
        ValidatableResponse responseCreate = userClient.createUser(user);
        int statusCode = responseCreate.extract().statusCode();
        assertEquals("Status Code incorrect!", SC_OK, statusCode);

    }

    @DisplayName("Delete user")
    @Test
    public void userCanBeDeleted() {
        userClient.createUser(user);
        String userName = user.getUsername();
        ValidatableResponse responseDelete = userClient.deleteUser(userName);
        int statusCode = responseDelete.extract().statusCode();
        String message = responseDelete.extract().path("message");
        assertEquals("User" + userName + "was found", SC_OK, statusCode);
        assertEquals("User  found", userName, message);
    }

}
