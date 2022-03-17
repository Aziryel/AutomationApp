package req7_BuyProduct;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC01_PaymentOptions_BankWire {

	
	@Test	
	public void PaymentOptionsBankwire() {
		//Crear el objeto Driver para poder trabajar en navegador
		System.setProperty("webdriver.chrome.driver", "C:\\bin\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//Ir a la pagina
		driver.get("http://automationpractice.com/index.php");
		driver.getTitle(); // => "My Store"
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
		
		//Logearse
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("ejemplo1.@hotmail.com");
		driver.findElement(By.id("passwd")).sendKeys("ejemplo1");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		driver.findElement(By.id("SubmitLogin")).click();
		
		//Meter producto al carrito
		driver.findElement(By.id("header_logo")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")).click();
		
		
		//Comienza el TC01_PaymentOptions_BankWire
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
		driver.findElement(By.name("processAddress")).click();
		driver.findElement(By.name("cgv")).click();
		driver.findElement(By.name("processCarrier")).click();
		driver.findElement(By.className("bankwire")).click();
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
		
		
		//driver.close();
		//driver.quit();
		
	}
	
	
}
