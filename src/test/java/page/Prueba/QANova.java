package page.Prueba;

import Utils.DriverContext;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class QANova {

    @FindBy(xpath = "//*[@id=\"menu\"]/div[1]/div/span/a/img")
    WebElement logoQaNova;

    public QANova(){
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void validarDespligue(){
        Validaciones.validarObjeto(logoQaNova, "Logo QA Nova");
    }

    public void compararImagenes(String ruta) throws IOException {
        Validaciones.validarImagenes(logoQaNova, ruta);
    }
}
