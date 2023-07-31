import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.praktikum.methods.orders.Color;
import org.praktikum.methods.orders.NewOrder;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.Matchers.notNullValue;


@RunWith(Parameterized.class)
public class CreatedNewOrderTest {
    NewOrder newOrder = new NewOrder();
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color;

    public CreatedNewOrderTest(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, String[] color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    @Parameterized.Parameters(name = "Имя: {0}, Фамилия: {1}, Адресс: {2}, Название станции метро: {3}, Телефон: {4}, Время аренды: {5}, Дата доставки: {6}, Комментарий: {7}, Цвет: {8}")
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Naruto", "Uchiha", "Konoha, 142 apt.", "Октябрьская", "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", new String[]{Color.GREY.toString()}},
                {"Naruto", "Uchiha", "Konoha, 142 apt.", "Октябрьская", "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", new String[]{Color.BLACK.toString()}},
                {"Naruto", "Uchiha", "Konoha, 142 apt.", "Октябрьская", "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", new String[]{Color.GREY.toString(), Color.BLACK.toString()}},
                {"Naruto", "Uchiha", "Konoha, 142 apt.", "Октябрьская", "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", null},
        };
    }

    @Test
    @DisplayName("Вобор цвета при создании заказа")
    @Description("Проверяем, что можно выбрать любой из доступных цветов при создании заказа, либо оставить цвет невыбранным")
    public void newOrderTest() {
        newOrder.createdNewOrder(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color)
                .then().assertThat().statusCode(SC_CREATED)
                .and()
                .body("track", notNullValue());
    }
}
