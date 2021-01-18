package testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class RellenarCampos {
    ChromeDriver driver;
    WebElement cTexto;
    WebElement cMail;
    WebElement cAreaTexto;
    WebElement cFecha;
    WebElement cLista;

    @BeforeTest
    public void SetUp()
    {
        String url = "http://qanovagroup.com/piloto/";
        System.setProperty("webdriver.chrome.driver", "navegadorDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        driver.findElement(By.id("imUname")).sendKeys("nvivas");
        driver.findElement(By.id("imPwd")).sendKeys("qanova");
        driver.findElement(By.xpath("//input[@class='imLoginSubmit  btnCustomStyle  btnOptionStyle ']")).click();
    }
    @Test
    public void IngresaInfo()
    {
        System.out.println(cTexto);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        this.cTexto = driver.findElement(By.name("Campo_Texto"));
        this.cMail = driver.findElement(By.name("Campo_Mail"));
        this.cAreaTexto = driver.findElement(By.name("Campo_Area_de_Texto"));
        this.cFecha = driver.findElement(By.name("Campo_Fecha"));
        this.cTexto.sendKeys("Gabriel San Martin");
        this.cMail.sendKeys("mail");
        this.cAreaTexto.sendKeys("Testing");
        this.cFecha.sendKeys("18/01/2021");
    }

}
