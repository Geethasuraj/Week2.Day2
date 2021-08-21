package week2.day2assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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

		// Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Geetha");

		// Click Find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();

		// Click on first resulting lead
		driver.findElement(By.xpath("//a[text()='VCS']")).click();
		// Verify title of the page
		System.out.println(driver.getTitle());
		// Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		// Change the company name
		WebElement name = driver.findElement(By.xpath("(//input[@class='inputBox'])[1]"));
		name.clear();
		name.sendKeys("Edit Company name");
		// Click Update
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		// Confirm the changed name appears
		WebElement cname = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		System.out.println(cname.getText());
		// Close the browser (Do not log out)
		driver.close();
	}

}
