package br.glacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.glacks.dto.AuthUsuarioDTO;
import br.glacks.dto.TelefoneDTO;
import br.glacks.model.locais.Estado;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class EstadoResourceTeste {

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
                .when().get("/estado")
                .then()
                .statusCode(200);
    }

    @Test
    public void getIdTeste() {
        given()
                .pathParam("id", 100)
                .header("Authorization", "Bearer " + token)
                .when().get("/estado/{id}")
                .then()
                .statusCode(200)
                .body("id", is(100));
    }

    @Test
    public void insertTest() {
        Integer a = 202;
        Estado estado = new Estado();
        estado.setId(a.longValue());
        estado.setNome("testeestado");
        estado.setSigla("ab");

        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(estado)
                .when().post("/estado")
                .then()
                .statusCode(200)
                .body("id", is(202))
                .body("nome", is("testeestado")
                    
                );
    }
}
