package week2.day2assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.id("yes")).click();

		WebElement select = driver.findElement(By.xpath("(//input[@name=\"news\"])[2]"));
		if (select.isSelected()) {
			System.out.println("Default button selected is Checked");
		}
		WebElement age = driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[3]/div/div/input[2]");
		if (age.isSelected() == false) {
			age.click();
		} else {
			System.out.println("Age group is selected");
		}

	}

}
