package testClases;

import Utils.ReadProperties;
import page.QaNova.CargaInformacion;
import page.QaNova.Login;
import page.QaNova.MatrizInformacion;

public class RecuperarInformacion {
    Login login;
    CargaInformacion cargaInformacion;
    MatrizInformacion matrizInformacion;
    String usuario, clave;

    public void recuperacionConFiltro() throws InterruptedException {
        login = new Login();
        usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        login.ingresar(usuario, clave);
        cargaInformacion = new CargaInformacion();
        cargaInformacion.validarDespliegue();
        matrizInformacion = new MatrizInformacion();
        matrizInformacion.ingresarMatriz();
        matrizInformacion.validarDespliegue();
        matrizInformacion.recuperarDatos(ReadProperties.readFromConfig("propiedades.properties").getProperty("filtro"));
    }

    public void recuperacionConFiltro2() throws InterruptedException {
        login = new Login();
        usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        login.ingresar(usuario, clave);
        matrizInformacion = new MatrizInformacion();
        matrizInformacion.validarDespliegue();
        matrizInformacion.ingresarMatriz();
        matrizInformacion.recuperarDatos2(ReadProperties.readFromConfig("propiedades.properties").getProperty("filtro"));
    }
}
