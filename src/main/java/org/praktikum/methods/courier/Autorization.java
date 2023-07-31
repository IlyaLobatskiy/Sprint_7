package org.praktikum.methods.courier;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.praktikum.deserialization.IdCourier;
import org.praktikum.serialization.LoginCourier;

import static io.restassured.RestAssured.given;

public class Autorization extends DataScooter {

    private final static String ENDPOINT_LOGIN_COURIER = "/api/v1/courier/login";
    private String login = "Good";
    private String password = "Qwerty";


    @Step("Авторизация курьера с дефолтными данными")
    public Response autorizationCourier() {
        LoginCourier json = new LoginCourier(login, password);
        return given()
                .header("Content-type", "application/json")
                .baseUri(DataScooter.MY_URL)
                .body(json)
                .post(ENDPOINT_LOGIN_COURIER);
    }

    @Step("ID авторизованого курьера")
    public String getId() {
        IdCourier id = autorizationCourier().body().as(IdCourier.class);
        return id.getId();
    }

    @Step("Авторизация курьера со своими данными")
    public Response autorizationCourierForNegativTests(String login, String password) {
        LoginCourier json = new LoginCourier(login, password);
        return given()
                .header("Content-type", "application/json")
                .baseUri(DataScooter.MY_URL)
                .body(json)
                .post(ENDPOINT_LOGIN_COURIER);
    }


}
