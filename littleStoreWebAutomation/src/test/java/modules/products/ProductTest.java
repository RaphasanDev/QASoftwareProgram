package modules.products;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Product Module Test")
public class ProductTest {
    private WebDriver browser;

    @BeforeEach
    public void beforeEach() {
        // Open the browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.browser = new ChromeDriver();

        //Maximize the page
        //browser.manage().window().maximize();

        //Setting a 5 seconds wait
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navigate to lojinha homepage
        browser.get("http://165.227.93.41/lojinha-web/v2");

    }


    @Test
    @DisplayName("Don't allow product value <= 0,00")
    public void notAllowedToRegisterProductValueUnderZero() {

        //Login
        browser.findElement(By.cssSelector("label[for='usuario']")).click();
        browser.findElement(By.id("usuario")).sendKeys("raphaelsan");
        browser.findElement(By.cssSelector("label[for='senha']")).click();
        browser.findElement(By.id("senha")).sendKeys("123456");
        browser.findElement(By.id("btn-entrar")).click();

        //Go to product registration page
        browser.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        //Fill product information and the value equals 0.00
        browser.findElement(By.id("produtonome")).sendKeys("Macbook Pro");
        browser.findElement(By.id("produtovalor")).sendKeys("0.00");
        browser.findElement(By.id("produtocores")).sendKeys("branco, preto");

        //Submit the form
        browser.findElement(By.cssSelector("button[type='submit']")).click();

        //Validate the error message
        String messageToast = browser.findElement(By.cssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", messageToast);
    }

    @AfterEach
    //Close the browser
    public void afterEach() {
        browser.quit();
    }
}