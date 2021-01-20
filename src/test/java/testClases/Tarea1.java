package testClases;

import Utils.ReadProperties;
import org.openqa.selenium.WebDriver;
import page.Login;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Tarea1 {
    Login login;
    String usuario, clave;

    void tareaNro1(WebDriver webDriver){
        login = new Login();
        usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        login.ingresar(usuario, clave);
    }
}
