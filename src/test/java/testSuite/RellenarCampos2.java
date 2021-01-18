package testSuite;

import org.apache.tools.ant.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class RellenarCampos2 {

    @FindBy(name = "Campo_Texto")
    WebElement cTexto;
    @FindBy(name = "Campo_Mail")
    WebElement cMail;
    @FindBy(name = "Campo_Area_de_Texto")
    WebElement cAreaTexto;
    @FindBy(name = "Campo_Fecha")
    WebElement cFecha;
    @FindBy(name = "Campo_Lista")
    WebElement cLista;
    @FindBy(id = "imObjectForm_1_7_wrapper")
    WebElement checkBoxWrapper;
    @FindBy(id = "imObjectForm_1_8_wrapper")
    WebElement radioButtonWrapper;
    @FindBy(id = "imObjectForm_1_submit")
    WebElement sendButton;
    Select lista;
    @FindBy(id = "imTip0")
    WebElement wrongPass;

    public RellenarCampos2(ChromeDriver driver)
    {
        PageFactory.initElements(driver, this);
        lista = new Select(this.cLista);
    }


    public void RellenarCampos(String cTexto, String cMail, String cMail2, String cATexto,
                               String cFecha, String seleccion, String cBoxOption,
                               String rButtonOption) //cMail es el mail incorrecto y cMail2 es el correcto
    {
        this.cTexto.sendKeys(cTexto);
        this.cMail.sendKeys(cMail);
        this.cAreaTexto.sendKeys(cATexto);
        this.cFecha.sendKeys(cFecha);
        this.lista.selectByValue(seleccion);

        //Captura todos los Checkbox de la seccion de RadioButton
        List<WebElement> cBoxSelecciones = this.checkBoxWrapper.findElements(By.tagName("input"));
        for(WebElement cBox : cBoxSelecciones)
        {   //Se quita el caracter especial y se coloca una o normal para la comparacion
            if(cBoxOption.equals(cBox.getAttribute("value").replaceAll("[^\\p{ASCII}]", "o")))
                cBox.click();
        }

        //Captura todos los rButton de la seccion de radioButton
        List<WebElement> rButtonSelecciones = this.radioButtonWrapper.findElements(By.tagName("input"));

        for(WebElement rButton : rButtonSelecciones)
        {
            if(rButtonOption.equals(rButton.getAttribute("value")))
                rButton.click();
        }

        sendButton.click();

        if(wrongPass.isDisplayed())
        {
            this.cMail.clear();
            this.cMail.sendKeys(cMail2);
            sendButton.click();
        }
    }


}
