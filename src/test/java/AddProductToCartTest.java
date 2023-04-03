import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCartTest extends BaseTest {

    String productName = "ADIDAS ORIGINAL";

    @Test
    public void addProductToCart() {

        boolean isProductInCart = launchApp
                .login()
                .addProductToCart(productName)
                .goToCart()
                .isProductInCart(productName);
        Assert.assertTrue(isProductInCart, productName + " was not found in cart");
    }
}
