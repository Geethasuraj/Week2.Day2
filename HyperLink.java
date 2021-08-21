package week2.day2assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Complete all the 5 activities in HyperLink Page:
		// http://leafground.com/pages/Link.html
		// Go to Home page
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();
		String home = driver.getCurrentUrl();
		System.out.println(home);
		driver.navigate().back();
		// Find where I am supposed to go without clicking me

		WebElement link = driver
				.findElement(By.xpath("//a[text()='Find where am supposed to go without clicking me?']"));

		System.out.println(link.getAttribute("href"));

		// verify am I broken.
		driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).click();
		String broken = driver.getTitle();
		System.out.println(broken);
		driver.navigate().back();

		// Interact with same link name
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]"));
		String home1 = driver.getCurrentUrl();

		if (home.equals(home1)) {
			System.out.println("Both links are same");
		}
		driver.navigate().back();

		// How many links are available in thispage
		int size = driver.findElements(By.tagName("a")).size();
		System.out.println("The number of links are: " + size);

	}

}
