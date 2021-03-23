package testSuite;

import Utils.DriverContext;
import Utils.ReadProperties;
import constants.Navegador;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClases.CargaDeArchivos;
import testClases.CargaDeInformacion;
import testClases.Ingreso;
import testClases.RecuperarInformacion;

public class Ejecucion {

    @BeforeTest
    public void setUp(){
        String url = ReadProperties.readFromConfig("propiedades.properties").getProperty("web");
        DriverContext.setUp(Navegador.Chrome, url);
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
}
