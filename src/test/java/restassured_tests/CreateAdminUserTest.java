package restassured_tests;

import eu.senla.regoffice.client.AdminApiClient;
import eu.senla.regoffice.models.AdminRegistrationDataDto;
import eu.senla.regoffice.models.CreateAdminResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateAdminUserTest {

    private final AdminApiClient adminApiClient = new AdminApiClient();

    @Test
    void positiveCreateAdminUserTest() {
        var randomAdminRegistrationData = AdminRegistrationDataDto.getRandomAdminRegistrationData();

        var createAdminResponse = adminApiClient.createAdmin(randomAdminRegistrationData)
                .statusCode(200)
                .extract().as(CreateAdminResponse.class);
        assertAll(
                () -> assertNotNull(createAdminResponse.data().staffid()),
                () -> assertNotNull(createAdminResponse.requestId())

        );
    }

    @Test
    void canNotCreateAdminWithoutLastNameTest() {
        var randomAdminRegistrationData = AdminRegistrationDataDto.getRandomAdminRegistrationData();
        var body = AdminRegistrationDataDto.builder()
                .personalLastName(null)
                .personalFirstName(randomAdminRegistrationData.personalFirstName())
                .personalMiddleName(randomAdminRegistrationData.personalMiddleName())
                .personalPhoneNumber(randomAdminRegistrationData.personalPhoneNumber())
                .personalNumberOfPassport(randomAdminRegistrationData.personalNumberOfPassport())
                .dateofbirth(randomAdminRegistrationData.dateofbirth())
                .build();

        adminApiClient.createAdmin(body)
                .statusCode(400)
                .body("code", Matchers.equalTo("request error"))
                .body("message", Matchers.equalTo("Property personalLastName is null!"));
    }
}
