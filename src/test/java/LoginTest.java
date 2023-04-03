import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    String incorrectPassword = "Sauleqa2!";
    String nonExistingEmail = "sauleqa1@rahulshettyacademy.com";
    String loginErrorMessage = "Incorrect email or password.";

    @Test
    public void loginWithEmptyEmail() {
        String errorMessage = launchApp
                .loginWithIncorrectCredentials("", incorrectPassword)
                .getEmailErrorMessage();
        assertEquals(errorMessage, "*Email is required", "Login email error message is not correct");
    }

    @Test
    public void loginWithEmptyPassword() {
        String errorMessage = launchApp
                .loginWithIncorrectCredentials(USER_EMAIL, "")
                .getPasswordErrorMessage();
        assertEquals(errorMessage, "*Password is required", "Login password error message is not correct");
    }

    @Test(dataProvider = "getData")
    public void loginWithIncorrectCredentials(HashMap<String,String> input) {
        String email = input.get("email");
        String password = input.get("password");
        String errorMessage = launchApp
                .loginWithIncorrectCredentials(email, password)
                .getLoginErrorMessage();
        assertEquals(errorMessage, loginErrorMessage, "Login error message is not correct");
    }

    @Test
    public void loginWithNonExistingEmail() {
        String errorMessage = launchApp
                .loginWithIncorrectCredentials(nonExistingEmail, USER_PASSWORD)
                .getLoginErrorMessage();
        assertEquals(errorMessage, loginErrorMessage, "Login error message is not correct");
    }

    @Test
    public void loginWithCorrectCredentials() {
        boolean isLoginSuccessful = launchApp
                .login()
                .isLoginSuccessfully();
        assertTrue(isLoginSuccessful, "Login with correct credentials was not successful");
    }

    @DataProvider
    public Object[][] getData() {
        HashMap<String,String> map1 = new HashMap<>();
        map1.put("email", USER_EMAIL);
        map1.put("password", incorrectPassword);

        HashMap<String,String> map2 = new HashMap<>();
        map2.put("email", nonExistingEmail);
        map2.put("password", USER_PASSWORD);

        return new Object[][] {{map1},{map2}};
    }
}
