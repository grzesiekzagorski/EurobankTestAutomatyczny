package pl.b2b.net.eurobank.pages.reportPage;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportPageObject {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public ReportPageObject(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(webDriver, this);
    }

    @FindAll(@FindBy(xpath = ReportPageData.FINAL_DATA))
    private List<WebElement> reportDataList;

    @FindBy(xpath = ReportPageData.TOKEN_CODE)
    private WebElement tokenCode;

    @FindBy(xpath = ReportPageData.TEXTBOX_TRANSFER_TOKEN)
    private WebElement textBoxTransferToken;

    @FindBy(xpath = ReportPageData.BUTTON_CONFIRM)
    private WebElement buttonConfirm;

    @FindBy(xpath = ReportPageData.TRANSACTION_STATUS)
    private WebElement transactionStatus;

    private void enterTransferToken(String token) {
        webDriverWait.until(ExpectedConditions.visibilityOf(textBoxTransferToken));
        textBoxTransferToken.sendKeys(token);
    }

    private void clickToButtonConfirm() {
        webDriverWait.until(ExpectedConditions.visibilityOf(buttonConfirm));
        buttonConfirm.click();
    }


    public List<String> downloadDataFromTheReport(String token, String excelPath) throws IOException {
        List<String> list = new ArrayList<>();
        for (WebElement webElement : reportDataList) {
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
            list.add(webElement.getText());
        }
        webDriverWait.until(ExpectedConditions.visibilityOf(tokenCode));
        list.add(tokenCode.getText());
        enterTransferToken(token);
        clickToButtonConfirm();
        webDriverWait.until(ExpectedConditions.visibilityOf(transactionStatus));
        list.add(transactionStatus.getText());
        writeDataToTheExcelFile(list, excelPath);
        return list;
    }

    private void writeDataToTheExcelFile(List<String> list, String excelPath) throws IOException {

        FileInputStream fis = new FileInputStream(excelPath);
        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.createRow(1);

        for (int i = 0; i < list.size(); i++) {
            row.createCell(i).setCellValue(list.get(i));
        }

        FileOutputStream fileOut = new FileOutputStream(excelPath);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }

}
