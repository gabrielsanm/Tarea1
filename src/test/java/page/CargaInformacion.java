package page;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(id = "imObjectForm_1_6")
    WebElement lstLista;

    @FindBy(id = "imObjectForm_1_7_field")
    WebElement chckbxSeleccionMultiple;

    @FindBy(id = "imObjectForm_1_8_wrapper")
    WebElement rdbtnCombo;

    @FindBy(id = "imObjectForm_1_submit")
    WebElement btnEnviar;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_buttonswrap\"]/input[2]")
    WebElement btnReset;

    

    int segundos = 0;

    public CargaInformacion(){
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void validarDespliegue(){
        while (segundos < 60){
            if(txtTitulo.isDisplayed()){
                break;
            } else {
                segundos = segundos + 1;
            }
        }
    }

    public void validarErrorCorreo(){
        inpTexto.sendKeys();
    }
}
