package testClases;

import page.QaNova.Descarga;

import java.awt.*;
import java.io.IOException;

public class DescargarArchivo {

    Descarga descarga;
    Robot robot;

    public void descargarClick() throws InterruptedException, IOException {
        descarga = new Descarga();
        descarga.validarDespliegue();
        descarga.descargarClick();
        Thread.sleep(5000);
        descarga.validarDescarga();
    }

    public void descargarSinClick() throws IOException, InterruptedException {
        descarga = new Descarga();
        descarga.validarDespliegue();
        descarga.descargarSinClick();
        Thread.sleep(15000);
        descarga.validarDescarga();
    }
}
