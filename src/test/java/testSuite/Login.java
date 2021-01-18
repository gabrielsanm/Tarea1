package testSuite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

    @FindBy(id = "imUname")
    WebElement usernameInput;

    @FindBy(id = "imPwd")
    WebElement pwdInput;

    @FindBy(xpath = "//input[@class='imLoginSubmit  btnCustomStyle  btnOptionStyle ']")
    WebElement loginButton;

    public void Login(String username, String password)
    {
        usernameInput.sendKeys(username);
        pwdInput.sendKeys(password);
        loginButton.click();
    }

}
