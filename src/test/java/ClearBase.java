import org.junit.After;
import org.praktikum.methods.courier.Autorization;
import org.praktikum.methods.courier.DeleteCourier;

public class ClearBase {
    DeleteCourier del = new DeleteCourier();
    Autorization autorization = new Autorization();

    @After
    public void clearBase() {
        try {
            autorization.autorizationCourier();
            del.delCourier()
                    .then().assertThat().statusCode(200);
        } catch (Exception ex) {
            System.out.println("Test Passed: Курьер небыл создан");
        }
    }
}
