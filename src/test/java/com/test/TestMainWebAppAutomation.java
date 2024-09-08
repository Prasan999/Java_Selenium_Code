package com.test;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.common.base.Verify;
import com.utilities.Excel;

import java.io.BufferedWriter; 
import java.io.File; 
import java.io.FileWriter;
import java.util.Set;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;

public class TestMainWebAppAutomation {


	private WebDriver driver;
	private String baseUrl;
	public String url ="https://the-internet.herokuapp.com";
	private WebElement element;
	public String driverPath=System.getProperty("user.dir")+"\\driver\\chromedriver.exe";

	//@BeforeMethod
	public void setUp() throws Exception {

		String url = "https://the-internet.herokuapp.com";

		System.setProperty("webdriver.chrome.driver", 
				driverPath);  

		// Instantiate a ChromeDriver class.     
		driver=new ChromeDriver();  
		// Launch Website  
		driver.navigate().to(url);  
		System.out.println("Window Title"+ driver.getTitle());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String title = "The Internet";
		//Maximize the browser  
		driver.manage().window().maximize(); 
		Wait(2000);

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}


	@Test
	public void launchBrowser() {
		try {

			//setUp();
			//closeBrowser();
			// System Property for Chrome Driver   
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * ddriverPathriverPath
			 * );
			 * 
			 * // Instantiate a ChromeDriver class. WebDriver driver=new ChromeDriver();
			 * String url = "https://the-internet.herokuapp.com"; // Launch Website
			 * driver.navigate().to(url); System.out.println("Window Title"+
			 * driver.getTitle());
			 * 
			 * String title = "The Internet"; //Maximize the browser
			 * driver.manage().window().maximize(); Wait(2000); assertEquals(title,
			 * driver.getTitle()); driver.close();
			 */
		} catch (Exception e) {

			closeBrowser();

		}

	}


	@Test
	public void alert() {

		// Read Material : https://www.browserstack.com/guide/alerts-and-popups-in-selenium


		System.setProperty("webdriver.chrome.driver", 
				driverPath);  

		// Instantiate a ChromeDriver class.     
		WebDriver driver=new ChromeDriver();  
		String url = "https://the-internet.herokuapp.com";
		// Launch Website  
		driver.get(url);  
		System.out.println("Window Title"+ driver.getTitle());
		driver.findElement(By.xpath("//a[text()='JavaScript Alerts']")).click();
		Wait(2000);

		/*
		 * //1. TO click on JS ALert
		 * driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click()
		 * ; driver.switchTo().alert().accept(); Wait(5000); String expected =
		 * "You successfully clicked an alert"; String actual =
		 * driver.findElement(By.xpath("//h4[text()='Result:']//following::p")).getText(
		 * ); assertEquals(expected,actual);
		 * 
		 * //2. TO click on JS ALert- Accept
		 * driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click
		 * (); driver.switchTo().alert().accept(); Wait(5000); String expected1 =
		 * "You clicked: Ok"; String actual1 =
		 * driver.findElement(By.xpath("//h4[text()='Result:']//following::p")).getText(
		 * ); assertEquals(expected1,actual1);
		 * 
		 * //3. TO click on JS ALert- dismiss
		 * driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click
		 * (); driver.switchTo().alert().dismiss(); Wait(5000); String expected2 =
		 * "You clicked: Cancel"; String actual2 =
		 * driver.findElement(By.xpath("//h4[text()='Result:']//following::p")).getText(
		 * ); assertEquals(expected2,actual2);
		 */

		// 4. TO Enter text in Alertbox

		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		String value = "Hello World...";
		driver.switchTo().alert().sendKeys(value);
		driver.switchTo().alert().accept();
		Wait(5000);
		String actual3 = driver.findElement(By.xpath("//h4[text()='Result:']//following::p")).getText();
		assertEquals("You entered: "+value,actual3);

		driver.quit();

	}

	@Test
	public void windowHandle() {
		// System Property for Chrome Driver   
		System.setProperty("webdriver.chrome.driver", 
				driverPath);  

		// Instantiate a ChromeDriver class.     
		driver=new ChromeDriver();  
		String windowToSwitch ="The Internet";
		String url = "https://the-internet.herokuapp.com";
		// Launch Website  
		driver.get(url);  
		//Maximize the browser  
		driver.manage().window().maximize(); 
		Wait(2000);
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		Wait(2000);
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Wait(2000);
		String parentWindow = driver.getWindowHandle();
		HashMap<String,String> windowTitle = new HashMap<String, String>();

		Set <String> windowHandles = driver.getWindowHandles();
		Iterator<String> itr = windowHandles.iterator();
		while(itr.hasNext()) {
			String windowID = itr.next();
			driver.switchTo().window(windowID);
			windowTitle.put(driver.getTitle(), windowID);

		}

		for(Map.Entry<String, String> map:windowTitle.entrySet() ) {
			if(map.getKey().equals(windowToSwitch))
				driver.switchTo().window(map.getValue());
		}

		/*
		 * for (String s : windowHandles ) { driver.switchTo().window(s); String title =
		 * driver.getTitle(); System.out.println(title);
		 * 
		 * }
		 */
		System.out.println(windowHandles);
		driver.quit();
	}


	public void Wait(long millisecs ) {

		Thread thread = new Thread();
		try {
			thread.sleep(millisecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void selectElementByCSSSelector() {

		try{
			// System Property for Chrome Driver   
			System.setProperty("webdriver.chrome.driver", 
					driverPath);  

			// Instantiate a ChromeDriver class.     
			driver=new ChromeDriver();  
			String url = "https://the-internet.herokuapp.com";
			// Launch Website  
			driver.navigate().to(url);  
			//Maximize the browser  
			driver.manage().window().maximize(); 
			Wait(2000);
			driver.findElement(By.xpath("//a[text()='Dynamic Content']")).click();
			Wait(2000);
			// by xpath
			//	String s = driver.findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
			// by CSS selector
			List <WebElement> webelements = driver.findElements(By.cssSelector("div[class='large-10 columns']"));
			String s=  webelements.get(webelements.size()-1).getText();
			System.out.println(s);

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("EXCEPTION BLOCK.... ");
		}

	}


	@Test
	public void tableTraverse () {

		System.setProperty("webdriver.chrome.driver", 
				driverPath);  

		// Instantiate a ChromeDriver class.     
		WebDriver driver=new ChromeDriver();  
		String url = "https://the-internet.herokuapp.com";
		// Launch Website  
		driver.navigate().to(url);  
		//Maximize the browser  
		driver.manage().window().maximize(); 
		Wait(2000);
		driver.findElement(By.xpath("//a[text()='Sortable Data Tables']")).click();
		Wait(2000);

		WebElement table = driver.findElement(By.xpath("//table[@id='table1']")); 
		List<WebElement> rows = table.findElements(By.xpath("//table[@id='table1']//tr"));
		for (int i=1;i<rows.size();i++){
			i++;
			String xpath = "((//table[@id='table1']//tr)["+i+"])//td";
			i--;
			List<WebElement> cells = rows.get(i).findElements(By.xpath(xpath));


			for (WebElement cell : cells) {
				System.out.println(cell.getText());
				if(cell.getText().equals("$51.00")){
					System.out.println("Value found"+cell.getText());
					break;

				}

			}
		}driver.quit();
	}

	@Test
	public void hiddenMethodELmenents() {
		System.setProperty("webdriver.chrome.driver", 
				driverPath);  

		// Instantiate a ChromeDriver class.     
		WebDriver driver=new ChromeDriver();  
		String url = "https://www.letskodeit.com/practice";
		// Launch Website  
		driver.navigate().to(url);  
		//Maximize the browser  
		driver.manage().window().maximize(); 
		Wait(2000);
		driver.findElement(By.name("show-hide")).sendKeys("Welcome world......");
		Wait(2000);
		driver.findElement(By.id("hide-textbox")).click();
		Wait(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String str = (String) executor.executeScript("return document.getElementById('displayed-text').value");
		System.out.println(str);

		driver.quit();
	}


	@Test
	public void waitMethods() {

		try{
			// System Property for Chrome Driver   
			System.setProperty("webdriver.chrome.driver", 
					driverPath);  

			// Instantiate a ChromeDriver class.     
			WebDriver driver=new ChromeDriver();  
			String url = "https://the-internet.herokuapp.com";
			// Launch Website  
			driver.navigate().to(url);  
			//Maximize the browser  
			driver.manage().window().maximize(); 
			wait(10000);

		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("waitMethods EXCEPTION BLOCK.... ");
		}
	}

	//wait
	@Test
	public void implictWait() {


		try{
			// System Property for Chrome Driver   
			System.setProperty("webdriver.chrome.driver", 
					driverPath);  

			// Instantiate a ChromeDriver class.     
			WebDriver driver=new ChromeDriver();  
			String url = "https://the-internet.herokuapp.com";
			// Launch Website  
			driver.navigate().to(url);  
			//Maximize the browser  
			driver.manage().window().maximize(); 
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		}

		catch(Exception e) {

		}
	}




	// JAVA PROGRAMS 

	@Test 
	public void javaProgram() {

		String s = "Hello World" ;
		//Returns the character at the specified index.
		System.out.println(s.charAt(4));
		//Returns the index within the string of the first occurrence of a specified character or substring.
		System.out.println(s.indexOf("W"));
		String s1 = "Next|Thing|Next|World" ;
		//Converts the string to a character array.
		System.out.println(s1.toCharArray());
		String s2[]= s1.split("|");
		System.out.println(s2);
		String s3Split[] = s1.split("|", 1);
		System.out.println("s3Split[]"+ s3Split.length);

	}


	//Program to replace the "Test2" with string "ReplacedTest"
	@Test
	public void replaceStringInArrayList() {

		ArrayList<String> list = new ArrayList<String>();
		list.add("Apple");
		list.add("Test2");
		list.add("Grapes");
		list.add("Vanilla");
		list.add("Vanilla");// list will allow duplicates
		System.out.println("ArrayList Before replace"+list);

		int index =  list.indexOf("Test2");
		list.set(index, "Mango");

		System.out.println("ArrayList After replace"+list);
	}

	@Test
	public void hashMapIterator() {

		HashMap<String,String> hash_map = new HashMap<String, String>();

		hash_map.put("India", "New Delhi");
		hash_map.put("France", "Paris");
		hash_map.put("Germany", "Berlin");
		hash_map.put("Australia", "Canberra");

		Iterator<String> itr =  hash_map.keySet().iterator();
		while(itr.hasNext()) {

			String key = itr.next();
			String value = hash_map.get(key);
			System.out.println("key: " + key + "==>" + "value: " + value);
		}


	}


	//	The "throw" keyword is used to throw an exception
	@Test
	public void throwMethod() {

		try {
			int dividend = 10;int divisor =0 ; 

			int  res = calculate(dividend,divisor );
			System.out.println("Result+++...."+res);

		}catch(ArithmeticException e) {

			System.out.println("Error: " + e.getMessage());

		}

	}

	public int calculate(int dividend, int divisor)  {

		if (divisor == 0 || dividend == 0) {
			throw new ArithmeticException("divisor/dividend cannot be zero.");
		}
		return dividend / divisor;

	}

	//The "throws" keyword is used to declare exceptions. 
	//It specifies that there may occur an exception in the method. 
	//It doesn't throw an exception. It is always used with method signature.
	@Test
	public void throwsMethod() {

		int dividend = 10;
		int divisor = 0;

		try {

			int result = divide(dividend, divisor);
			System.out.println("Result: " + result);

		} catch (ArithmeticException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public int divide(int dividend, int divisor) throws ArithmeticException {

		if (divisor == 0 || dividend == 0) {
			throw new ArithmeticException("divisor/dividend cannot be zero.");
		}
		return dividend / divisor;

	}

	// Listeners  in TestNG
	//prority in TestNG

	// data provider in TestNG
	@Test(dataProvider = "getData")
	public void testTDD(String name, String mail , String password ) {

		System.out.println("Name: "+name+"Mail:"+"Password: "+password);
	}


	@DataProvider
	public String[][] getData() {

		String filename = "C:\\Users\\hp\\Desktop\\Eclipse_workspace\\Java_Selenium_Code\\others\\UserLogin.xls";
		String data[][] = Excel.get(filename);
		System.out.println(data);

		return data ;

	}


	@Test
	public void readExcel() {
		String filename = "C:\\Users\\hp\\Desktop\\Eclipse_workspace\\Java_Selenium_Code\\others\\UserLogin.xls";
		String data[][] = Excel.get(filename);
		System.out.println(data);

		//	return data ;

	}


	@Test
	public void fileUpload() throws IOException {
		try {

			driver.findElement(By.xpath("//a[text()='File Upload']")).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			//driver.findElement(By.xpath("//input[@id='']")).click();
			WebElement element = driver.findElement(By.id("file-upload"));
			/*
			 * JavascriptExecutor executor = (JavascriptExecutor)driver;
			 * executor.executeScript("arguments[0].click();", element);
			 * executor.executeScript("arguments[0].click();", element);
			 */
			//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


			Actions a = new Actions(driver);
			a.sendKeys(Keys.TAB);
			a.sendKeys(Keys.TAB);
			a.perform();
			a.sendKeys(Keys.ENTER);
			a.perform();


			//Runtime.getRuntime().exec("C:\\Users\\pchandrs\\OneDrive - Capgemini\\Desktop\\Eclipse_Workspace\\JavaSelenium\\others\\UserLogin.xls");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("file-submit")).click();

			String text = driver.findElement(By.xpath("//*[contains(text(),'File Uploaded!')]")).getText();
			System.out.println(text);

		} catch (Exception e) {
			System.out.println("exception block");
			e.printStackTrace();


		}
	}


	@Test
	public void dropdownSelect() {

		driver.findElement(By.xpath(" //*[contains(text(),'pdown')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.id("dropdown"));
		Select options = new Select(element);
		//options.selectByVisibleText("Option 1");
		options.selectByValue("2");

		/*
		 * List<WebElement> elements = options.getOptions(); String selectedOption =
		 * elements.get(0).getText();
		 * System.out.println("Selected Option is......"+selectedOption);
		 */
		WebElement element1 = options.getFirstSelectedOption();
		String s =element1.getText();
		System.out.println(s);
	}


	@Test
	public void switchFrames () {

		driver.findElement(By.xpath("//*[text()='Frames']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[text()='iFrame']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame("mce_0_ifr");
		//WebDriverWait wait = new WebDriverWait(driver,30);


		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*
		 * String text =
		 * driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]")).getText();
		 * System.out.println(text);
		 */
	}

	@Test
	public void handleStaleElement() {


		By SearchBoxelement = By.cssSelector("textarea[name='q']");

		By iamFeelingLuckyBtn = By.xpath("(//input[@class='RNmpXc'])[2]");
		/* * luckyBtn = driver.findElement(iamFeelingLuckyBtn);
		 * luckyBtn.click(); driver.navigate().back(); driver.navigate().refresh();
		 */

		try {

			System.setProperty("webdriver.chrome.driver", driverPath);  
			// Instantiate a ChromeDriver class.     
			this.driver=new ChromeDriver();  
			String url = "https://www.google.com.";
			// Launch Website  
			driver.get(url);
			driver.manage().window().maximize();
			System.out.println("Window Title"+ driver.getTitle());
			WebElement luckyBtn = driver.findElement(iamFeelingLuckyBtn);
			luckyBtn.click();
			driver.navigate().back();
			element = driver.findElement(SearchBoxelement);
			element.sendKeys("Testing...");
			//Thread.sleep(10000);
			element.sendKeys(Keys.ENTER);
			driver.navigate().back();
			element = driver.findElement(SearchBoxelement);
			driver.navigate().refresh(); 
			element =checkStaleElementException(SearchBoxelement); 
			element.sendKeys("Testing...");


		}
		catch (Exception e) {

			System.out.println("Stale Element Exception"+e);
		}
	}



	public WebElement checkStaleElementException( By elementlocatorPath) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return  wait.until(ExpectedConditions.visibilityOfElementLocated(elementlocatorPath));
	}


	/*
	 * The Implicit Wait in Selenium is used to tell the web driver to wait for a
	 * certain amount of time before it throws a “No Such Element Exception”. The
	 * default setting is 0. Once we set the time, the web driver will wait for the
	 * element for that time before throwing an exception.
	 * 
	 * Syntax: driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 * Defined in beginning on the program so that it will applicable to all below steps - by using this in beginning 
	 * we may see it slows the overall execution as this is applicable throughout the driver instance 
	 */
	@Test
	public void implicitWait_NoSuchElement_exception() {
		By SearchBoxelement = By.cssSelector("textarea[name='q']");

		By iamFeelingLuckyBtn = By.xpath("(//input[@class='RNmpXc'])[2]");


		try {

			System.setProperty("webdriver.chrome.driver", driverPath);  
			// Instantiate a ChromeDriver class.     
			this.driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String url = "https://www.google.com.";
			// Launch Website  
			driver.get(url);
			driver.manage().window().maximize();
			System.out.println("Window Title"+ driver.getTitle());
			WebElement luckyBtn = driver.findElement(iamFeelingLuckyBtn);
			luckyBtn.click();
			driver.navigate().back();
			element = driver.findElement(SearchBoxelement);
			element.sendKeys("Testing...");
			//Thread.sleep(10000);
			element.sendKeys(Keys.ENTER);
			driver.navigate().back();
			element = driver.findElement(SearchBoxelement);

		}
		catch (Exception e) {

			System.out.println("Stale Element Exception"+e);
		}


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



	}


	// Robot and Action 


	@Test
	public void mouseHover(){
		//By  hoverElement= By.xpath("//a[@href=\"/users/1\"]"); 
		By  hoverElement= By.xpath("//h5[text()='name: user1']"); 


		System.setProperty("webdriver.chrome.driver", driverPath);  
		// Instantiate a ChromeDriver class.     
		this.driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url = "https://the-internet.herokuapp.com/";
		// Launch Website  
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Window Title"+ driver.getTitle());
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Hovers']")).click();
		driver.findElement(hoverElement).click();
		//Assert.assertEquals(driver.getTitle(), "The Internet");
		/*
		 * WebElement hover = driver.findElement(hoverElement); WebElement hover1 =
		 * checkStaleElementException(hoverElement);
		 * 
		 * 
		 * //Creating object of an Actions class Actions action = new Actions(driver);
		 * 
		 * //Performing the mouse hover action on the target element.
		 * action.moveToElement(hover1);
		 * action.moveToElement(hover1).clickAndHold().build().perform();
		 */
		System.out.println("ssssss");


	}

	@Test
	public void pageination() {

		By searchBar = By.cssSelector("input[id='twotabsearchtextbox']");
		By clickSearchBtn = By.cssSelector("[id='nav-search-submit-button']");
		By nextBtn = By.xpath("//a[text()='Next']");


		System.setProperty("webdriver.chrome.driver", driverPath);
		this.driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(searchBar).sendKeys("Mens shoes");
		driver.findElement(clickSearchBtn).click();
		driver.findElement(clickSearchBtn).click();


	}


	@Test
	public void softAssert() {

		System.setProperty("webdriver.chrome.driver", driverPath);
		this.driver = new ChromeDriver();
		SoftAssert softAssert = new SoftAssert();
		driver.get("https://www.browserstack.com/");
		String getActualTitle = driver.getTitle();
		Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		softAssert.assertEquals(getActualTitle, "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		softAssert.assertNotEquals(getActualTitle, "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		softAssert.assertNull(verifyTitle);
		softAssert.assertNotNull(verifyTitle);
		softAssert.assertTrue("BrowserStack".equals("Browserstack"), "First soft assert failed");
		softAssert.assertFalse("BrowserStack".equals("BrowserStack"), "Second soft assert failed");
		softAssert.assertAll(); 

		//https://www.browserstack.com/guide/verify-and-assert-in-selenium

	}

	/*
	 * links:
	 * 
	 *	https://stackoverflow.com/questions/34422661/selenium-implicitlywait-not-working
	 * 
	 * 
	 */

	@Test(dataProvider = "getData1")
	public void simpleWebAutomation(String[] str ) {

		WebDriver driver ;
		System.setProperty("webdriver.chrome.driver", driverPath);

		try {
			driver = new ChromeDriver();
			driver.get("https://www.google.com");

			for(int i=0;i<str.length;i++) {

				driver.findElement(By.name("q")).clear();
				driver.findElement(By.name("q")).sendKeys(str[i]);
				Thread.sleep(5);
			}
		}
		catch(Exception e) {

		}
	}



	@DataProvider
	public String[][] getData1() {

		String[][] strValues = {{"Prasanna","Test","Automation"}};

		return strValues;

	}


	@Test
	public void brokenLinks() {

		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();

		// Navigate to BStackDemo Website
		driver.get("https://bstackdemo.com/");

		// Finding all the available links on webpage
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// Iterating each link and checking the response status
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			verifyLink(url);
		}


		driver.quit();
	}

	public static void verifyLink(String url) {


		try {
			URL link = new URL(url);
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();


			if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage());
			} else {
				System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
		} catch (Exception e) {
			System.out.println(url + " - " + "is a broken link");
		}
	}



	@Test 
	public void handleCookies() {

		WebDriver driver; 
		System.setProperty("webdriver.chrome.driver","Chrome_driver_path"); 
		driver=new ChromeDriver(); 
		driver.get("https://www.facebook.com");
		//Enter Email id and Password if you are already Registered user 
		driver.findElement(By.name("username")).sendKeys("your_username"); 
		driver.findElement(By.name("password")).sendKeys("your_password"); 
		driver.findElement(By.name("submit")).click(); 
		// Create a file to store Login Information 
		File file = new File("Cookiefile.data"); 
		try{ 
			// Delete old file if already exists
			file.delete(); 
			file.createNewFile(); 
			FileWriter filewriter = new FileWriter("AA.txt"); //""AA.data
			BufferedWriter Bwritecookie = new BufferedWriter(filewriter); //Getting the cookie information 
			for(Cookie ck : driver.manage().getCookies()) { 
				Bwritecookie.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure())); 
				Bwritecookie.newLine(); 
			} 
			Bwritecookie.close(); 
			filewriter.close(); 
		}
		catch (Exception ex) 
		{ 
			ex.printStackTrace(); 
		} 
	}
}

/*
 * RestAssured.BaseURi="https://www.google.com";
 * 
 * 
 * String response= given().log().all(). queryParam().
 * headers("ContentType","JSON"). when(). get(). body("").
 * then().assertThat().log().all().statusCode(200).extract().response().toString
 * ();
 *  
 * 
 * JSONPath json = new JSONpath(); String value = json.getString("value");
 */



























//xPaths

/**contains Text
 * //*[contains(text(),'pdown')]
 * 
 *  * url: https://www.redbus.in/ Help button
 * //span[contains(text(),'Help')]
 * 
 * using css selectors
 * li[id='account_dd']
 * span[class='ynXjOy']
 * 
 * tagName[attribute='value']
 * 
 * exact text
 * 
 * //*[text()='Dropdown']
 * 
 * //span[text()='₹1000 off on Flipkart UPI']//following-sibling::div/span[text()='T&C']
 * 
 * 
 * 
 * 
//h2[text()='Results']//following::span[contains(text(),'Apple')]
 * 
 */






























