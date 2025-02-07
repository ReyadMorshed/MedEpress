package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MedExpressLandingPage extends MedExpressBasePage{
	
	@FindBy(xpath = "//span[text()='Log in']")
	private WebElement login;
	
	@FindBy(xpath = " //span[text()='Welcome to Med Express']")
	private WebElement welcomeText;
	

	public MedExpresLoginPage clickOnSignInButton() {
		
		clickOnElement(this.login);
		return newPage(MedExpresLoginPage.class, driver);
	}
	
	@Override
	public boolean validatePageHasLoaded() throws InterruptedException {
		List<WebElement> webelementList = new ArrayList<WebElement>();
		Thread.sleep(2000);
		webelementList.add(this.welcomeText);
		webelementList.add(this.login);
		return checkElementsAreVisible(webelementList);
	}
	
public void clickOnCrossIcon() throws InterruptedException {
		
	Thread.sleep(2000);	
	refreshCurrentPage();
		
	}
	
	

}
