package pl.b2b.net.eurobank.pages.homePage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.b2b.net.eurobank.cfg.SingletonWebDriver;

public class HomePageTest {

    private HomePageObject homePageObject;

    @BeforeClass
    public void setUp(){
        homePageObject = new HomePageObject(SingletonWebDriver.getWebDriver(),SingletonWebDriver.getWait());
    }

    @Test
    public void goToTheTransferFormTest(){
        homePageObject.goToTheTransferForm();
    }
}
