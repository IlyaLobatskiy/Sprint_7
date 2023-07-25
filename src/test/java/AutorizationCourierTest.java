import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AutorizationCourierTest extends ClearBase {
    Autorization login = new Autorization();
    CreatedCourier courier = new CreatedCourier();

    @Test
    @DisplayName("Авторизация курьера с ввлидными данными")
    @Description("Проверяем, что курьер может авторизоваться")
    public void autorizationTest() {
        courier.createdNewCourier();
        login.autorizationCourier().then()
                .assertThat().statusCode(200)
                .and()
                .body("id", notNullValue());
    }

    @Test
    @DisplayName("Авторизация несуществующего курьера")
    @Description("Проверяем, что невозможно авторизовать курьера с несуществующими данными")
    public void AuthorizationOfANonExistentCourier() {
        login.autorizationCourierForNegativTests("NoNAme", "12345")
                .then().assertThat().statusCode(404)
                .and()
                .body("message", equalTo("Учетная запись не найдена"));
    }

}
