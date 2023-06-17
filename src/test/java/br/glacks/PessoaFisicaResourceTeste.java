package br.glacks;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.glacks.dto.AuthUsuarioDTO;
import br.glacks.dto.PessoaFisicaDTO;
import br.glacks.dto.PessoaJuridicaDTO;
import br.glacks.dto.TelefoneDTO;
import br.glacks.dto.UsuarioDTO;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PessoaFisicaResourceTeste {

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
        .when().get("/pessoafisica")
        .then()
        .statusCode(200);
  }

  @Test
  public void getIdTeste() {
    given()
        .pathParam("id", 100)
        .header("Authorization", "Bearer " + token)
        .when().get("/pessoafisica/{id}")
        .then()
        .statusCode(200)
        .body("id", is(100));
  }

  @Test
  public void insertTest() {
    UsuarioDTO u = new UsuarioDTO("userteste001", "testando01", "teste01", "teste01@gmail.com");

    PessoaFisicaDTO p = new PessoaFisicaDTO(u, "000023823");

    given()
        .header("Authorization", "Bearer " + token)
        .contentType("application/json")
        .body(p)
        .when().post("/pessoafisica")
        .then()
        .statusCode(200)
        .body("cpf", is("000023823"));
  }

  @Test
  public void updateTest() {
    UsuarioDTO u = new UsuarioDTO("userteste001", "testando01", "teste01", "teste01@gmail.com");

    PessoaFisicaDTO p = new PessoaFisicaDTO(u, "3242");

    given()
        .pathParam("id", 100)
        .header("Authorization", "Bearer " + token)
        .contentType("application/json")
        .body(p)
        .when().put("/pessoafisica/update/{id}")
        .then()
        .statusCode(200)
        .body("cpf", is("3242"));
  }
}