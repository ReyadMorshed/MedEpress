package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MedExpressShippingAdressPage extends MedExpressBasePage{
	
	
	@FindBy(xpath ="(//input[@value='Ship to this address'])[1]")
	WebElement shippingButton;
	@FindBy(xpath ="//h3[normalize-space()='Shipping address']")
	WebElement shippingText;

	@Override
	public boolean validatePageHasLoaded() throws InterruptedException {
		List<WebElement>webelementList = new ArrayList<>();
		webelementList.add(shippingText);
		webelementList.add(shippingButton);
		return checkElementsAreVisible(webelementList);
	}
	
	public MedExpressConfirmPage clickonShippingAddreessButton() {
		
		scrollToTheElement(this.shippingText);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		clickOnElementActions(this.shippingButton);
		return newPage(MedExpressConfirmPage.class, driver);
		
	}

}
