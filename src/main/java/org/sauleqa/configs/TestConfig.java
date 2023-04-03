package org.sauleqa.configs;

import org.sauleqa.utils.PropertyLoader;

public class TestConfig {
    public static String UI_BASE_URL = PropertyLoader.getProperty("login_url");
    public static String USER_EMAIL = PropertyLoader.getProperty("user_email");
    public static String USER_PASSWORD = PropertyLoader.getProperty("user_password");
}
