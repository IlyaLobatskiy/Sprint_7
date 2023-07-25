import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AuthorizationWithoutLoginAndPasswordTest {
    private String login;
    private String password;

    public AuthorizationWithoutLoginAndPasswordTest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[][] getLoginData() {
        return new Object[][]{
                {"Good", ""},
                {"", "Qwerty"},
        };
    }

    @Test
    public void authorizationWithoutLoginAndPasswordTest(){

    }
}
