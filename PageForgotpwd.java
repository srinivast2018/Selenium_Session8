package com.ibm.magentopages;
import java.io.File;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;


public class PageForgotpwd {

	@FindBy(xpath = "//span[text()='Submit']")
	WebElement submitButton;

	@FindBy(id = "email_address")
	WebElement emailAddress;

	By emailBox = By.id("email_address");

	WebDriver driver;
	WebDriverWait wait;

	// Defining constructor
	public PageForgotpwd(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
		
	}

	// Method to click on submit button and capturing the message displayed
	public String clickOnSubmitButton() {
		wait.until(ExpectedConditions.presenceOfElementLocated((emailBox)));
		submitButton.click();

		return driver.getPageSource();

	}

	// To enter the email address in text box
	public void enterEmailAddress(String email) {
		
		emailAddress.sendKeys(email);
	}

}
