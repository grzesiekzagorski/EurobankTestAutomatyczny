package pl.b2b.net.eurobank.pages.loginPage;

public class LoginPageData {
    public static final String ID_TEXTBOX = "//input[@id=\"login_id\"]";
    public static final String NEXT_BUTTON = "//button[@id=\"login_next\"]";
    public static final String LOGIN_PASSWORD = "//input[@id=\"login_password\"]";
    public static final String SIGN_IN_BUTTON = "//button[contains(@id,'login_next') and text() = 'zaloguj się']";
    public static final String CUSTOMER_DATA = "//a[contains(@class,'show-page-loader') and text()='Agnieszka Eurobankowa']";
}
