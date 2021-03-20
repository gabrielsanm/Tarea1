package testClases;

import Utils.ReadProperties;
import page.CargaInformacion;
import page.Login;

public class CargaDeInformacion {
    Login login;
    CargaInformacion cargaInformacion;
    String usuario, clave;

    public void cargarDatos() throws InterruptedException {
        login = new Login();
        usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        login.ingresar(usuario, clave);
        cargaInformacion = new CargaInformacion();
        cargaInformacion.validarDespliegue();
        cargaInformacion.ingresarDatos("Leonardo Venegas", "q@q.cl", "Esta es una prueba automatizada", "30/01/2021", 2,3,1);
        cargaInformacion.presionarBotonEnviar();
    }
}
