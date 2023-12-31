import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.praktikum.methods.courier.CreatedCourier;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class CreatingCourierDontRequiredFieldsTest extends ClearBase {

    CreatedCourier courier = new CreatedCourier();

    private String login;
    private String password;
    private String firstName;

    public CreatingCourierDontRequiredFieldsTest(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    @Parameterized.Parameters(name = "Login: {0}, Password: {1}, Имя: {2}")
    public static Object[][] getCourierData() {
        return new Object[][]{
                {"", "Qwerty", "Best"},
                {"Good", "Qwerty", ""},
                {"Good", "", "Best"},
        };
    }

    @Test
    @DisplayName("Создание курьера с навлидными данными")
    @Description("Попытка создать курьера с незаполнеными обязательными полями")
    public void createdCourierTest() {
        courier.creatingCourierDontRequiredFieldsTest(login, password, firstName)
                .then().assertThat().statusCode(SC_BAD_REQUEST)
                .and()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }
}
