package testClases;

import Utils.ReadProperties;
import page.Login;
import page.MatrizInformacion;

public class Tarea2 {
    Login login;
    MatrizInformacion matrizInformacion;
    String usuario, clave;

    public void tareaNro2() throws InterruptedException {
        login = new Login();
        usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        login.ingresar(usuario, clave);
        matrizInformacion = new MatrizInformacion();
        matrizInformacion.validarDespliegue();
        matrizInformacion.ingresarMatriz();
        matrizInformacion.recuperarDatos("Leonardo");
    }
}
