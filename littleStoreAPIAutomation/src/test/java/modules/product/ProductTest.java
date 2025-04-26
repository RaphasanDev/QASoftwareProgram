package modules.product;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataFactory.ProductDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.Component;
import pojo.Product;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Product modules API Rest tests")
public class ProductTest {
    private String token;

    @BeforeEach
    public void beforeEach() throws JsonProcessingException {
        //Set the data for the littleStore REST API
        baseURI = "http://165.227.93.41";
        //port = "";
        basePath = "/lojinha";

        User user = new User();
        user.setUsuarioLogin("raphaelsan");
        user.setUsuarioSenha("123456");

        //Retrieve the token for the admin user
        this.token = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/v2/login")
                .then()
                .extract()
                .path("data.token");
    }

    @Test
    @DisplayName("Validate product value 0.00 is not allowed")
    public void testValidatelimitedLowerProductValues() throws JsonProcessingException {
        //Attempt to insert a product with a value of 0.00 and validate that an error message is displayed along with status code 422.
        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProductDataFactory.createCommomProductWithVariableValue(0.00))
                .when()
                .post("/v2/produtos")
                .then()
                .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);

    }
    @Test
    @DisplayName("Validate product value above 7000.00 is not allowed")
    public void testValidatelimitedHigherProductValues() {
        //Attempt to insert a product with a value of 7000.01 and validate that an error message is displayed along with status code 422.
        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body((ProductDataFactory.createCommomProductWithVariableValue(7000.01)))
                .when()
                .post("/v2/produtos")
                .then()
                .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);
    }
}