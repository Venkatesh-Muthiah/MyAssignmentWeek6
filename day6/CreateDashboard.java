package week6.day6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateDashboard {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Create_Individuals

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

		// 3. Click view All and click Dashboard from App Launcher

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement element1 = driver.findElement(By.xpath("//p[text()='Dashboards']"));
		driver.executeScript("arguments[0].click();", element1);

		// 4. Click on New Dashboard button

		WebElement element2 = driver.findElement(By.xpath("//div[text()='New Dashboard']"));
		driver.executeScript("arguments[0].click();", element2);

		// 5.Enter Name as 'Salesforce Automation by *Your Name* ' and Click on Create.

		String name = "Alex";

		Thread.sleep(4000);

		WebElement nameField = driver
				.findElement(By.xpath("//label[@for='dashboardNameInput']/following-sibling::div"));

		System.out.println(nameField.isEnabled());

		nameField.sendKeys("Salesforce Automation by " + name + "");

		// 6.Click on Save and Verify Dashboard name."

		WebElement element3 = driver.findElement(By.xpath("//button[@id='submitBtn']"));
		driver.executeScript("arguments[0].click();", element3);

		String verify = driver.findElement(By.xpath("//span[contains(@class,'slds-form-element__static slds-grid')]"))
				.getText();

		if (verify.equals(name)) {

			System.out.println(verify);

			System.out.println("Dashboard name is Verified");

		} else {

			System.out.println("Dashboard name is not Verified");

		}
	}

}
