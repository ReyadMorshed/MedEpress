package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MedExpressOrderCompletePage extends MedExpressBasePage {
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath = "//h3[normalize-space()='Thank you']")
	WebElement thankYouText;
	
	String welcomeText;

	@Override
	public boolean validatePageHasLoaded() throws InterruptedException {
		// TODO Auto-generated method stub
		List<WebElement>webelementList = new ArrayList<>();
		webelementList.add(continueButton);
		webelementList.add(thankYouText);
		
		return false;
	}
	
	public String validateConfirmationText() {
		
		welcomeText = getTextOfElement(thankYouText);
		return welcomeText;
	}

}
