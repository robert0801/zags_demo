package eu.senla.regoffice.specification;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static eu.senla.regoffice.utils.PropertyReader.*;

public class ApiSpecification {

    private ApiSpecification() {
    }

    public static RequestSpecification reqSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl())
                .setContentType(ContentType.JSON)
                .setAuth(RestAssured.preemptive().basic(getLogin(), getPassword()))
                .addFilter(new AllureRestAssured())
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification respSpec() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}