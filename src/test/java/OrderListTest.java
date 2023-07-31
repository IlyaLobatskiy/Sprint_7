import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.praktikum.methods.orders.OrderList;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.notNullValue;

public class OrderListTest {
    OrderList list = new OrderList();

    @Test
    @DisplayName("Получение списка заказов")
    @Description("Проверь, что в тело ответа возвращается список заказов.")
    public void getOrderListTest() {
        list.getOrderList().then()
                .assertThat().statusCode(SC_OK)
                .and()
                .body("orders", notNullValue());
    }
}
