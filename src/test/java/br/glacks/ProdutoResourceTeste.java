//package br.glacks;
//
//import io.quarkus.test.junit.QuarkusTest;
//import io.restassured.response.Response;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import br.glacks.dto.AuthUsuarioDTO;
//import br.glacks.dto.ProdutoDTO;
//import br.glacks.dto.UsuarioUpdateDTO;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.is;
//
//@QuarkusTest
//public class ProdutoResourceTeste {
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
//        .when().get("/produto")
//        .then()
//        .statusCode(200);
//  }
//
//  @Test
//  public void getIdTeste() {
//    given()
//        .pathParam("id", 100)
//        .header("Authorization", "Bearer " + token)
//        .when().get("/produto/{id}")
//        .then()
//        .statusCode(200)
//        .body("id", is(100));
//  }
//
//  @Test
//  public void insertTest() {
//
//    ProdutoDTO produto = new ProdutoDTO("produtocreated", null, 100.00, null, null);
//
//    given()
//        .header("Authorization", "Bearer " + token)
//        .contentType("application/json")
//        .body(produto)
//        .when().post("/produto")
//        .then()
//        .statusCode(200)
//        .body("nome", is("produtocreated"));
//  }
//
//  @Test
//  public void updateTest() {
//
//    ProdutoDTO produtoDTO = new ProdutoDTO("produtoupdated", null, null, null, null);
//
//    given()
//        .pathParam("id", 100)
//        .header("Authorization", "Bearer " + token)
//        .contentType("application/json")
//        .body(produtoDTO)
//        .when().put("/usuario/update/{id}")
//        .then()
//        .statusCode(200)
//        .body("nome", is("produtoupdated"));
//  }
//
//}