package week2.day2assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebElement index = driver.findElement(By.id("dropdown1"));
		Select drpdwn = new Select(index);
		drpdwn.selectByIndex(1);

		WebElement text = driver.findElement(By.name("dropdown2"));
		Select drpdwn1 = new Select(text);
		drpdwn1.selectByVisibleText("Loadrunner");

		WebElement value = driver.findElement(By.id("dropdown3"));
		Select drpdwn2 = new Select(value);
		drpdwn2.selectByValue("3");

		WebElement dropdown = driver.findElement(By.className("dropdown"));
		Select drpdwn3 = new Select(dropdown);
		int sizedrpdwn3 = drpdwn3.getOptions().size();
		System.out.println("The number of options are:" + sizedrpdwn3);

		driver.findElement(By.xpath("(//div[@class='example']/select)[5]")).sendKeys("Appium");

		driver.findElement(By.xpath("((//div[@class='example'][6])//option)[4]")).click();

	}

}
