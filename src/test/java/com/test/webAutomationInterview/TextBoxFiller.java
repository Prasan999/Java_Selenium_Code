package com.test.webAutomationInterview;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxFiller {

    WebDriver driver;
    public static String driverPath=System.getProperty("user.dir")+"\\driver\\chromedriver.exe";

    // Constructor to initialize the WebDriver
    public TextBoxFiller(WebDriver driver) {
        this.driver = driver;
    }

    // Utility method to fill text boxes
    public void fillTextBoxes(List<String> values) {
    	
    	try {
        // Find all the text boxes on the webpage (Assuming all have the same locator, like class name)
        WebElement textBoxes = driver.findElement(By.id("user-name"));

		/*
		 * // Ensure the number of text boxes matches the number of values if
		 * (textBoxes.size() != values.size()) { throw new
		 * IllegalArgumentException("Number of values does not match the number of text boxes."
		 * ); }
		 */
        
        
        // Enter values into the text boxes
        for (int i = 0; i < values.size(); i++) {
        	Thread.sleep(2000);
        	textBoxes.clear();
            textBoxes.sendKeys(values.get(i));
        }
    	}
    	catch(Exception e) {
    		System.out.println("Exception block executed in fillTextBoxes"+e);
    		
    	}
    }

    public static void main(String[] args) {
        // Set the path to your WebDriver
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage containing the text boxes
        driver.get("https://www.saucedemo.com"); // replace with your URL
        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Create an instance of the TextBoxFiller
        TextBoxFiller textBoxFiller = new TextBoxFiller(driver);

        // Example list of values to enter into the text boxes
        List<String> values = List.of("Value1", "Value2", "Value3", "Value4", "Value5", 
                                      "Value6", "Value7", "Value8", "Value9", "Value10");

        // Call the method to fill the text boxes
        textBoxFiller.fillTextBoxes(values);

        // Close the browser
        driver.quit();
    }
}
/*
 * Explanation: WebDriver Initialization: The WebDriver instance (driver) is
 * initialized in the main method, and the URL of the webpage is loaded.
 * 
 * fillTextBoxes Method: This method takes a list of strings (values) as input
 * and fills the text boxes with these values. It first locates all the text
 * boxes using a CSS selector (input[type='text'] in this example, but you can
 * customize the selector based on your actual webpage structure). The method
 * checks that the number of values matches the number of text boxes to avoid
 * errors.
 * 
 * Dynamic Filling: The method loops through each text box and enters the
 * corresponding value from the list.
 * 
 * Main Method: This method creates an instance of the TextBoxFiller class and
 * calls the fillTextBoxes method with a list of values to be entered into the
 * text boxes.
 * 
 * Customization: Locator Strategy: Adjust the locator strategy in the
 * findElements method to match how your text boxes are identified (e.g., by id,
 * name, or a more specific CSS selector). Driver Path: Make sure to set the
 * correct path for your ChromeDriver or whichever WebDriver you are using. This
 * approach is generic and can be reused for any number of text boxes, as long
 * as the list of values provided matches the number of text boxes on the page.
 */








