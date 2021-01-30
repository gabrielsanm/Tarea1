package page;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class CargaInformacion {

    @FindBy(id = "imPgTitle")
    WebElement txtTitulo;

    @FindBy(id = "imObjectForm_1_2")
    WebElement inpTexto;

    @FindBy(id = "imObjectForm_1_3")
    WebElement inpCorreo;

    @FindBy(id = "imObjectForm_1_4")
    WebElement inpArea;

    @FindBy(id = "imObjectForm_1_5")
    WebElement dtFecha;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_6\"]")
    WebElement lstLista;

    @FindBy(id = "imObjectForm_1_7_0")
    WebElement chckbxSeleccionMultiple1;

    @FindBy(id = "imObjectForm_1_7_1")
    WebElement chckbxSeleccionMultiple2;

    @FindBy(id = "imObjectForm_1_7_2")
    WebElement chckbxSeleccionMultiple3;

    @FindBy(id = "imObjectForm_1_8_0")
    WebElement rdbtnCombo1;

    @FindBy(id = "imObjectForm_1_8_1")
    WebElement rdbtnCombo2;

    @FindBy(id = "imObjectForm_1_8_2")
    WebElement rdbtnCombo3;

    @FindBy(id = "imObjectForm_1_submit")
    WebElement btnEnviar;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_buttonswrap\"]/input[2]")
    WebElement btnReset;

    int segundos = 0;

    public CargaInformacion(){
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

    public void ingresarDatos(String texto, String correo, String area, String fecha, int lista, int checkBox, int radioButton){
        Select select = new Select(lstLista);
        inpTexto.sendKeys(texto);
        inpCorreo.sendKeys(correo);
        inpArea.sendKeys(area);
        dtFecha.sendKeys(fecha);
        String list = "valor ".concat(String.valueOf(lista));
        select.selectByVisibleText(list);
        switch (checkBox){
            case 1:
                chckbxSeleccionMultiple1.click();
                break;
            case 2:
                chckbxSeleccionMultiple2.click();
                break;
            case 3:
                chckbxSeleccionMultiple3.click();
                break;
            default:
                System.out.println("Opcion no valida");
        }
        switch (radioButton){
            case 1:
                rdbtnCombo1.click();
                break;
            case 2:
                rdbtnCombo2.click();
                break;
            case 3:
                rdbtnCombo3.click();
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }

    public void presionarBotonEnviar(){
        btnEnviar.click();
    }
}
