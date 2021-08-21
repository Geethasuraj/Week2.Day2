package week2.day2assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.xpath("(//img[contains(@onclick,'window.')])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Images']")).click();

		WebElement image = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img"));
		if (image.getAttribute("href") == null) {
			System.out.println("The image is broken");
		} else {
			System.out.println("The image is not broken");
		}

		// click me using keyboard or mouse
		driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img"))
				.click();

	}

}
