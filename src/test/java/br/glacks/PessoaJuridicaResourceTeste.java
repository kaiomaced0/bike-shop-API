package br.glacks;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.glacks.dto.AuthUsuarioDTO;
import br.glacks.dto.PessoaJuridicaDTO;
import br.glacks.dto.UsuarioDTO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PessoaJuridicaResourceTeste {

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
        .when().get("/pessoajuridica")
        .then()
        .statusCode(200);
  }

  @Test
  public void getIdTeste() {
    given()
        .pathParam("id", 101)
        .header("Authorization", "Bearer " + token)
        .when().get("/pessoajuridica/{id}")
        .then()
        .statusCode(200)
        .body("id", is(101));
  }

  @Test
  public void insertTest() {
    UsuarioDTO u = new UsuarioDTO("userteste001", "testando01", "teste01", "teste01@gmail.com");
    PessoaJuridicaDTO p = new PessoaJuridicaDTO(u, "10101010");
    given()
        .header("Authorization", "Bearer " + token)
        .contentType("application/json")
        .body(p)
        .when().post("/pessoajuridica")
        .then()
        .statusCode(200)
        .body("cnpj", is("10101010"));
  }

  @Test
  public void updateTest() {
    UsuarioDTO u = new UsuarioDTO("userteste001", "testando01", "teste01", "teste01@gmail.com");

    PessoaJuridicaDTO p = new PessoaJuridicaDTO(u, "00000087");

    given()
        .pathParam("id", 101)
        .header("Authorization", "Bearer " + token)
        .contentType("application/json")
        .body(p)
        .when().put("/pessoajuridica/update/{id}")
        .then()
        .statusCode(200)
        .body("cnpj", is("00000087"));
  }
}