package eu.senla.regoffice.client;

import eu.senla.regoffice.models.AdminRegistrationDataDto;
import eu.senla.regoffice.specification.ApiSpecification;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class AdminApiClient {

    public ValidatableResponse createAdmin(AdminRegistrationDataDto body) {
        return given()
                .spec(ApiSpecification.reqSpec())
                .body(body)
                .post("/sendAdminRequest")
                .then()
                .spec(ApiSpecification.respSpec());
    }

    public ValidatableResponse requestProcess(AdminRegistrationDataDto body) {
        return given()
                .body(body)
                .post("/requestProcess")
                .then()
                .spec(ApiSpecification.respSpec());
    }
}
