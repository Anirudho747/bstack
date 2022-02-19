package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/email_edit_text")
    @iOSXCUITFindBy(id = "test-Username")
    private MobileElement usernameTxtFld;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/password_edit_text")
    @iOSXCUITFindBy(id = "test-Password")
    private MobileElement passwordTxtFld;

    @AndroidFindBy(id = "xunison.com.smarthomeapp:id/login_button")
    @iOSXCUITFindBy(id = "test-LOGIN")
    private MobileElement loginBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
    private MobileElement errTxt;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.Toast")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
    private MobileElement msgTxt;

    public LoginPage enterUserName(String username) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(usernameTxtFld));
        e.clear();
        e.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(passwordTxtFld));
        e.clear();
        e.sendKeys(password);
        return this;
    }

    public LoginPage pressLoginBtn() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn)).click();
        return this;
    }

    public String getErrTxt() {
        return wait.until(ExpectedConditions.visibilityOf(errTxt)).getText();
    }

    public String msgTxt() {
        return wait.until(ExpectedConditions.visibilityOf(msgTxt)).getText();
    }



}
