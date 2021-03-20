package page;

import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CargaArchivos {

    @FindBy(xpath = "//*[@id=\"imMnMnNode6\"]/a/span/span/span[2]")
    WebElement spnCargaDeArchivos;

    @FindBy(id = "imObjectForm_1_2")
    WebElement inpArchivo;

    @FindBy(id = "imObjectForm_1_submit")
    WebElement btnEnviar;

    String archivo;

    public CargaArchivos() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void validarDespliegue() {
        Validaciones.validarObjeto(btnEnviar, "Boton Enviar");
    }

    public void ingresarACargaDeArchivos() {
        spnCargaDeArchivos.click();
    }

    public void cargarArchivo() {
        archivo = ReadProperties.readFromConfig("propiedades.properties").getProperty("archivo");
        inpArchivo.sendKeys(archivo);
        btnEnviar.click();
    }
}
