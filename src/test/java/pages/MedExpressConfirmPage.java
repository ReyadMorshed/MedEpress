package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MedExpressConfirmPage extends MedExpressBasePage {
	
	@FindBy(xpath = "//input[@name='nextstep']")
	WebElement confirmButton;
	
	

	@Override
	public boolean validatePageHasLoaded() throws InterruptedException {
		List<WebElement>webelementList = new ArrayList<>();
		webelementList.add(confirmButton);
		return checkElementsAreVisible(webelementList);
	}
	
	public MedExpressOrderCompletePage clickOnConfirmButton() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		clickOnElementActions(this.confirmButton);
		return newPage(MedExpressOrderCompletePage.class, driver);
	}

}
