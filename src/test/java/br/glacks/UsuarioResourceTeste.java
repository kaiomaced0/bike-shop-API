package br.glacks;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.glacks.dto.AuthUsuarioDTO;
import br.glacks.dto.UsuarioDTO;
import br.glacks.dto.UsuarioUpdateDTO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class UsuarioResourceTeste {

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
        .when().get("/usuario")
        .then()
        .statusCode(200);
  }

  @Test
  public void getIdTeste() {
    given()
        .pathParam("id", 100)
        .header("Authorization", "Bearer " + token)
        .when().get("/usuario/{id}")
        .then()
        .statusCode(200)
        .body("id", is(100),
            "login", is("teste"));
  }

  @Test
  public void insertTest() {

    UsuarioDTO usuarioDTO = new UsuarioDTO("usuariouser", "usuariouser",
        "cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==", "user@gmail.com");

    given()
        .header("Authorization", "Bearer " + token)
        .contentType("application/json")
        .body(usuarioDTO)
        .when().post("/usuario")
        .then()
        .statusCode(200)
        .body("nome", is("usuariouser"))
        .body("login", is("usuariouser"));
  }

  @Test
  public void updateTest() {

    UsuarioUpdateDTO userDTO = new UsuarioUpdateDTO("UsuarioBrabo", null, null, null);

    given()
        .pathParam("id", "100")
        .header("Authorization", "Bearer " + token)
        .contentType("application/json")
        .body(userDTO)
        .when().put("/usuario/update/{id}")
        .then()
        .statusCode(200)
        .body("nome", is("UsuarioBrabo"));
  }
}