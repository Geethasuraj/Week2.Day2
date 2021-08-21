package week2.day2assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		// Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click Login
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click Leads link
		driver.findElement(By.linkText("Leads")).click();

		// Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Click on Phone
		driver.findElement(By.linkText("Phone")).click();

		// Enter phone number
		WebElement code = driver.findElement(By.name("phoneCountryCode"));
		code.clear();
		code.sendKeys("23");

		driver.findElement(By.name("phoneAreaCode")).sendKeys("23");
		driver.findElement(By.name("phoneNumber")).sendKeys("9884025910");

		// Click find leads button
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Capture lead ID of First Resulting lead
		//Click First Resulting lead
		WebElement id = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]"));
		String text = id.getText();
		id.click();
		System.out.println(driver.getTitle());
		//Click Delete
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		
		//Click Find leads
		driver.findElementByLinkText("Find Leads").click();
		//Enter captured lead ID
		driver.findElementByXPath("//input[@name='id']").sendKeys(text);
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		WebElement display = driver.findElementByXPath("//div[text()='No records to display']");
		if (display.isDisplayed() == true) {
			System.out.println("No Records to display");
		}
		//Close the browser (Do not log out)
		driver.close();
	}

}
