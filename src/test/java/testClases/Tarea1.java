package testClases;

import org.openqa.selenium.WebDriver;
import page.Login;

import java.io.IOException;
import java.util.Properties;

public class Tarea1 {
    Login login;
    String usuario, clave;

    void inicarVariables() throws IOException {
        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("propiedades.properties"));
        
    }

    void tareaNro1(WebDriver webDriver){
        login = new Login(webDriver);
        login.ingresar();
    }
}
