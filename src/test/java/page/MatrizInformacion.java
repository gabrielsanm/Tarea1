package page;

import Utils.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MatrizInformacion {
    @FindBy(xpath = "//*[@id=\"imMnMnNode4\"]/a/span/span/span[2]")
    WebElement spnMatrizDeInformacion;

    @FindBy(id = "pluginAppObj_4_01_filter_field")
    WebElement txtBusqueda;

    @FindBy(id = "pluginAppObj_4_01_filter_button")
    WebElement btnFiltro;

    @FindBy(id = "pluginAppObj_4_01_jtable")
    WebElement tblDatos;

    public MatrizInformacion() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void validarDespliegue() throws InterruptedException {
        /*while (segundos < 60){
            if(){
                break;
            } else {
                Wait 1000;
                segundos = segundos + 1;
            }
        }*/
        Thread.sleep(10000);
    }

    public void ingresarMatriz() {
        spnMatrizDeInformacion.click();
    }

    public void recuperarDatos(String busqueda) throws InterruptedException {
        txtBusqueda.sendKeys(busqueda);
        btnFiltro.click();
        Thread.sleep(5000);
        List<WebElement> filas = tblDatos.findElements(By.tagName("tr"));
        int cantFilas = filas.size();
        String id = "", texto = "", email = "", area = "", fecha = "", lista = "", seleccion = "", radio = "";
        for (int x = 1; x < cantFilas; x++) {
            List<WebElement> celdas = filas.get(x).findElements(By.tagName("td"));
            id = id + celdas.get(0).getText() + ";";
            texto = texto + celdas.get(1).getText() + ";";
            email = email + celdas.get(2).getText() + ";";
            area = area + celdas.get(3).getText() + ";";
            fecha = fecha + celdas.get(4).getText() + ";";
            lista = lista + celdas.get(5).getText() + ";";
            seleccion = seleccion + celdas.get(6).getText() + ";";
            radio = radio + celdas.get(7).getText() + ";";
        }
        System.out.println("*****DATOS RECUPERADOS*****");
        System.out.println("ID: "+"\n"+id);
        System.out.println("TEXTO: "+"\n"+texto);
        System.out.println("EMAIL: "+"\n"+email);
        System.out.println("AREA: "+"\n"+area);
        System.out.println("FECHA: "+"\n"+fecha);
        System.out.println("LISTA: "+"\n"+lista);
        System.out.println("SELECCION: "+"\n"+seleccion);
        System.out.println("RADIO: "+"\n"+radio);
        System.out.println("*****************************************************************************************");
    }
}
