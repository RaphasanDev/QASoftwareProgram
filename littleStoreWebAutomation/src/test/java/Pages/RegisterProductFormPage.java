package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterProductFormPage {
    private WebDriver browser;

    public RegisterProductFormPage(WebDriver browser) {
        this.browser = browser;
    }

    public RegisterProductFormPage fillProductName(String name) {
        browser.findElement(By.id("produtonome")).sendKeys(name);
        return this;
    }

    public RegisterProductFormPage fillProductValue(String value){
        browser.findElement(By.id("produtovalor")).sendKeys(value);
        return this;
    }

    public RegisterProductFormPage fillProductColor(String color){
        browser.findElement(By.id("produtocores")).sendKeys(color);
        return this;
    }
    public ProductListPage submitFormWithWrongValue(){
        browser.findElement(By.cssSelector("button[type='submit']")).click();
        return new ProductListPage(browser);
    }
}
