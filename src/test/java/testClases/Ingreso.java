package testClases;

import Utils.DriverContext;
import Utils.ReadProperties;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import page.QaNova.CargaInformacion;
import page.QaNova.Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ingreso {

    Login login;
    CargaInformacion cargaInformacion;
    String usuario, clave;

    public void exitoso() throws InterruptedException {
        login = new Login();
        login.validarDespliegue();
        usuario = ReadProperties.readFromConfig("propiedades.properties").getProperty("usuario");
        clave = ReadProperties.readFromConfig("propiedades.properties").getProperty("clave");
        login.ingresar(usuario, clave);
        cargaInformacion = new CargaInformacion();
        cargaInformacion.validarDespliegue();
    }

    public void erroneo() {
        login = new Login();
        login.ingresar("", "");
        login.validarMensajeError();
    }

    public void ingresoConJson() throws IOException {
        login = new Login();
        cargaInformacion = new CargaInformacion();
        String datos = "";
        String comparacion;
        BufferedReader br = new BufferedReader(new FileReader("C:\\git\\Tarea1\\src\\test\\resources\\usuarios.json"));
        while ((comparacion = br.readLine()) != null) {
            datos = datos + comparacion + "\n";
        }
        br.close();
        JsonObject jsonObject = new Gson().fromJson(datos, JsonObject.class);
        JsonArray jsonUsuarios = jsonObject.getAsJsonArray("usuario");
        String url = ReadProperties.readFromConfig("propiedades.properties").getProperty("web");
        JsonObject jsonArreglo;
        for (int x = 0; x < jsonUsuarios.size(); x++) {
            login.validarDespliegue();
            jsonArreglo = (JsonObject) jsonUsuarios.get(x);
            usuario = jsonArreglo.get("nombre").getAsString();
            clave = jsonArreglo.get("clave").getAsString();
            login.ingresar(usuario, clave);
            cargaInformacion.validarDespliegue();
            DriverContext.getDriver().navigate().to(url);
        }
    }
}
