import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.hamcrest.Matchers.notNullValue;


@RunWith(Parameterized.class)
public class CreatedNewOrderTest {

    static Color colorScooter = new Color();
    NewOrder newOrder = new NewOrder();
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final int rentTime;
    private final String deliveryDate;
    private final String comment;
    private final String[] color;

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
                {"Naruto", "Uchiha", "Konoha, 142 apt.", "Октябрьская", "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", colorScooter.getGrey()},
                {"Naruto", "Uchiha", "Konoha, 142 apt.", "Октябрьская", "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", colorScooter.getBlack()},
                {"Naruto", "Uchiha", "Konoha, 142 apt.", "Октябрьская", "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", colorScooter.getBlackAndGray()},
                {"Naruto", "Uchiha", "Konoha, 142 apt.", "Октябрьская", "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", null},
        };
    }

    @Test
    @DisplayName("Вобор цвета при создании заказа")
    @Description("Проверяем, что можно выбрать любой из доступных цветов при создании заказа, либо оставить цвет невыбранным")
    public void newOrderTest() {
        newOrder.createdNewOrder(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color)
                .then().assertThat().statusCode(201)
                .and()
                .body("track", notNullValue());
    }
}
