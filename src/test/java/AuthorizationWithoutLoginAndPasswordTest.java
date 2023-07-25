import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class AuthorizationWithoutLoginAndPasswordTest extends ClearBase {
    Autorization autorization = new Autorization();
    CreatedCourier courier = new CreatedCourier();
    private final String login;
    private final String password;

    public AuthorizationWithoutLoginAndPasswordTest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Login {0}, Password {1}")
    public static Object[][] getLoginData() {
        return new Object[][]{
                {"Good", ""},
                {"", "Qwerty"},
        };
    }

    @Test
    @DisplayName("Авторизация курьера с невалидными данными")
    @Description("Проверяем, что курьер не может авторизоваться без логина или пароля")
    public void authorizationNotParametersTest() {
        courier.createdNewCourier();
        autorization.autorizationCourierForNegativTests(login, password).then()
                .assertThat().statusCode(400)
                .and()
                .body("message", equalTo("Недостаточно данных для входа"));
    }
}

