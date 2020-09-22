package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.home;
import pages.buscarProductos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static support.screenshots.capturarEvidencia;



public class ventaZapatos {

    public static WebDriver driver;
	private static JavascriptExecutor js;
	private static home eshop;
	private static buscarProductos search;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		eshop = new home(driver);
		search = new buscarProductos(driver);
	}

	@Test
	public void buscarZapatos() {

		eshop.txtbuscarArticulos().sendKeys("shoes");
		eshop.btnBuscar().click();
		capturarEvidencia();
		js.executeScript("window.scrollBy(0,500)");

	}

	@Test(dependsOnMethods = {"buscarZapatos"})
	public void seleccionarMarca() {
		search.linkPuma().click();
		capturarEvidencia();
	}

	@Test(dependsOnMethods = {"seleccionarMarca"})
	public void seleccionarTalla() {
		search.talla10().click();
		capturarEvidencia();
	}

	@Test(dependsOnMethods = {"seleccionarTalla"})
	public void imprimirNumeroResultado() {
		System.out.println(search.numberOfResults().getText());
	}

	@Test(dependsOnMethods = {"imprimirNumeroResultado"})
	public void ordenarDeMayorAMenorPrecio() {
		search.cboBestResult().click();
		search.ordenarMayoraMenor().click();
		capturarEvidencia();
	}

	@Test(dependsOnMethods = {"ordenarDeMayorAMenorPrecio"})
	public void ImprimirProductosConPrecios() {

		System.out.println("1 Producto: " + search.TextoPrimerRe().getText() + " Precio: " + search.PrecioPrimerRe().getText());
		System.out.println("2 Producto: " + search.TextoSegunRe().getText() + " Precio: " + search.PrecioSegunRe().getText());
		System.out.println("3 Producto: " + search.TextoTercerRe().getText() + " Precio: " + search.PrecioTercerRe().getText());
		System.out.println("4 Producto: " + search.TextoCuartoRe().getText() + " Precio: " + search.PrecioCuartoRe().getText());
		System.out.println("5 Producto: " + search.TextoQuintoRe().getText() + " Precio: " + search.PrecioQuintoRe().getText());

	}

	@Test(dependsOnMethods = {"ordenarDeMayorAMenorPrecio"})
	public void OrdenarProductosNombre() {

		List<String> NombresProductos = new ArrayList();
		NombresProductos.add(search.TextoPrimerRe().getText());
		NombresProductos.add(search.TextoSegunRe().getText());
		NombresProductos.add(search.TextoTercerRe().getText());
		NombresProductos.add(search.TextoCuartoRe().getText());
		NombresProductos.add(search.TextoQuintoRe().getText());

		Collections.sort(NombresProductos);
		System.out.println("Ordenados por nombre de productos: ");
		System.out.println(NombresProductos + "\n");

	}

	@Test(dependsOnMethods = {"ordenarDeMayorAMenorPrecio"})
	public void OrdenarProductosPrecio() {
		String number1 = search.PrecioPrimerRe().getText();
		number1 = number1.substring(3);
		Double result1 = Double.parseDouble(number1.replace(" ", ""));

		String number2 = search.PrecioSegunRe().getText();
		number2 = number2.substring(3);
		Double result2 = Double.parseDouble(number2.replace(" ", ""));

		String number3 = search.PrecioTercerRe().getText();
		number3 = number3.substring(3);
		Double result3 = Double.parseDouble(number3.replace(" ", ""));

		String number4 = search.PrecioCuartoRe().getText();
		number4 = number4.substring(3);
		Double result4 = Double.parseDouble(number4.replace(" ", ""));

		String number5 = search.PrecioQuintoRe().getText();
		number5 = number5.substring(3);
		Double result5 = Double.parseDouble(number5.replace(" ", ""));

		List<Double> PreciosProductos = new ArrayList();
		PreciosProductos.add(result1);
		PreciosProductos.add(result2);
		PreciosProductos.add(result3);
		PreciosProductos.add(result4);
		PreciosProductos.add(result5);
		Collections.sort(PreciosProductos, Collections.reverseOrder());

		System.out.println("Ordenados por Precio: ");
		System.out.println(PreciosProductos + "\n");
	}


	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.close();
		}
	}

}
