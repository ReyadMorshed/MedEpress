package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Base {

    protected static WebDriver driver;

    public static Actions actions;

    protected static Actions getActions(){
        return actions = new Actions(driver);
    }

    protected static void navigateToApplication(String url) {
        driver.navigate().to(url);
    }
    
    protected static void refreshCurrentPage() {
    	driver.navigate().refresh();

    }

    protected static boolean isDisplayed(WebElement element){
        return element.isDisplayed();
    }

    protected static void sendKeys(WebElement element, String keys) {
        element.sendKeys(keys);
    }

    protected static String getTextOfElement(WebElement element) {
        return element.getText();
    }

    protected static void hoverOnElement(WebElement element) {
        getActions().moveToElement(element).perform();
    }

    protected static void clickOnElement(WebElement element) {
        element.click();
    }
    
    protected static void clickOnElementActions(WebElement element) {
        getActions().click(element).build().perform();
    }
    protected static void clickOnElementJS(WebElement element) {
    	
    	// Use JavaScript to click
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    protected static <T> T newPage(Class<T> tClass, WebDriver driver) {
        return PageFactory.initElements(driver, tClass);
    }
    
    protected static void scrollToTheElement(WebElement element) {
    	// Scroll into view if needed
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    	// Click using JavaScript as a fallback
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    
    protected static void pressEnterKey(WebElement element) {
        element.sendKeys(Keys.ENTER);;
    }

}
