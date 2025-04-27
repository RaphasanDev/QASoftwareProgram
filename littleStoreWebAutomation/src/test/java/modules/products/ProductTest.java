package modules.products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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
        //browser.manage().window().maximize();

        //Navigate to lojinha homepage
        browser.get("http://165.227.93.41/lojinha-web/v2");

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
}
