package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;

public class buscarProductos {
    WebDriver driver;

    public buscarProductos(WebDriver driver) {
        this.driver = driver;
    }

    By txtboxBrand = By.xpath("//input[@id='w4-w12-0[0]']");
    By linkPuma = By.xpath("//span[contains(text(),'PUMA')]");
    By size10 = By.xpath("//body[@class='s-page no-touch skin-large srp--grid-view no-touch skin-large gh-flex']/div[@class='srp-main srp-main--isLarge']/div[@class='srp-rail__left']/ul[@id='s0-14-11-0-1-2-6']/li/ul[@class='x-refine__left__nav']/li/ul[@class='x-refine__left__nav']/li[contains(@class,'x-refine__main__list')]/div[@id='x-refine__group_1__0']/ul[@class='x-refine__main__value']/li[4]/div[1]/a[1]/div[1]/div[1]/span[1]");
    By numberOfResults = By.xpath("//h1[@class='srp-controls__count-heading']");
    By cboBestResult = By.xpath("//span[contains(text(),'Mejor resultado')]");
    By oderByHighestToLowest = By.linkText("Precio + Envío: más alto primero");
    By textoPrimerRe = By.xpath("(//*[@class='s-item__title'])[1]");
    By precioPrimerRe = By.xpath("(//*[@class='s-item__price'])[1]");
    By textoSegunRe = By.xpath("(//*[@class='s-item__title'])[2]");
    By precioSegunRe = By.xpath("(//*[@class='s-item__price'])[2]");
    By textoTercerRe = By.xpath("(//*[@class='s-item__title'])[3]");
    By precioTercerRe = By.xpath("(//*[@class='s-item__price'])[3]");
    By textoCuartoRe = By.xpath("(//*[@class='s-item__title'])[4]");
    By precioCuartoRe = By.xpath("(//*[@class='s-item__price'])[4]");
    By textoQuintoRe = By.xpath("(//*[@class='s-item__title'])[5]");
    By precioQuintoRe = By.xpath("(//*[@class='s-item__price'])[5]");

    public WebElement TextoPrimerRe() {
        return driver.findElement(textoPrimerRe);
    }

    public WebElement TextoSegunRe() {
        return driver.findElement(textoSegunRe);
    }

    public WebElement TextoTercerRe() {
        return driver.findElement(textoTercerRe);
    }

    public WebElement TextoCuartoRe() {
        return driver.findElement(textoCuartoRe);
    }

    public WebElement TextoQuintoRe() {
        return driver.findElement(textoQuintoRe);
    }

    public WebElement PrecioPrimerRe() {
        return driver.findElement(precioPrimerRe);
    }

    public WebElement PrecioSegunRe() {
        return driver.findElement(precioSegunRe);
    }

    public WebElement PrecioTercerRe() {
        return driver.findElement(precioTercerRe);
    }

    public WebElement PrecioCuartoRe() {
        return driver.findElement(precioCuartoRe);
    }

    public WebElement PrecioQuintoRe() {
        return driver.findElement(precioQuintoRe);
    }

    public WebElement ordenarMayoraMenor() {
        return driver.findElement(oderByHighestToLowest);
    }

    public WebElement cboBestResult() {
        return driver.findElement(cboBestResult);

    }

    public WebElement numberOfResults() {
        return driver.findElement(numberOfResults);
    }

    public WebElement talla10() {
        return driver.findElement(size10);
    }
    public WebElement linkPuma() {
        return driver.findElement(linkPuma);
    }

}
