import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.praktikum.methods.courier.CreatedCourier;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreatedCourierTest extends ClearBase {
    CreatedCourier courier = new CreatedCourier();

    @Test
    @DisplayName("Создание курьера")
    @Description("Создаем курьера с валидными данными")
    public void createdNewCourierTest() {
        courier.createdNewCourier()
                .then().assertThat().statusCode(201)
                .and()
                .body("ok", equalTo(true));
    }

    @Test
    @DisplayName("Создание уже существующего курьера")
    @Description("Попытка создание курьера с данными имеющимися в базе")
    public void createdDoobleCourierTest() {
        courier.createdNewCourier();
        courier.createdNewCourier()
                .then().assertThat().statusCode(409)
                .and()
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }

}
