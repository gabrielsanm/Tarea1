package page;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import Utils.Validaciones;
import org.openqa.selenium.By;
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


    public Login() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void ingresar(String usuario, String clave) {
        txtUsuario.sendKeys(usuario);
        txtClave.sendKeys(clave);
        btnIngresar.click();
        PdfQaNovaReports.addReport("Credenciales", "Se añaden las credenciales "+usuario+", "+clave+".", EstadoPrueba.PASSED, false);
    }

    public void validarMensajeError(){
        WebElement mensajeError = DriverContext.getDriver().findElement(By.xpath("//*[@id=\"imLoginPage\"]/div[3]/div"));
        Validaciones.validarObjeto(mensajeError, "Mensaje de error");
        System.out.println("Mensaje: "+mensajeError.getText());
        System.out.println("Color: "+mensajeError.getCssValue("color"));
    }
}
