package page;

import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Validaciones;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Descarga {

    @FindBy(xpath = "//*[contains(text(),'some-file.txt')]")
    WebElement btnDescarga;

    public Descarga() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void validarDespliegue() {
        Validaciones.validarObjeto(btnDescarga, "Boton de Descarga");
    }

    public void descargarClick() throws IOException {
        btnDescarga.click();
    }

    public void descargarSinClick() throws IOException {
        String link = btnDescarga.getAttribute("href");
        HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(link).openConnection());
        httpURLConnection.setRequestMethod("HEAD");
        httpURLConnection.connect();
    }

    public void validarDescarga() {
        String nombreArchivo = ReadProperties.readFromConfig("propiedades.properties").getProperty("directorioDescargas") + "\\" + btnDescarga.getText();
        System.out.println("BUSCANDO ARCHIVO " + nombreArchivo);
        File file = new File(nombreArchivo);
        if (file.exists()) {
            System.out.println("ARCHIVO " + nombreArchivo + " ENCONTRADO EN RUTA " + ReadProperties.readFromConfig("propiedades.properties").getProperty("directorioDescargas"));
        } else {
            System.out.println("ARCHIVO " + nombreArchivo + " NO !!! ENCONTRADO EN RUTA " + ReadProperties.readFromConfig("propiedades.properties").getProperty("directorioDescargas"));
        }
    }
}
