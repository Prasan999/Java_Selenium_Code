package pageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.*;
//import browserStackPages.BrowserStackSignUpPage;

public class BrowserStackSetup {
	String driverPath=System.getProperty("user.dir")+"\\driver\\chromedriver.exe";
	WebDriver driver;
	BrowserStackHomePage objBrowserStackHomePage;
	//BrowserStackSignUpPage objBrowserStackSignUpPage;


	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserStack\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.browserstack.com/");
	}

	@Test(priority = 1)
	public void navigate_to_homepage_click_on_getstarted() {
		System.out.println("Executing Prority 1...Test");
		objBrowserStackHomePage = new BrowserStackHomePage(driver);
		objBrowserStackHomePage.veryHeader();
		objBrowserStackHomePage.clickOnGetStarted();
	}

	@Test(priority = 2)
	public void enter_userDetails() {

		System.out.println("Executing Prority 2...Test");
		/*
		 * objBrowserStackSignUpPage = new BrowserStackSignUpPage(driver);
		 * objBrowserStackSignUpPage.veryHeader();
		 * objBrowserStackSignUpPage.enterFullName("TestUser");
		 * objBrowserStackSignUpPage.enterBusinessEmail("TestUser@gmail.com");
		 * objBrowserStackSignUpPage.enterPasswrod("TestUserPassword");
		 */
	}
}