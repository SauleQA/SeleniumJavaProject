import org.testng.annotations.Test;

import static org.sauleqa.pageobjects.ConfirmationPage.orderNum;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BuyProductTest extends BaseTest{

    String productName = "ADIDAS ORIGINAL";
    String country = "Kazakhstan";

    @Test
    public void checkConfirmMessage() {
        String confirmMessage = launchApp
                .login()
                .addProductToCart(productName)
                .goToCart()
                .clickCheckoutButton()
                .setUserAddress(country.substring(0,2))
                .selectUserAddressOption(country)
                .clickConfirmButton()
                .getOrderNumber()
                .getConfirmText();

        assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."), "Confirm message is not correct");
    }

    @Test(dependsOnMethods = {"checkConfirmMessage"})
    public void checkHistoryAfterBuyingProduct() {
        String orderIdOfLastOrder = launchApp
                .login()
                .goToOrders()
                .getOrderIdOfLastOrder();

        assertEquals(orderIdOfLastOrder, orderNum, "Order number of last order is not correct");
    }
}
