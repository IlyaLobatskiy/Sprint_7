package org.praktikum.methods.orders;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.praktikum.methods.courier.DataScooter;

import static io.restassured.RestAssured.given;

public class OrderList extends DataScooter {
    private final static String GET_ORDER_LIST_ENDPOINT = "/api/v1/orders";

    @Step("Запрос списока заказов")
    public Response getOrderList() {
        return given()
                .header("Content-type", "application/json")
                .baseUri(DataScooter.MY_URL)
                .get(GET_ORDER_LIST_ENDPOINT);
    }
}
