package br.glacks;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.glacks.dto.AuthUsuarioDTO;
import br.glacks.dto.AvaliacaoDTO;
import br.glacks.dto.TelefoneDTO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AvaliacaoResourceTeste {
    
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
                .when().get("/avaliacao")
                .then()
                .statusCode(200);
    }

    @Test
    public void getIdTeste() {
        given()
                .pathParam("id", 100)
                .header("Authorization", "Bearer " + token)
                .when().get("/avaliacao/{id}")
                .then()
                .statusCode(200)
                .body("id", is(100));
    }

    @Test
    public void insertTest() {

        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO(1000, 5, "bom bom bom", null);

        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(avaliacaoDTO)
                .when().post("/avaliacao/insert")
                .then()
                .statusCode(200)
                .body("id", is("1000"),
                          "comentario", is("bom bom bom"));
    }

    @Test
    public void updateTest() {
      AvaliacaoDTO a = new AvaliacaoDTO(200, 5, "excelente", 100);
        given()
                .pathParam("id", "100")
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(a)
                .when().put("/avaliacao/update/{id}")
                .then()
                .statusCode(200)
                .body("id", is("200"),
                        "comentario", is("excelente"));
    }
    
}