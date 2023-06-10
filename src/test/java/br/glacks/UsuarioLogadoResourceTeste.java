package br.glacks;
import org.junit.jupiter.api.BeforeEach;

import br.glacks.dto.AuthUsuarioDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class UsuarioLogadoResourceTeste {
    
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
    
}
