package page.Prueba;

import Utils.DriverContext;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Resultado {

    @FindBy(xpath = "//*[@id=\"islrg\"]/div[1]/div[1]/a[1]/div[1]/img")
    WebElement webImage;

    @FindBy(xpath = "//*[@id=\"hdtb-msb\"]/div[1]/div/div[2]/a")
    WebElement spanImagenes;

    @FindBy(xpath = "//*[@id=\"Sva75c\"]/div/div/div[3]/div[2]/c-wiz/div/div[1]/div[1]/div/div[2]/a/img")
    WebElement imagenAmpliada;


    public Resultado(){
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void validarDespliegue(){
        Validaciones.validarObjeto(spanImagenes, "Span 'Imagenes'");
    }

    public void validarDespliegueImagenes(){
        Validaciones.validarObjeto(webImage, "Imagen de prueba");
    }

    public void cambiarSpan(){
        spanImagenes.click();
    }

    public void ampliarImagen(){
        webImage.click();
    }

    public void validarAmpliacion() throws InterruptedException {
        Validaciones.validarObjeto(imagenAmpliada, "Imagen Ampliada");
        Thread.sleep(10000);
    }

    public void compararImagen(String rutaImagen) throws IOException {
        Validaciones.validarImagenes(imagenAmpliada, rutaImagen);
    }
}
