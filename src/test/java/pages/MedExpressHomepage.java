package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.Base;

public class MedExpressHomepage extends MedExpressBasePage {

	@FindBy(xpath = "//a/span[contains(text(),'Log out')]")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//li[@id='topcartlink']//a[@class='btn nd-up-btn']")
	private WebElement uploadButton;
	
	@Override
	public boolean validatePageHasLoaded() throws InterruptedException {
		List<WebElement> webelementList = new ArrayList<>();
		hoverOnElement(this.logoutButton);
		webelementList.add(this.logoutButton);
		return checkElementsAreVisible(webelementList);
	}
	
	public MedExpressUploadPrescriptionPage clickonUploadButton () {
		
		clickOnElement(this.uploadButton);
		return newPage(MedExpressUploadPrescriptionPage.class, driver);
	}

}
