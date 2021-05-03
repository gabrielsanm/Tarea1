package page.Prueba;

import Utils.DriverContext;
import Utils.Reporte.EstadoPrueba;
import Utils.Reporte.PdfQaNovaReports;
import Utils.Validaciones;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google {

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")
    WebElement txtBuscador;

    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")
    WebElement btnBuscar;

    public Google(){
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void validarDespliegue(){
        Validaciones.validarObjeto(txtBuscador, "Barra de busqueda");
    }

    public void busqueda(String buscar){
        txtBuscador.sendKeys(buscar);
        PdfQaNovaReports.addWebReportImage("Introduccion de busqueda", "Se busca en google "+buscar, EstadoPrueba.PASSED, false);
    }

    public void presionarBuscar(){
        txtBuscador.sendKeys(Keys.ESCAPE);
        btnBuscar.click();
    }
}
