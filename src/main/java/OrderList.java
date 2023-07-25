import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OrderList extends DataScooter{
    private final String GET_ORDER_LIST_ENDPOINT = "/api/v1/orders";
    @Step("Запрос списока заказов")
    public Response getOrderList(){
        return given()
                .header("Content-type", "application/json")
                .baseUri(MY_URL)
                .get(GET_ORDER_LIST_ENDPOINT);
    }
}
