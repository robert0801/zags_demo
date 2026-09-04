package eu.senla.regoffice.models;

import lombok.Builder;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

@Builder
public record AdminRegistrationDataDto(String personalLastName,
                                       String personalFirstName,
                                       String personalMiddleName,
                                       String personalPhoneNumber,
                                       String personalNumberOfPassport,
                                       LocalDate dateofbirth) {

    public static AdminRegistrationDataDto getRandomAdminRegistrationData() {
        Faker faker = new Faker(Locale.of("ru_RU"));
        LocalDate birthday = faker.timeAndDate().birthday();

        return new AdminRegistrationDataDto(faker.name().lastName(),
                faker.name().firstName(),
                faker.name().firstName(),
                faker.phoneNumber().subscriberNumber(11),
                faker.number().digits(8),
                birthday
        );
    }
}
