package com.ibm.magentopages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class PageLogin {

	@FindBy(xpath="//*[text()='Forgot Your Password?']")
	WebElement forgotElt;
	By forgotLink=By.partialLinkText("Forgot Your Password?");
	
	WebDriver driver;
	WebDriverWait wait;
	
	//Defining constructor
	public PageLogin(WebDriver driver,WebDriverWait wait)
	{
	this.driver=driver;
	this.wait=wait;
	PageFactory.initElements(driver, this);
	}
	
	
	//To click on the forgot your password link
	public void clickOnForgotLInk()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated((forgotLink)));
		forgotElt.click();
		
	}
}
