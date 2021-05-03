package testClases;

import Utils.ReadProperties;
import page.QaNova.CargaArchivos;
import page.QaNova.CargaInformacion;
import page.QaNova.Login;

public class CargaDeArchivos {

    Login login;
    CargaInformacion cargaInformacion;
    CargaArchivos cargaArchivos;
    String usuario,clave;

    public void cargar() {
        login = new Login();
        usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        login.ingresar(usuario, clave);
        cargaInformacion = new CargaInformacion();
        cargaInformacion.validarDespliegue();
        cargaArchivos = new CargaArchivos();
        cargaArchivos.ingresarACargaDeArchivos();
        cargaArchivos.validarDespliegue();
        cargaArchivos.cargarArchivo();
    }
}
