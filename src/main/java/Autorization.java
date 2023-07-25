import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Autorization extends DataScooter {

    private final String ENDPOINT_LOGIN_COURIER = "/api/v1/courier/login";
    private final String login = "Good";
    private final String password = "Qwerty";


    @Step ("Авторизация курьера с дефолтными данными")
    public Response autorizationCourier() {
        LoginCourier json = new LoginCourier(login, password);
        return given()
                .header("Content-type", "application/json")
                .baseUri(MY_URL)
                .body(json)
                .post(ENDPOINT_LOGIN_COURIER);
    }

    @Step ("ID авторизованого курьера")
    public String getId() {
        IdCourier id = autorizationCourier().body().as(IdCourier.class);
        return id.getId();
    }

    @Step ("Авторизация курьера со своими данными")
    public Response autorizationCourierForNegativTests(String login, String password) {
        LoginCourier json = new LoginCourier(login, password);
        return given()
                .header("Content-type", "application/json")
                .baseUri(MY_URL)
                .body(json)
                .post(ENDPOINT_LOGIN_COURIER);
    }


}
