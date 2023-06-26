package week6.day6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccounts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// *_Create Accounts_*

		ChromeOptions options = new ChromeOptions();

		options.addArguments("disable-notifications", "Start-maximized");

		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

// 1. Login to https://login.salesforce.com 

		driver.get("https://login.salesforce.com");

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@1234");

		driver.findElement(By.xpath("//input[@id='Login']")).click();

// 2.Click on toggle menu button from the left corner

		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle')]")).click();

// 3. Click view All and click Sales from App Launcher

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		driver.findElement(By.xpath("//p[contains(@title,'Manage your sales')]")).click();

// 4. Click on Accounts tab 

		WebElement element1 = driver.findElement(By.xpath("//a/span[text()='Accounts']"));
		JavascriptExecutor executer1 = (JavascriptExecutor) driver;
		executer1.executeScript("arguments[0].click();", element1);

// 5. Click on New button 

		driver.findElement(By.xpath("//div[text()='New']")).click();

// 6.Enter 'your name' as account name 

		String name = "Phil Salt";

		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);

// 7. Select Ownership as Public

		WebElement element2 = driver.findElement(By.xpath("(//span[text()='--None--'])[3]"));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click();", element2);

		WebElement element3 = driver.findElement(By.xpath("//span[@Title='Public']"));
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", element3);

// 8. Click save and verify Account name "

		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		String verify = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();

		if (verify.equals(name)) {

			System.out.println(verify);

			System.out.println("Opportunity name is Verified");

		} else {

			System.out.println("Opportunity name is not Verified");
		}
	}

}
