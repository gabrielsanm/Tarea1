package testClases;

import Utils.ReadProperties;
import page.CargaInformacion;
import page.Login;

public class Ingreso {

    Login login;
    CargaInformacion cargaInformacion;
    String usuario, clave;

    public void exitoso() throws InterruptedException {
        login = new Login();
        usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        login.ingresar(usuario, clave);
        cargaInformacion = new CargaInformacion();
        cargaInformacion.validarDespliegue();
    }

    public void erroneo(){
        login = new Login();
        login.ingresar("","");
        login.validarMensajeError();
    }
}
