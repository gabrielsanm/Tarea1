package testSuite;

import Utils.Constants.Navegador;
import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Reporte.PdfQaNovaReports;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClases.*;

import java.io.IOException;

public class Ejecucion {

    @BeforeTest
    public void setUp(){
        String url = ReadProperties.readFromConfig("propiedades.properties").getProperty("web");
        DriverContext.setUp(Navegador.Chrome, url);
        PdfQaNovaReports.createPDF();
    }

    @AfterTest
    public void tearDown(){
        DriverContext.closeDriver();
    }

    @Test
    public void cargarDatos() throws InterruptedException {
        CargaDeInformacion cargaDeInformacion = new CargaDeInformacion();
        cargaDeInformacion.cargarDatos();
    }

    @Test
    public void recuperacionDeInformacion() throws InterruptedException {
        RecuperarInformacion recuperarInformacion = new RecuperarInformacion();
        recuperarInformacion.recuperacionConFiltro();
    }

    @Test
    public void recuperacionDeInformacion2() throws InterruptedException {
        RecuperarInformacion recuperarInformacion = new RecuperarInformacion();
        recuperarInformacion.recuperacionConFiltro2();
    }

    @Test
    public void loginExitoso() throws InterruptedException {
        Ingreso ingreso = new Ingreso();
        ingreso.exitoso();
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void loginErroneo(){
        Ingreso ingreso = new Ingreso();
        ingreso.erroneo();
    }

    @Test
    public void cargarArchivo(){
        CargaDeArchivos cargaDeArchivos = new CargaDeArchivos();
        cargaDeArchivos.cargar();
    }

    @Test
    public void descargarArchivoConClick() throws InterruptedException, IOException {
        DescargarArchivo descargarArchivo = new DescargarArchivo();
        descargarArchivo.descargarClick();
    }

    @Test
    public void descargarArchivoSinClick() throws IOException, InterruptedException {
        DescargarArchivo descargarArchivo = new DescargarArchivo();
        descargarArchivo.descargarSinClick();
    }

    @Test
    public void loginJson() throws IOException {
        Ingreso ingreso = new Ingreso();
        ingreso.ingresoConJson();
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void comparacion() throws IOException, InterruptedException {
        ComparacionDeImagenes comparacionDeImagenes = new ComparacionDeImagenes();
        comparacionDeImagenes.compararFerrari();
        PdfQaNovaReports.closePDF();
    }

    @Test
    public void comparacionFallida() throws IOException, InterruptedException {
        ComparacionDeImagenes comparacionDeImagenes = new ComparacionDeImagenes();
        comparacionDeImagenes.compararFerrariMal();
        PdfQaNovaReports.closePDF();
    }
}
