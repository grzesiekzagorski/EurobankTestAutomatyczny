package pl.b2b.net.eurobank.pages.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class HomePageObject {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public HomePageObject(WebDriver webDriver, WebDriverWait webDriverWait){
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver,this);
    }

    @FindAll(@FindBy(xpath = HomePageData.PAYMENT_BUTTON))
    private List<WebElement> buttonsLeftMenu;

    @FindBy(xpath = HomePageData.BOOKMARK_US)
    private WebElement bookMarkUs;

    @FindBy(xpath = HomePageData.ACCOUNT_SELECT)
    private WebElement selectAccount;

    private void clickToPaymentsButton(){
        webDriverWait.until(ExpectedConditions.visibilityOf(buttonsLeftMenu.get(1)));
        buttonsLeftMenu.get(1).click();
        Assert.assertTrue(bookMarkUs.isDisplayed());
    }

    private boolean checkSelectAccountIsDisplayed(){
        return selectAccount.isEnabled();
    }

    private void clickOnBookMarkUs(){
        webDriverWait.until(ExpectedConditions.visibilityOf(bookMarkUs));
        bookMarkUs.click();
        Assert.assertTrue(checkSelectAccountIsDisplayed());
    }

    public void goToTheTransferForm(){
        clickToPaymentsButton();
        clickOnBookMarkUs();
    }


}
