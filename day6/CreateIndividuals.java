package week6.day6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateIndividuals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//Create_Individuals

		ChromeOptions options = new ChromeOptions();

		options.addArguments("disable-notifications", "Start-maximized");

		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

// 1. Login to https://login.salesforce.com 

		driver.get("https://login.salesforce.com");

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@1234");

		driver.findElement(By.xpath("//input[@id='Login']")).click();

// 2. Click on toggle menu button from the left corner

		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle')]")).click();

// 3. Click view All and click Individuals from App Launcher

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement element1 = driver.findElement(By.xpath("//p[text()='Individuals']"));

		driver.executeScript("arguments[0].click();", element1);

// 4. Click on New Individuals button 

		WebElement element2 = driver.findElement(By.xpath("(//a[@title='New'])[1]"));

		driver.executeScript("arguments[0].click();", element2);

// 5. Enter the Last Name as 'Kumar'

		String lastName = "Kumar";

		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);

// 6.Click save and verify Individuals Name

		WebElement element3 = driver.findElement(By.xpath("(//span[text()='Save'])[1]"));

		driver.executeScript("arguments[0].click();", element3);

		String verify = driver.findElement(By.xpath("//div[contains(@class,'slds-page-header__title slds')]/span"))
				.getText();

		if (verify.equals(lastName)) {

			System.out.println(verify);

			System.out.println("Individuals name is Verified");

		} else {

			System.out.println("Individuals name is not Verified");
		}
	}

}
