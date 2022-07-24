package tests;

import manager.MyDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {

        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Test start with logout");
        }
    }

    @Test(dataProvider = "dataLogin",dataProviderClass = MyDataProvider.class)
    public void loginSuccess(String email,String password) {

        logger.info("Test start with email : "+email+" & password: "+password);

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(email, password);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in");
        logger.info("Test passed");

    }

    @Test
    public void loginSuccess2() {
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in");

    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOk();
    }



}
