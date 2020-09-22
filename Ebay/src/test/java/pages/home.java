package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class home {
    WebDriver driver;

    public home(WebDriver driver) {
        this.driver = driver;
    }

    By txtbuscarArticulos = By.xpath("//input[@id='gh-ac']");
    By btnBuscar = By.xpath("//*[starts-with(@id,'gh-btn')]");

    public WebElement txtbuscarArticulos(){
        return driver.findElement(txtbuscarArticulos);
    }

    public WebElement btnBuscar(){
        return driver.findElement(btnBuscar);
    }



}
