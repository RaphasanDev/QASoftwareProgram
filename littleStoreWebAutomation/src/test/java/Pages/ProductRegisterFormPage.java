package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductRegisterFormPage {
    private WebDriver browser;

    public ProductRegisterFormPage(WebDriver browser) {
        this.browser = browser;
    }

    public ProductRegisterFormPage fillProductName(String name) {
        browser.findElement(By.id("produtonome")).sendKeys(name);
        return this;
    }

    public ProductRegisterFormPage fillProductValue(String value){
        browser.findElement(By.id("produtovalor")).sendKeys(value);
        return this;
    }

    public ProductRegisterFormPage fillProductColor(String color){
        browser.findElement(By.id("produtocores")).sendKeys(color);
        return this;
    }
    public ProductListPage submitFormWithWrongValue(){
        browser.findElement(By.cssSelector("button[type='submit']")).click();
        return new ProductListPage(browser);
    }
    public ProductEditionFormPage submitSuccessProductForm() {
        browser.findElement(By.cssSelector("button[type='submit']")).click();
        return new ProductEditionFormPage(browser);

    }
    public String captureMessage() {
        return browser.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
