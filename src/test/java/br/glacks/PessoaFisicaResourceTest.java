import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import br.glacks.dto.PessoaFisicaDTO;
import br.glacks.dto.UsuarioDTO;
import br.glacks.service.PessoaFisicaService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.inject.Inject;

@QuarkusTest
public class PessoaFisicaResourceTest {

    @Inject
    PessoaFisicaService pfService;

    @Test
    public void getAllTest() {
        given()
          .when().get("/pessoafisica")
          .then()
             .statusCode(200);
    }

    @Test
   public void testInsert() {
        PessoaFisicaDTO pf = new PessoaFisicaDTO(
            new UsuarioDTO("Tester", "teste123", "teste123"), "001.842.127-22"
        );

        given()
          .contentType(ContentType.JSON)
          .body(pf)
          .when().post("/pessoafisica")
          .then()
             .statusCode(201)
             .body("id", notNullValue(),
              	 "nome", is("Tester"),
             	 "cpf", is("001.842.127-22"));
    }


}