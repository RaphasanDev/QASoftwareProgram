package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListPage {

    private WebDriver browser;

    public ProductListPage(WebDriver browser) {

        this.browser = browser;
    }

    public RegisterProductFormPage addProductForm(){
        browser.findElement(By.linkText("ADICIONAR PRODUTO")).click();
        return new RegisterProductFormPage(browser);
    }
    public String captureMessage(){
        return browser.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
