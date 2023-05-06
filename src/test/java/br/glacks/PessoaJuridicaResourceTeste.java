package br.glacks;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PessoaJuridicaResourceTeste {

    @Test
    public void getAllTeste() {
        given()
          .when().get("/pessoajuridica")
          .then()
             .statusCode(200);
    }

    @Test
    public void getIdTeste() {
        given()
          .pathParam("id", 5)
          .when().get("/pessoajuridica/{id}")
          .then()
             .statusCode(200)
             .body("id", is(5),
             "login", is("janio"));
    }
}