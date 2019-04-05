package pl.b2b.net.eurobank.pages.loginPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pl.b2b.net.eurobank.cfg.SingletonWebDriver;

public class LoginPageTest {

    private LoginPageObject loginPageObject;

    @BeforeClass
    public void setUp(){
        loginPageObject = new LoginPageObject(SingletonWebDriver.getWebDriver(),SingletonWebDriver.getWait());
    }

    @Test
    @Parameters({"id","password"})
    public void logInToTheWebsiteTest(String id,String password){
        loginPageObject.logInToTheWebsite(id,password);
        Assert.assertTrue(loginPageObject.checkTheCorrectLogin(),"Zalogowany uzytkownik:Agnieszka Eurobankowa");
    }

}
