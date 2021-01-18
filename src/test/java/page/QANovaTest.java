package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import testSuite.Login;
import testSuite.RellenarCampos;
import testSuite.RellenarCampos2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class QANovaTest {

    public static void main(String[] args)
    {
        String url = "http://qanovagroup.com/piloto/";
        System.setProperty("webdriver.chrome.driver", "navegadorDriver/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        Login login = new Login();
        PageFactory.initElements(driver, login);
        driver.manage().window().maximize();
        driver.get(url);
        PageFactory.initElements(driver, login);
        login.Login("nvivas", "qanova");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        RellenarCampos2 rellenarCampos2 = new RellenarCampos2(driver);
        rellenarCampos2.RellenarCampos("Gabriel San Martin",
                                        "gsand","gsandaur@hotmail.com",
                                      "Testing 1","18/01/2021", "valor 1",
                                    "seleccion 3", "cr 2");
        /* RellenarCampos rellenarCampos = new RellenarCampos(); */

    }

}
