package pl.b2b.net.eurobank.pages.formBankTransferPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormBankTransferObject {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public FormBankTransferObject(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = FormBankTransferData.SELECT_ACCOUNT)
    private WebElement selectAccount;
    @FindBy(xpath = FormBankTransferData.SELECT_SYMBOL_FORM)
    private WebElement selectSymbolForm;
    @FindBy(xpath = FormBankTransferData.SELECT_ID_TYPE)
    private WebElement selectIdType;
    @FindBy(xpath = FormBankTransferData.TEXTBOX_SETTLEMENT_PERIOD_YEAR)
    private WebElement textBoxSettlementPeriodYear;
    @FindBy(xpath = FormBankTransferData.SELECT_INTERVAL_TIME_SETTLEMENT_PERIOD)
    private WebElement selectIntervalTimeSettlementPeriod;
    @FindBy(xpath = FormBankTransferData.SELECT_SETTLEMENT_PERIOD_MONTH)
    private WebElement selectSettlementPeriodMonth;
    @FindBy(xpath = FormBankTransferData.SELECT_SETTLEMENT_PERIOD_DAY)
    private WebElement selectSettlementPeriodDay;
    @FindBy(xpath = FormBankTransferData.TEXTBOX_NAME_OF_THE_OFFICE)
    private WebElement textBoxNameOfTheOffice;
    @FindBy(xpath = FormBankTransferData.ACCOUNT_NUMBER_OF_THE_TAX_OFFICE)
    private WebElement accountNumberOfTheTaxOffice;
    @FindBy(xpath = FormBankTransferData.TEXTBOX_NAME_OF_THE_PAYER)
    private WebElement textBoxNameOfThePayer;
    @FindBy(xpath = FormBankTransferData.BUTTON_MORE_TEXTBOX)
    private WebElement additionalTextBoxPayer;
    @FindBy(xpath = FormBankTransferData.TEXTBOX_ADDRESS_STREET_PAYER)
    private WebElement textBoxAddressPayer;
    @FindBy(xpath = FormBankTransferData.TEXTBOX_ADDRESS_CITY_PAYER)
    private WebElement textBoxAddressCityPayer;
    @FindBy(xpath = FormBankTransferData.TEXTBOX_DOCUMENT_NUMBER)
    private WebElement textBoxDocumentNumber;
    @FindBy(xpath = FormBankTransferData.TEXTBOX_COMMITMENT_ID)
    private WebElement textBoxCommitmentId;
    @FindBy(xpath = FormBankTransferData.TEXTBOX_PRICE)
    private WebElement textBoxPrice;
    @FindBy(xpath = FormBankTransferData.BUTTON_NEXT)
    private WebElement nextButton;


    private void selectYourAccount(String account) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("form_account_from")));
        Select select = new Select(selectAccount);
        select.selectByVisibleText(account);
    }

    private void selectYourSymbolForm(String symbol) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("form_payment_symbol")));
        Select select = new Select(selectSymbolForm);
        select.selectByVisibleText(symbol);
    }

    private void enterTheCommitmentIdentifier(String idType){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("form_payment_symbol")));
        Select select = new Select(selectIdType);
        select.selectByVisibleText(idType);
    }

    private void enterTheSettlementYear(String year){
        webDriverWait.until(ExpectedConditions.visibilityOf(textBoxSettlementPeriodYear));
        textBoxSettlementPeriodYear.clear();
        textBoxSettlementPeriodYear.sendKeys(year);
    }

    private void enterTheSettlementPeriod(String period){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("form_period_type")));
        Select select = new Select(selectIntervalTimeSettlementPeriod);
        select.selectByVisibleText(period);
    }

    private void enterTheSettlementMonth(String month){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("form_period_month")));
        Select select = new Select(selectSettlementPeriodMonth);
        select.selectByVisibleText(month);
    }

    private void enterTheSettlementDay(String day){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("form_period_day")));
        Select select = new Select(selectSettlementPeriodDay);
        select.selectByVisibleText(day);
    }

    private void completeTheSettlementPeriod(String year,String period,String month,String day){
        enterTheSettlementYear(year);
        enterTheSettlementPeriod(period);
        enterTheSettlementMonth(month);
        enterTheSettlementDay(day);

    }

    private void enterTheOfficeName(String nameOffice){
        webDriverWait.until(ExpectedConditions.visibilityOf(textBoxNameOfTheOffice));
        textBoxNameOfTheOffice.sendKeys(nameOffice);
    }

    private void enterAccountNumberOfTheTaxOffice(String accountNumber){
        webDriverWait.until(ExpectedConditions.visibilityOf(accountNumberOfTheTaxOffice));
        accountNumberOfTheTaxOffice.sendKeys(accountNumber);
    }

    private void enterNameOfThePayer(String nameOfThePayer){
        webDriverWait.until(ExpectedConditions.visibilityOf(textBoxNameOfThePayer));
        textBoxNameOfThePayer.clear();
        textBoxNameOfThePayer.sendKeys(nameOfThePayer);
    }

    private void clickToAdditionalTextBoxPayer(){
        webDriverWait.until(ExpectedConditions.visibilityOf(additionalTextBoxPayer));
        additionalTextBoxPayer.click();
    }

    private void enterTheAddressPayer(String address){
        webDriverWait.until(ExpectedConditions.visibilityOf(textBoxAddressPayer));
        textBoxAddressPayer.clear();
        textBoxAddressPayer.sendKeys(address);
    }

    private void enterTheCityAddressPayer(String city){
        webDriverWait.until(ExpectedConditions.visibilityOf(textBoxAddressCityPayer));
        textBoxAddressCityPayer.clear();
        textBoxAddressCityPayer.sendKeys(city);
    }

    private void enterDocumentNumber(String number){
        webDriverWait.until(ExpectedConditions.visibilityOf(textBoxDocumentNumber));
        textBoxDocumentNumber.sendKeys(number);
    }

    private void enterCommitmentId(String commitmentId){
        webDriverWait.until(ExpectedConditions.visibilityOf(textBoxCommitmentId));
        textBoxCommitmentId.sendKeys(commitmentId);
    }

    private void enterPrice(String price){
        webDriverWait.until(ExpectedConditions.visibilityOf(textBoxPrice));
        textBoxPrice.sendKeys(price);
    }

    private void clickToButtonNext(){
        webDriverWait.until(ExpectedConditions.visibilityOf(nextButton));
        nextButton.click();
    }

    public void fillTheTransferForm(String account, String symbol,String idType,String year,String period,String month,
                                    String day,String nameOffice,String accountNumber,String nameOfThePayer,String address,
                                    String city,String number,String commitmentId,String price) {
        selectYourAccount(account);
        selectYourSymbolForm(symbol);
        enterTheCommitmentIdentifier(idType);
        completeTheSettlementPeriod(year,period,month,day);
        enterTheOfficeName(nameOffice);
        enterAccountNumberOfTheTaxOffice(accountNumber);
        enterNameOfThePayer(nameOfThePayer);
        clickToAdditionalTextBoxPayer();
        enterTheAddressPayer(address);
        enterTheCityAddressPayer(city);
        enterDocumentNumber(number);
        enterCommitmentId(commitmentId);
        enterPrice(price);
        clickToButtonNext();
    }


}
