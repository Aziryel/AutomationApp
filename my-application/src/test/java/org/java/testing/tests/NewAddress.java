package org.java.testing.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class NewAddress {

public WebDriver driver;
	
	@Test
	
	public void LogIn() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rafael.adrian\\Documents\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		
		driver.get("http://automationpractice.com/index.php");
		driver.getTitle(); // => "My Store"
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		driver.findElement(By.className("login")).click();
		
		driver.findElement(By.id("email")).sendKeys("maniacorp@maniacorpinc.com");
		driver.findElement(By.id("passwd")).sendKeys("maniacorp1");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		// Click on My Addresses
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/i")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		// Click on Add new address
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/a/span")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		// Make an assertion to make sure the desired page is open
		WebElement element = driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]"));
		assertEquals(element.getText(), "Your addresses");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		// Fill all the required fields to register a new address
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Mania");

		
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("Corp");
		
		driver.findElement(By.id("address1")).sendKeys("Mania Street");
		driver.findElement(By.id("city")).sendKeys("Hawaii");
		
		Select placeCity = new Select(driver.findElement(By.id("id_state")));
		placeCity.selectByValue("11");
		
		driver.findElement(By.id("postcode")).sendKeys("66666");
		
		Select placeCountry = new Select(driver.findElement(By.id("id_country")));
		placeCountry.selectByValue("21");
		
		driver.findElement(By.id("phone_mobile")).sendKeys("626422677");
		driver.findElement(By.id("alias")).clear();
		driver.findElement(By.id("alias")).sendKeys("ManiaCorpMain");
		
		// Click on the Save button to add the new address
		driver.findElement(By.xpath("//*[@id=\"submitAddress\"]/span")).click();
		
		
		//driver.close();
		//driver.quit();
	}
	
}
