package br.glacks;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.glacks.dto.AuthUsuarioDTO;
import br.glacks.dto.BikeDTO;
import br.glacks.dto.ProdutoDTO;
import br.glacks.dto.TelefoneDTO;
import br.glacks.model.Cor;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BikeResourceTeste {

  private String token;

  @BeforeEach
  public void setAuth() {

    var auth = new AuthUsuarioDTO("teste", "123");

    Response response = (Response) given()
        .contentType("application/json")
        .body(auth)
        .when().post("/auth")
        .then()
        .statusCode(200)
        .extract().response();

    token = response.header("Authorization");
  }

  @Test
  public void getAllTeste() {
    given()
        .header("Authorization", "Bearer " + token)
        .when().get("/bike")
        .then()
        .statusCode(200);
  }

  @Test
  public void getIdTeste() {
    given()
        .pathParam("id", 1)
        .header("Authorization", "Bearer " + token)
        .when().get("/bike/{id}")
        .then()
        .statusCode(200)
        .body("id", is(1),
            "nome", is("bike 1"),
            "preco", is(1020.0F),
            "tamanho", is("A5"));
  }

  @Test
  public void insertTest() {

    BikeDTO b = new BikeDTO(new ProdutoDTO("bike 10", null, 200.00, Cor.BRANCO, 10), token, token, token, null, null);
    given()
        .header("Authorization", "Bearer " + token)
        .contentType("application/json")
        .body(b)
        .when().post("/bike/insert")
        .then()
        .statusCode(200)
        .body("nome", is("bike 10"))
        .body("preco", is(200.00));
  }
}