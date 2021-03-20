package page;

import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Validaciones;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    @FindBy(id = "imUname")
    WebElement txtUsuario;

    @FindBy(id = "imPwd")
    WebElement txtClave;

    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    WebElement btnIngresar;

    @FindBy(xpath = "//*[@id=\"dynObj_02\"]/p/a")
    WebElement linkCrearUsuario;


    public Login() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void ingresar(String usuario, String clave) {
        txtUsuario.sendKeys(usuario);
        txtClave.sendKeys(clave);
        btnIngresar.click();
    }

    public void validarMensajeError(){
        WebElement mensajeError = DriverContext.getDriver().findElement(By.xpath("//*[@id=\"imLoginPage\"]/div[3]/div"));
        Validaciones.validarObjeto(mensajeError, "Mensaje de error");
        System.out.println("Mensaje: "+mensajeError.getText());
        System.out.println("Color: "+mensajeError.getCssValue("color"));
    }
}
