package week2.day2assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Complete all the 5 activities in Edit Page:
		// http://leafground.com/pages/Edit.html
		
		//Enter your email address
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("abc@gmail.com");
		
		//Append a text and press keyboard tab

		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("a text");
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys(Keys.TAB);
		
		
		//Get default text entered
		WebElement text = driver.findElement(By.xpath("//input[@value='TestLeaf']"));
		String enter = text.getAttribute("value");
		System.out.println("Default text is:" +enter);
		
		
		//Clear the text
		WebElement clear = driver.findElement(By.xpath("//input[@value='Clear me!!']"));
		clear.clear();
		
		
		//Confirm that edit field is disabled
		WebElement disable = driver.findElement(By.xpath("//input[@disabled='true']"));
		boolean actualValue = disable.isEnabled();

		if (actualValue) {
			System.out.println("Button is enabled");
		} else {
			System.out.println("Button is not enabled");
		}
	}

}
