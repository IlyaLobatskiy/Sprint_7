package org.praktikum.methods.courier;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteCourier extends DataScooter {
    private final static String deleteEndpoint = "/api/v1/courier/{id}";

    @Step("Удаление курьера")
    public Response delCourier() {
        Autorization autorization = new Autorization();
        return given()
                .header("Content-type", "application/json")
                .baseUri(DataScooter.MY_URL)
                .delete(deleteEndpoint, autorization.getId());
    }

}
