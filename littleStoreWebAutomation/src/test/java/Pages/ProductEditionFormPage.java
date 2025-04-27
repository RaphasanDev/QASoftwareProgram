package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductEditionFormPage {
    WebDriver browser;

    public ProductEditionFormPage(WebDriver browser){
        this.browser = browser;
    }

    public String captureMessage() {
        return browser.findElement(By.cssSelector(".toast.rounded")).getText();
    }
}
