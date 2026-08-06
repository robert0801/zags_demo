package eu.senla.regoffice.models;

import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

public record AdminRegistrationDataDto(String lastName,
                                       String firstName,
                                       String middleName,
                                       String phone,
                                       String passport,
                                       LocalDate birthday) {

    public static AdminRegistrationDataDto getRandomAdminRegistrationData() {
        Faker faker = new Faker(Locale.of("ru_RU"));
        LocalDate birthday = faker.timeAndDate().birthday();

        return new AdminRegistrationDataDto(faker.name().lastName(),
                faker.name().firstName(),
                faker.name().firstName(),
                faker.phoneNumber().phoneNumber(),
                faker.passport().valid(),
                birthday
        );
    }
}
