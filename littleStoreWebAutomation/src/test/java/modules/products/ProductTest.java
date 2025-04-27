package modules.products;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductTest {

    @DisplayName("Product Module Test")
    @Test
    public void notAllowedToRegisterProductValueUnderZero() {
        // Open the browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver browser = new ChromeDriver();

        //Maximize the page
        browser.manage().window().maximize();

        //Navigate to lojinha homepage
        browser.get("http://165.227.93.41/lojinha-web/v2");

        //Login

        //Go to product registration page

        //Fill product information and the value equals 0.00

        //Submit the form

        //Validade the error message
    }
}
