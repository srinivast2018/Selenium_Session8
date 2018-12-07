package com.ibm.magentotest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ibm.magentopages.PageHome;
import com.ibm.magentopages.PageLogin;
import com.ibm.magentopages.PageForgotpwd;
import com.ibm.utilities.PropertiesFileHandler;
import jdk.nashorn.internal.runtime.PrototypeObject;
import org.testng.Assert;

public class ValidateMagento {
	PropertiesFileHandler propFileHandler;
	HashMap<String, String> data;
	WebDriver driver;
	WebDriverWait wait;
	
	//Setting path for Webdriver and instantiating the object
	
	@BeforeMethod
	public void initializeDriver() throws IOException
	
	{
		String file="./TestData/magento.properties";
		//Location //Properties handler
				propFileHandler = new PropertiesFileHandler();
				//Returning the keys from .properties file in to Map collection
				data =propFileHandler.getPropertiesAsMap(file);		
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver= new FirefoxDriver();
				wait=new WebDriverWait(driver, 60);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}

	@AfterMethod
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void navigateLogin() throws InterruptedException
	{
		String file="./TestData/magento.properties";
		//Getting the  values from Map collection
		String url=data.get("url");
		String userName=data.get("username");
		String password=data.get("password");
		String expectedTitle=data.get("expectedtitle");
		String expectedmessage=data.get("validateMessage");
		String email=data.get("emailaddress");
		String expectedvalidemail=data.get("validemailmessage");
		
		
		
		//Launching the Magento website
		driver.get(url);
		PageHome home=new PageHome(driver);
		home.clickOnMyAccountIcon();
		
		//To click on Forgot Password link
		PageLogin login=new PageLogin(driver,wait);
		login.clickOnForgotLInk();
				
		//To click on Submit button
		PageForgotpwd forgot=new PageForgotpwd(driver,wait);
		String pageSource=forgot.clickOnSubmitButton();
		Thread.sleep(2000);
		
		//Validating the message for required field
		if(pageSource.contains(expectedmessage))
		System.out.println("Validation message for required field:  "+expectedmessage);
		Assert.assertTrue(pageSource.contains(expectedmessage),"Assertion on required field Error Message");
		//To enter the email address in text box
		forgot.enterEmailAddress(email);
		
		pageSource=forgot.clickOnSubmitButton();
		
		//Validating the error message for email-address
		if(pageSource.contains(expectedvalidemail))
		System.out.println("Validation message email-address field: "+expectedvalidemail);
		Assert.assertTrue(pageSource.contains(expectedvalidemail),"Assertion on email address field Error Message");
	
	}

}//End of program
