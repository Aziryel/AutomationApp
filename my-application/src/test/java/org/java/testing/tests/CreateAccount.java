package org.java.testing.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class CreateAccount {
	
	public WebDriver driver;
	
	@Test
	
	public void CreateNewUserAccount() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rafael.adrian\\Documents\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		
		
		driver.get("http://automationpractice.com/index.php");
		driver.getTitle(); // => "My Store"
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

		driver.findElement(By.className("login")).click();

		driver.findElement(By.name("email_create")).sendKeys("oscar.cortez@test.com");;
		driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();;
		//driver.findElement(By.xpath("//*[contains(text(),'Create an account')]")).click();;

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[2]"));
		assertEquals(element.getText(), "Authentication");
		
		//*[@id="customer_firstname"]
		
		//Fill Personal Information
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.name("customer_firstname")).sendKeys("Oscar");
		driver.findElement(By.name("customer_lastname")).sendKeys("Cortez");
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("oscar.cortez@test.com");
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("Welcome1");

		Select dateOfBirthDay = new Select(driver.findElement(By.id("days")));
		dateOfBirthDay.selectByValue("15");

		Select dateOfBirthMonth = new Select(driver.findElement(By.id("months")));
		dateOfBirthMonth.selectByValue("6");

		Select dateOfBirthYear = new Select(driver.findElement(By.id("years")));
		dateOfBirthYear.selectByValue("1987");


		//Fill Address

		driver.findElement(By.id("firstname")).sendKeys("Oscar");
		driver.findElement(By.id("lastname")).sendKeys("Cortez");;
		driver.findElement(By.id("address1")).sendKeys("San Bernardo Ave");
		driver.findElement(By.id("address2")).sendKeys("Bob Bullock Loop");;
		driver.findElement(By.name("city")).sendKeys("Laredo");

		Select selectState = new Select(driver.findElement(By.name("id_state")));
		selectState.selectByIndex(42);

		driver.findElement(By.name("postcode")).sendKeys("78041");

		Select selectCountry = new Select(driver.findElement(By.name("id_country")));
		selectCountry.selectByValue("21");

		driver.findElement(By.id("other")).sendKeys("This is a Test");
		driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("956-718-2441");
		driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys("956-718-2441");
		driver.findElement(By.name("alias")).clear();
		driver.findElement(By.name("alias")).sendKeys("Bob Bullock Loop");

		driver.findElement(By.name("submitAccount")).click();




		driver.close();
		driver.quit();
	}

}
