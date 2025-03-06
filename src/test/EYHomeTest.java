import dev.failsafe.internal.util.Durations;
import org.checkerframework.checker.optional.qual.RequiresPresent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@DisplayName("Validações do site da EY")
public class EYHomeTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.get("https://www.ey.com/pt_br");
        try {
            WebElement botaoCookie = navegador.findElement(By.id("onetrust-accept-btn-handler"));
            botaoCookie.click();
        } finally {

        }
    }


    @AfterEach
    public void afterEach() {

    }

    @Test
    void validaBotao() {
        WebElement botao = navegador.findElement(By.xpath("//*[@id=\"right-container\"]/div[2]/div/a[2]"));
        botao.click();
    }

    @Test
    void validarIdioma() {
        WebElement validar = navegador.findElement(By.xpath("//*[@id=\"right-container\"]/div[3]/div[1]/a"));
        validar.click();

        WebElement idioma = navegador.findElement(By.xpath("//*[@id=\"myData\"]/div[191]/a"));
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myData\"]/div[191]/a")));
        idioma.click();
        //codigo atualizado 2

    }
}



