package org.praktikum.methods.courier;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.praktikum.serialization.Courier;

import static io.restassured.RestAssured.given;

public class CreatedCourier extends DataScooter {
    private final static String ENDPOINT_NEW_COURIER = "/api/v1/courier";
    private String login = "Good";
    private String password = "Qwerty";
    private String firstName = "Best";

    @Step("Создание курьера")
    public Response createdNewCourier() {
        Courier json = new Courier(login, password, firstName);
        return given()
                .header("Content-type", "application/json")
                .baseUri(DataScooter.MY_URL)
                .body(json)
                .post(ENDPOINT_NEW_COURIER);
    }

    @Step("Создание курьера без параметров")
    public Response creatingCourierDontRequiredFieldsTest(String login, String password, String firstName) {
        Courier json = new Courier(login, password, firstName);
        return given()
                .header("Content-type", "application/json")
                .baseUri(DataScooter.MY_URL)
                .body(json)
                .post(ENDPOINT_NEW_COURIER);
    }
}
