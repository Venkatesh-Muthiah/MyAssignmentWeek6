package week6.day6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateOpportunity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//*_Assignment for this WeekEnd_*
//*_Create Oppurtunity_*

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

// 3. Click view All and click Sales from App Launcher

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		driver.findElement(By.xpath("//p[contains(@title,'Manage your sales')]")).click();

// 4. Click on Opportunities tab

		WebElement element1 = driver.findElement(By.xpath("//a/span[text()='Opportunities']"));
		JavascriptExecutor executer1 = (JavascriptExecutor) driver;
		executer1.executeScript("arguments[0].click();", element1);

// 5. Click on New button 

		driver.findElement(By.xpath("//div[text()='New']")).click();

// 6. Enter Opportunity name as 'Salesforce Automation by *YourName*,Get the text and Store it

		String name = "Phil Salt";

		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);

// 7. Choose close date as Today 

		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("06/25/2023");

// 8. Select 'Stage' as Needs Analysis

		driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds')])[1]")).click();

		WebElement element2 = driver.findElement(By.xpath("//span[@Title='Needs Analysis']"));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click();", element2);

// 9. click Save and VerifyOppurtunity Name"

		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		String verify = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();

		if (verify.equals(name)) {

			System.out.println(verify);

			System.out.println("Opportunity name is Verified");

		} else {

			System.out.println("Opportunity name is not Verified");
		}
	}

}
