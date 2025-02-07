package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.Base;

public class MedExpressHomepage extends MedExpressBasePage {

	@FindBy(xpath = "//a/span[contains(text(),'Log out')]")
	private WebElement logoutButton;
	
	@Override
	public boolean validatePageHasLoaded() throws InterruptedException {
		List<WebElement> webelementList = new ArrayList<>();
		hoverOnElement(this.logoutButton);
		webelementList.add(this.logoutButton);
		return checkElementsAreVisible(webelementList);
	}

}
