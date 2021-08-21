package week2.day2assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Complete all the 4 activities in Button Page:
		// http://leafground.com/pages/Button.html
		// Click button to travel home page
		driver.findElement(By.id("home")).click();
		driver.findElement(By.xpath("//img[@alt='Buttons']")).click();
		//driver.navigate().back();

		// Find position of button (x,y)
		WebElement position = driver.findElement(By.id("position"));
		Point point = position.getLocation();
		int x = point.getX();
		System.out.println("X axis:" + x);
		int y = point.getY();
		System.out.println("Y axis:" + y);

		// Find button color
		 String color = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("color is: " + color);

		// Find the height and width
		WebElement size = driver.findElement(By.id("size"));
		int height = size.getSize().getHeight();
		System.out.println("Height is: " + height);

		int width = size.getSize().getWidth();
		System.out.println("Width is:" + width);

	}

}
