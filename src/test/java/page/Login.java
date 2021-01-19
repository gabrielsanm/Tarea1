package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    @FindBy(id = "imUname")
    WebElement txtUsuario;

    @FindBy(id = "imPwd")
    WebElement txtClave;

    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    WebElement btnIngresar;

    @FindBy(xpath = "//*[@id=\"dynObj_02\"]/p/a")
    WebElement linkCrearUsuario;

    public Login(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public void ingresar(String usuario, String clave){
        if (txtUsuario.isDisplayed()) {
            txtUsuario.sendKeys(usuario);
            txtClave.sendKeys(clave);
            btnIngresar.click();
        } else {
            System.out.println("No se encuentran los objetos esperados");
        }
    }
}
