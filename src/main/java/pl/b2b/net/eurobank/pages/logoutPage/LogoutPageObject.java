package pl.b2b.net.eurobank.pages.logoutPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPageObject {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public LogoutPageObject(WebDriver webDriver,WebDriverWait webDriverWait){
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = LogoutPageData.BUTTON_LOGOUT)
    private WebElement buttonLogout;

    @FindBy(xpath = LogoutPageData.BUTTON_LOGIN)
    private WebElement buttonLogin;

    private void clickToButtonLogout(){
        webDriverWait.until(ExpectedConditions.visibilityOf(buttonLogout));
        buttonLogout.click();
    }

    public boolean checkButtonLogin(){
        return buttonLogin.isDisplayed();
    }

    public void logoutOfTheSite(){
        clickToButtonLogout();
    }




}
