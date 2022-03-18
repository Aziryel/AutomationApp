package org.java.testing.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddToCart {

public WebDriver driver;
	
	@Test
	
	public void LogIn() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rafael.adrian\\Documents\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		
		driver.get("http://automationpractice.com/index.php");
		driver.getTitle(); // => "My Store"
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		// HOver the mouse over the Dresses category
		Actions actions = new Actions(driver);
		WebElement dresses = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
		actions.moveToElement(dresses);

		// Click on the Evening Dresses category after hovering the mouse
		WebElement subMenuDresses = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[2]/a"));
		actions.moveToElement(subMenuDresses);
		actions.click().build().perform();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		Actions actions1 = new Actions(driver);
		WebElement ptrDress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img"));
		actions.moveToElement(ptrDress);

		WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span"));
		actions1.moveToElement(addToCart);
		actions1.click().build().perform();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		WebElement element = driver.findElement(By.className("navigation_page"));
		assertEquals(element.getText(), "Your shopping cart");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		WebElement element1 = driver.findElement(By.id("summary_products_quantity"));
		assertEquals(element1.getText(), "1 Product");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		// Click on Proceed to Checkout
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		// Log in to proceed with the checkout
		driver.findElement(By.id("email")).sendKeys("maniacorp@maniacorpinc.com");
		driver.findElement(By.id("passwd")).sendKeys("maniacorp1");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		
		// CLick on the Proceed to checkout button after logging in
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		// CLick on the checkbox to agree with the terms of service
		driver.findElement(By.id("cgv")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		// Click on the Proceed to checkout button
		driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		// Assert
		WebElement element2 = driver.findElement(By.className("navigation_page"));
		assertEquals(element2.getText(), "Your payment method");
		
		//Click on the payment method
		driver.findElement(By.className("cheque")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		WebElement element3 = driver.findElement(By.className("navigation_page"));
		assertEquals(element3.getText(), "Order confirmation");
		
		//driver.close();
		//driver.quit();
	}
}
