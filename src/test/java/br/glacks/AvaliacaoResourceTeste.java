package br.glacks;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AvaliacaoResourceTeste {
    
    @Test
    public void getAllTeste() {
        given()
          .when().get("/usuario")
          .then()
             .statusCode(200);
    }

    @Test
    public void getIdTeste() {
        given()
          .pathParam("id", 1)
          .when().get("/avaliacao/{id}")
          .then()
             .statusCode(200)
             .body("id", is(1));
    }
}