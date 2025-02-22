package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MedExpressUploadPrescriptionPage extends MedExpressBasePage {

	
	@FindBy(xpath = "//input[@id='DoctorName']")
	WebElement doctorNameBox;
	
//	@FindBy(xpath = "//button[normalize-space()='Drop files here to upload']")
//	WebElement fileUpload;
	
	@FindBy(xpath = "//div[@id='dropzone-div']")
	WebElement dropzoneDiv;
	
	@FindBy(xpath = "//input[@name = 'file']")
	WebElement fileInput;
	
	@FindBy(xpath = "//input[@id='submit-prescription-form-btn']")
	WebElement checkOutButton;
	
	String projectPath = System.getProperty("user.dir");
	String filePath = (projectPath + "\\src\\test\\resources\\images\\prescription-template_x.png");
	
	@Override
	public boolean validatePageHasLoaded() throws InterruptedException {
		List<WebElement> webelementList = new ArrayList<>();
		webelementList.add(this.doctorNameBox);
		webelementList.add(this.dropzoneDiv);
		webelementList.add(this.checkOutButton);
		return checkElementsAreVisible(webelementList);
	}
	
	public void enterTheDoctorName (String Name) throws Exception {
		
		sendKeys(this.doctorNameBox,Name);
		scrollToTheElement(this.doctorNameBox);
		Thread.sleep(3000);
	}
	
	public void  uploadPrescription() throws InterruptedException, AWTException {
		
        Robot robo = new Robot();
        StringSelection Str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(Str, null);
        
     // Click the Dropzone area to trigger the file input
        dropzoneDiv.click();
        Thread.sleep(5000);
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);
        
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);
        
        robo.keyPress(KeyEvent.VK_ENTER);
        robo.keyRelease(KeyEvent.VK_ENTER);
        
		
	}
	
	public MedExpressShippingAdressPage clickOnCheckOutButton() throws Exception {
		
//		scrollToTheElement(this.doctorNameBox);
		Thread.sleep(7000);
		clickOnElement(this.checkOutButton);
		return newPage(MedExpressShippingAdressPage.class, driver);
	}

}
