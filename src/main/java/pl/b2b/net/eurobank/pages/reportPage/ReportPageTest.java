package pl.b2b.net.eurobank.pages.reportPage;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pl.b2b.net.eurobank.cfg.SingletonWebDriver;

import java.io.IOException;

public class ReportPageTest {
    private ReportPageObject reportPageObject;

    @BeforeClass
    public void setUp(){
        reportPageObject = new ReportPageObject(SingletonWebDriver.getWebDriver(),SingletonWebDriver.getWait());
    }

    @Test
    @Parameters({"token","excelPath"})
    public void writeDataReportToExcelFile(String token,String excelPath) throws IOException {
        Assert.assertEquals(reportPageObject.downloadDataFromTheReport(token,excelPath).size(),10);
    }
}
