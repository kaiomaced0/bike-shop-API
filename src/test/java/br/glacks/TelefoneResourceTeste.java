package br.glacks;

import br.glacks.dto.AuthUsuarioDTO;
import br.glacks.dto.TelefoneDTO;
import br.glacks.model.Telefone;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TelefoneResourceTeste {

    private String token;

    @BeforeEach
    public void setUp() {

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
                .when().get("/telefone")
                .then()
                .statusCode(200);
    }

    @Test
    public void getIdTeste() {
        given()
                .pathParam("id", 100)
                .header("Authorization", "Bearer " + token)
                .when().get("/telefone/{id}")
                .then()
                .statusCode(200)
                .body("id", is(100));
    }

    @Test
    public void insertTest() {

        TelefoneDTO telefone = new TelefoneDTO("63", "984232991");

        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(telefone)
                .when().post("/telefone")
                .then()
                .statusCode(200)
                .body("codigoArea", is("63"))
                .body("numero", is("984232991"));
    }

    @Test
    public void updateTest() {

        var telefoneDTO = new TelefoneDTO("63", "99999999");

        given()
                .pathParam("id", "100")
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(telefoneDTO)
                .when().put("/telefone/update/{id}")
                .then()
                .statusCode(200);
    }
}