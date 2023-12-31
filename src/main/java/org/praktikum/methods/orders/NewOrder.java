package org.praktikum.methods.orders;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.praktikum.methods.courier.DataScooter;
import org.praktikum.serialization.Orders;

import static io.restassured.RestAssured.given;

public class NewOrder extends DataScooter {

    private final static String CREATED_ORDER_ENDPOINT = "/api/v1/orders";

    @Step("Создание нового заказа")
    public Response createdNewOrder(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, String[] color) {
        Orders json = new Orders(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
        return given()
                .header("Content-type", "application/json")
                .baseUri(DataScooter.MY_URL)
                .body(json)
                .post(CREATED_ORDER_ENDPOINT);
    }
}
