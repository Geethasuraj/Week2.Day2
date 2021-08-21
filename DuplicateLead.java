package week2.day2assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
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
				
				//Click on Email
				driver.findElement(By.xpath("//span[text()='Email']")).click();
				//Enter Email
				driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("geethasuraj61@gmail.com");
				//Click find leads button
				driver.findElementById("ext-gen334").click();
				//Capture name of First Resulting lead
				
				
				WebElement name = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
				String text = name.getText();
				//Click First Resulting lead
				name.click();
				System.out.println(driver.getTitle());
				//Click Duplicate Lead
				driver.findElementByXPath("(//div[@class='frameSectionExtra'])[2]/a[1]").click();
				
				//Verify the title as 'Duplicate Lead'
				System.out.println("Title is:"+ driver.getTitle());
				//Click Create Lead
				
				driver.findElementByClassName("smallSubmit").click();
				//Confirm the duplicated lead name is same as captured name
				String text1 = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
				if (text.equals(text1)) {
					System.out.println("The lead is duplicate");
				}
				
				//Close the browser (Do not log out)
				
				driver.close();
	}

}
