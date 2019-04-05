package pl.b2b.net.eurobank.pages.formBankTransferPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pl.b2b.net.eurobank.cfg.SingletonWebDriver;

public class FormBankTransferTest {

    private FormBankTransferObject formBankTransferObject;

    @BeforeClass
    private void setUp(){
        formBankTransferObject = new FormBankTransferObject(SingletonWebDriver.getWebDriver(),SingletonWebDriver.getWait());
    }

    @Test
    @Parameters({"account","symbol","idType","year","period","month","day","nameOffice","accountNumber","nameOfThePayer",
            "address","city","number","commitmentId","price"})
    public void fillTheTransferFormTest(String account, String symbol,String idType,String year,String period,String month,
                                        String day, String nameOffice,String accountNumber,String nameOfThePayer,String address,
                                        String city,String number,String commitmentId,String price){
        formBankTransferObject.fillTheTransferForm(account,symbol,idType,year,period,month,day,nameOffice,accountNumber,
                nameOfThePayer,address,city,number,commitmentId,price);
    }
}
