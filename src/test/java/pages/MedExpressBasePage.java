package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import base.Base;

public abstract class MedExpressBasePage extends Base {
	
	public abstract boolean validatePageHasLoaded() throws InterruptedException;
	
	protected boolean checkElementsAreVisible(List<WebElement> elementList){
        while(!elementList.isEmpty()) {
            if (isDisplayed(elementList.getFirst())){
                elementList.removeFirst();
                checkElementsAreVisible(elementList);
            }
        }
        return true;
    }

}
