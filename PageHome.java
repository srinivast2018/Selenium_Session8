package com.ibm.magentopages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import com.ibm.magentotest.ValidateMagento;


//Locating the user web element
public class PageHome {
	@FindBy(xpath="//span[text()='Account']/ancestor::a")
	WebElement myAccountEle;
	
	//Defining constructor
	public PageHome(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//To click on user icon
	public void clickOnMyAccountIcon()
	{
	myAccountEle.click();
	}
	
	
}
