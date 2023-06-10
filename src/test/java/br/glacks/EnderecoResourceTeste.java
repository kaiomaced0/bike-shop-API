package br.glacks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.glacks.dto.AuthUsuarioDTO;
import br.glacks.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class EnderecoResourceTeste {

    
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
                .when().get("/endereco")
                .then()
                .statusCode(200);
    }

    @Test
    public void getIdTeste() {
        given()
                .pathParam("id", 100)
                .header("Authorization", "Bearer " + token)
                .when().get("/endereco/{id}")
                .then()
                .statusCode(200)
                .body("id", is(100));
    }

    @Test
    public void insertTest() {

        TelefoneDTO endereco = new TelefoneDTO("63", "984232991", 1);

        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(endereco)
                .when().post("/endereco")
                .then()
                .statusCode(200)
                .body("codigoArea", is("63"))
                .body("numero", is("984232991"));
    }
}
