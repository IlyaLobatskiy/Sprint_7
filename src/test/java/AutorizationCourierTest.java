import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.praktikum.methods.courier.Autorization;
import org.praktikum.methods.courier.CreatedCourier;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
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
                .assertThat().statusCode(SC_OK)
                .and()
                .body("id", notNullValue());
    }

    @Test
    @DisplayName("Авторизация несуществующего курьера")
    @Description("Проверяем, что невозможно авторизовать курьера с несуществующими данными")
    public void authorizationOfANonExistentCourier() {
        login.autorizationCourierForNegativTests("NoName", "12345")
                .then().assertThat().statusCode(SC_NOT_FOUND)
                .and()
                .body("message", equalTo("Учетная запись не найдена"));
    }

}
