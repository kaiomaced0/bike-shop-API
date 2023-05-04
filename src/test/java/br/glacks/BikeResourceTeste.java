package br.glacks;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BikeResourceTeste {

    @Test
    public void getIdTeste() {
        given()
          .pathParam("id", 1)
          .when().get("/bike/{id}")
          .then()
             .statusCode(200)
             .body("id", is(1));
    }
}