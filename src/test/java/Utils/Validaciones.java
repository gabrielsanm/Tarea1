package Utils;

import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Validaciones {

    public static void validarObjeto(WebElement elemento, String descripcionElemento) {
        WebDriverWait espera = new WebDriverWait(DriverContext.getDriver(), Integer.valueOf(ReadProperties.readFromConfig("propiedades.properties").getProperty("tiempoEsperaElementos")));
        String identificador;
        try {
            espera.until(ExpectedConditions.visibilityOf(elemento));
            identificador = elemento.getAttribute("xpath");
            if (identificador == null) {
                identificador = elemento.getAttribute("id");
            }
            System.out.println("Se despliega correctamente el elemento \"" + descripcionElemento + "\", identificador: " + identificador);
            PdfQaNovaReports.addWebReportImage("Validacion elemento "+descripcionElemento, "Se despliega correctamente el elemento \"" + descripcionElemento + "\", identificador: " + identificador, EstadoPrueba.PASSED, false);
        } catch (Exception e) {
            System.out.println("No se despliega el elemento \"" + descripcionElemento + "\"");
            PdfQaNovaReports.addWebReportImage("Validacion elemento "+descripcionElemento, "No se despliega el elemento \"" + descripcionElemento + "\"", EstadoPrueba.FAILED, false);
        }
    }

    public static void validarImagenes(WebElement imagenWeb, String rutaImagen) throws IOException {
        String rutaDeterminadaDescarga = "C:\\Users\\leona\\Downloads\\prueba.jpg";
        File salida = new File(rutaDeterminadaDescarga);
        if (!new File(rutaImagen).exists()){
            PdfQaNovaReports.addReport("Imagen a comparar", "La ruta entregada de la imagen a comparar no existe", EstadoPrueba.FAILED, true);
        }
        if (salida.exists()){
            salida.delete();
        }
        String src = imagenWeb.getAttribute("src");
        BufferedImage bufferedImage = ImageIO.read(new URL(src));
        ImageIO.write(bufferedImage, "jpg", salida);
        BufferedImage imagenEsperada = ImageIO.read(new File(rutaImagen));
        BufferedImage imagenActual = ImageIO.read(new File(rutaDeterminadaDescarga));
        if (imagenEsperada.getData().toString().equals(imagenActual.getData().toString())){
            PdfQaNovaReports.addReport("Comparacion de imagenes", "Las imagenes son iguales", EstadoPrueba.PASSED, false);
        } else {
            PdfQaNovaReports.addReport("Comparacion de imagenes", "Las imagenes son distintas", EstadoPrueba.FAILED, false);
        }
    }
}
