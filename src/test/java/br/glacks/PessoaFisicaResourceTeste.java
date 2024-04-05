//package br.glacks;
//
//import br.glacks.dto.*;
//import io.quarkus.test.junit.QuarkusTest;
//import io.restassured.response.Response;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.is;
//
//@QuarkusTest
//public class PessoaFisicaResourceTeste {
//
//  private String token;
//
//  @BeforeEach
//  public void setAuth() {
//
//    var auth = new AuthUsuarioDTO("teste", "123");
//
//    Response response = (Response) given()
//        .contentType("application/json")
//        .body(auth)
//        .when().post("/auth")
//        .then()
//        .statusCode(200)
//        .extract().response();
//
//    token = response.header("Authorization");
//  }
//
//  @Test
//  public void getAllTeste() {
//    given()
//        .header("Authorization", "Bearer " + token)
//        .when().get("/pessoafisica")
//        .then()
//        .statusCode(200);
//  }
//
//  @Test
//  public void getIdTeste() {
//    given()
//        .pathParam("id", 100)
//        .header("Authorization", "Bearer " + token)
//        .when().get("/pessoafisica/{id}")
//        .then()
//        .statusCode(200)
//        .body("id", is(100));
//  }
//
//
//  @Test
//  public void insertTest() {
//    PessoaFisicaDTO p = new PessoaFisicaDTO("pessoa teste", "teste 0000", new UsuarioDTO("usuariouser",
//            "cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==", "user@gmail.com"));
//
//    given()
//        .header("Authorization", "Bearer " + token)
//        .contentType("application/json")
//        .body(p)
//        .when().post("/pessoafisica")
//        .then()
//        .statusCode(200)
//        .body("cpf", is("000023823"));
//  }
//
//  @Test
//  public void updateTest() {
//
//    PessoaFisicaDTO p = new PessoaFisicaDTO("teste", "3242", new UsuarioDTO("usuariouser",
//            "cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==", "user@gmail.com"));
//
//    given()
//        .pathParam("id", 100)
//        .header("Authorization", "Bearer " + token)
//        .contentType("application/json")
//        .body(p)
//        .when().put("/pessoafisica/update/{id}")
//        .then()
//        .statusCode(200)
//        .body("cpf", is("3242"));
//  }
//}