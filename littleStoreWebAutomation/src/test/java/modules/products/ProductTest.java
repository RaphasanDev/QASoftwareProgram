package modules.products;

import Pages.LoginPage;
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
        String message = new LoginPage(browser)
                .fillUser("raphaelsan")
                .fillPassword("123456")
                .submitForm()
                .addProductForm()
                .fillProductName("Macbook Pro")
                .fillProductValue("00000")
                .fillProductColor("Branco, Preto, Amarelo")
                .submitFormWithWrongValue()
                .captureMessage();

        //Validate the error message
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", message);
    }

    @Test
    @DisplayName("Don't allow product value > 7000,00")
    public void notAllowedToRegisterProductValueAbove7k() {

        //Login
        String message = new LoginPage(browser)
                .fillUser("raphaelsan")
                .fillPassword("123456")
                .submitForm()
                .addProductForm()
                .fillProductName("Macbook Pro")
                .fillProductValue("7000001")
                .fillProductColor("Branco, Preto, Amarelo")
                .submitFormWithWrongValue()
                .captureMessage();

        //Validate the error message
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", message);
    }

    @Test
    @DisplayName("allow product value of 0,01")
    public void allowToRegisterProductValueOfOneCent() {

        //Login
        String message = new LoginPage(browser)
                .fillUser("raphaelsan")
                .fillPassword("123456")
                .submitForm()
                .addProductForm()
                .fillProductName("CheapestProduct")
                .fillProductValue("001")
                .fillProductColor("Branco, Preto, Amarelo")
                .submitSuccessProductForm()
                .captureMessage();

        //Validate the error message
        Assertions.assertEquals("Produto adicionado com sucesso", message);
    }
    @Test
    @DisplayName("allow product value of 7000,00")
    public void allowToRegisterProductValueOf7k() {

        //Login
        String message = new LoginPage(browser)
                .fillUser("raphaelsan")
                .fillPassword("123456")
                .submitForm()
                .addProductForm()
                .fillProductName("MostExpensiveProduct")
                .fillProductValue("700000")
                .fillProductColor("Branco")
                .submitSuccessProductForm()
                .captureMessage();

        //Validate the error message
        Assertions.assertEquals("Produto adicionado com sucesso", message);
    }

    @AfterEach
    //Close the browser
    public void afterEach() {
        browser.quit();
    }

}