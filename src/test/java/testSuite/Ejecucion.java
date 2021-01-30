package testSuite;

import Utils.DriverContext;
import Utils.ReadProperties;
import constants.Navegador;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClases.Tarea1;

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
    public void tarea1() throws InterruptedException {
        Tarea1 tarea1 = new Tarea1();
        tarea1.tareaNro1();
    }
}
