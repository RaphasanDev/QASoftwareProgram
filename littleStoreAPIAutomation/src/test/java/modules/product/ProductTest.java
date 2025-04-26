package modules.product;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Product modules API Rest tests")
public class ProductTest {
    @Test
    @DisplayName("Validate limits values at product value")
    public void testValidatelimitedProductValues() {
        //Set the data for the littleStore REST API
        baseURI = "http://165.227.93.41";
        //port = "";
        basePath = "/lojinha";

        //Retrieve the token for the admin user
        String token = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"usuarioLogin\": \"raphaelsan\",\n" +
                        "  \"usuarioSenha\": \"123456\"\n" +
                        "}")
                .when()
                .post("/v2/login")
                .then()
                .extract()
                .path("data.token");
        System.out.println(token);

        //Attempt to insert a product with a value of 0.00 and validate that an error message is displayed along with status code 422.
        given()
                .contentType(ContentType.JSON)
                .header("token", token)
                .body("{\n" +
                        "  \"produtoNome\": \"Xbox S Series\",\n" +
                        "  \"produtoValor\": 0.00,\n" +
                        "  \"produtoCores\": [\n" +
                        "    \"preto\"\n" +
                        "  ],\n" +
                        "  \"produtoUrlMock\": \"**\",\n" +
                        "  \"componentes\": [\n" +
                        "    {\n" +
                        "      \"componenteNome\": \"Controle\",\n" +
                        "      \"componenteQuantidade\": 2\n" +
                        "    }, \n" +
                        "    {\n" +
                        "      \"componenteNome\": \"FC 2024\",\n" +
                        "      \"componenteQuantidade\": 1\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                    .post("/v2/produtos")
                .then()
                .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);

    }
}
