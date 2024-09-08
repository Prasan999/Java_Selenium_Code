package parallelExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTestChrome {

	WebDriver driver;

	@Test(priority = 1)
	public void test1() throws InterruptedException {
		System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.bstackdemo.com/");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(), "StackDemo");
	}

	@Test(priority = 2)
	public void test2() throws InterruptedException {
		System.out.println("The thread ID for Chrome is "+ Thread.currentThread().getId());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(), "Google"); 
	}

	@AfterClass
	public void close() {
		driver.quit();
	} 
}