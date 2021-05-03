package testClases;

import page.Prueba.Google;
import page.Prueba.QANova;
import page.Prueba.Resultado;

import java.io.IOException;

public class ComparacionDeImagenes {
    Google google;
    Resultado resultado;
    QANova qaNova;

    public void compararFerrari() throws IOException, InterruptedException {
        google = new Google();
        google.validarDespliegue();
        google.busqueda("Ferrari");
        google.presionarBuscar();
        resultado = new Resultado();
        resultado.validarDespliegue();
        resultado.cambiarSpan();
        resultado.validarDespliegueImagenes();
        resultado.ampliarImagen();
        resultado.validarAmpliacion();
        resultado.compararImagen("C:\\git\\Red_2019_Ferrari_SF90_Stradale_(48264238897)_(cropped).jpg");
    }

    public void compararFerrariMal() throws IOException, InterruptedException {
        google = new Google();
        google.validarDespliegue();
        google.busqueda("Ferrari");
        google.presionarBuscar();
        resultado = new Resultado();
        resultado.validarDespliegue();
        resultado.cambiarSpan();
        resultado.validarDespliegueImagenes();
        resultado.ampliarImagen();
        resultado.validarAmpliacion();
        resultado.compararImagen("C:\\git\\112037181-ade321bc-2a1b-4a66-952f-d845c44073e8.jpg");
    }

    public void compararImagenQaNova() throws IOException {
        qaNova = new QANova();
        qaNova.validarDespligue();
        qaNova.compararImagenes("C:\\git\\QANOVA_LOGO.png");
    }
}
