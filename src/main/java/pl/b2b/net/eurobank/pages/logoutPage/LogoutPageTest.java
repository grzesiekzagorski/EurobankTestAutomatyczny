package pl.b2b.net.eurobank.pages.logoutPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.b2b.net.eurobank.cfg.SingletonWebDriver;

public class LogoutPageTest {

    LogoutPageObject logoutPageObject;

    @BeforeClass
    public void setUp(){
        logoutPageObject = new LogoutPageObject(SingletonWebDriver.getWebDriver(),SingletonWebDriver.getWait());
    }

    @Test
    public void logOutFromServiceEurobank(){
        logoutPageObject.logoutOfTheSite();
        Assert.assertTrue(logoutPageObject.checkButtonLogin());
    }
}
