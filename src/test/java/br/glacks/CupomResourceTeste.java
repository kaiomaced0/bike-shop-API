package br.glacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.glacks.dto.AuthUsuarioDTO;
import br.glacks.dto.CupomDTO;
import br.glacks.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CupomResourceTeste {

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
                .when().get("/cupom")
                .then()
                .statusCode(200);
    }

    @Test
    public void getIdTeste() {
        given()
                .pathParam("id", 100)
                .header("Authorization", "Bearer " + token)
                .when().get("/cupom/{id}")
                .then()
                .statusCode(200)
                .body("id", is(100));
    }

    @Test
    public void insertTest() {

        CupomDTO cupom = new CupomDTO("cupom1", 10, null, 10.00, null);

        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(cupom)
                .when().post("/cupom")
                .then()
                .statusCode(200)
                .body("nome", is("cupom1"))
                .body("quantidade", is(10));
    }
}
