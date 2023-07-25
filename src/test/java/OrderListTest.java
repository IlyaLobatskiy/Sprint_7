import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;

public class OrderListTest {
    OrderList list = new OrderList();

    @Test
    public void getOrderListTest() {
        list.getOrderList().then()
                .assertThat().statusCode(200)
                .and()
                .body("orders", notNullValue());
    }
}
