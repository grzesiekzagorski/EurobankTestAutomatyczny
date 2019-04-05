package pl.b2b.net.eurobank.pages.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public LoginPageObject(WebDriver webDriver, WebDriverWait webDriverWait){
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = LoginPageData.ID_TEXTBOX)
    private WebElement idField;
    @FindBy(xpath = LoginPageData.NEXT_BUTTON)
    private WebElement nextButton;
    @FindBy(xpath = LoginPageData.LOGIN_PASSWORD)
    private WebElement passwordField;
    @FindBy(xpath = LoginPageData.SIGN_IN_BUTTON)
    private WebElement signInButton;
    @FindBy(xpath = LoginPageData.CUSTOMER_DATA)
    private WebElement customerDataView;


    private void enterTheId(String id){
        webDriverWait.until(ExpectedConditions.visibilityOf(idField));
        idField.sendKeys(id);
    }
    private void clickNextButton(){
        webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        nextButton.click();
    }
    private void enterThePassword(String password){
        webDriverWait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }
    private void clickSignInButton(){
        webDriverWait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }

    public boolean checkTheCorrectLogin(){
        webDriverWait.until(ExpectedConditions.visibilityOf(customerDataView));
        return customerDataView.isDisplayed();
    }

    public void logInToTheWebsite(String id,String password){
        enterTheId(id);
        clickNextButton();
        enterThePassword(password);
        clickSignInButton();
    }
}
