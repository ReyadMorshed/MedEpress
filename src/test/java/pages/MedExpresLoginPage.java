package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MedExpresLoginPage extends MedExpressBasePage {
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement password;
	
	
	@FindBy(xpath = "//p/button[@class='button-submit']")
	private WebElement loginButton;
	

	@Override
	public boolean validatePageHasLoaded() {
		List<WebElement> webelementList = new ArrayList<>();
		webelementList.add(email);
		webelementList.add(password);
		webelementList.add(loginButton);
		return checkElementsAreVisible(webelementList);
	}
	
	public void enterEmailAndPassword(String email, String password) throws Exception {
		Thread.sleep(2000);
		sendKeys(this.email, email);
		sendKeys(this.password, password);
		
	}
	
	public MedExpressHomepage clickOnSignButton () throws InterruptedException {
		
		scrollToTheElement(this.email);
		Thread.sleep(4000);		
		clickOnElementActions(this.loginButton);
		return newPage(MedExpressHomepage.class, driver);
	}

}
