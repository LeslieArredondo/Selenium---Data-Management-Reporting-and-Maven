package paquete1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

	
	@DataProvider(name="inputs")
	public Object [][] getData() {
		return new Object [][] {
			{"leslie0373@gmail.com"},
			{"leslieromi2@hotmail.com"},
			{"leslie9989@outlook.com"}
		};
	}
	
	@Test(dataProvider="inputs")
	public void sampleTest1(String input1) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver ();	
		driver.get("http://demo.automationtesting.in/");
		
		WebElement emailInputBox=driver.findElement(By.id("email"));
		
		
		WebElement submitButton = driver.findElement(By.id("enterimg"));
		
		emailInputBox.sendKeys(input1);
		submitButton.click();
		
		Thread.sleep(5000);
		
		WebElement firstNameInputBox = driver.findElement(By.xpath("//input[@placeholder='First Name']"));

		WebElement lastNameInputBox = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		
		WebElement genderCheckbox = driver.findElement(By.xpath("//input[@value='FeMale']"));
		
		firstNameInputBox.sendKeys("Leslie");
		lastNameInputBox.sendKeys("Arredondo");
		
		driver.close();
}}
