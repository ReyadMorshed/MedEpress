package actions;

import java.awt.AWTException;

import pages.MedExpresLoginPage;
import pages.MedExpressConfirmPage;
import pages.MedExpressHomepage;
import pages.MedExpressLandingPage;
import pages.MedExpressOrderCompletePage;
import pages.MedExpressShippingAdressPage;
import pages.MedExpressUploadPrescriptionPage;

public class MedExpressCustomerActions {
	
	public MedExpresLoginPage userCanClickOnSigninLink(MedExpressLandingPage landingPage) {
		
		return landingPage.clickOnSignInButton();
		
	}
	
	public void customerCanInputEmailAndPassword(String email, String password, MedExpresLoginPage loginPage) throws Exception {
		loginPage.enterEmailAndPassword(email, password);
	}
	
	public MedExpressHomepage customerCanCLickOnSignInButton (MedExpresLoginPage loginPage) throws InterruptedException {
		return loginPage.clickOnSignButton();
	}
	
	public  MedExpressUploadPrescriptionPage customerCanClickOnUploadButton (MedExpressHomepage homepage) {
		return homepage.clickonUploadButton();
	}
	
	public void customerCanWriteDoctorName (String Name, MedExpressUploadPrescriptionPage uploadPrescriptionPage) throws Exception {
		
		uploadPrescriptionPage.enterTheDoctorName(Name);
	}
	
    public void customerCanUploadPrescription (MedExpressUploadPrescriptionPage uploadPrescriptionPage) throws InterruptedException, AWTException {
		
		uploadPrescriptionPage.uploadPrescription();
	}
    
    public MedExpressShippingAdressPage customerCanClickOnCheckoutButton (MedExpressUploadPrescriptionPage uploadPrescriptionPage) throws Exception {
    	
    	return uploadPrescriptionPage.clickOnCheckOutButton();
    }
    
    public MedExpressConfirmPage customerCanClickOnShippingButton (MedExpressShippingAdressPage shippingPage) throws Exception {
    	
    	return shippingPage.clickonShippingAddreessButton();
    }
    
    public MedExpressOrderCompletePage customerCanClickOnConfirmButton(MedExpressConfirmPage confirmPage) {
    	
    	return confirmPage.clickOnConfirmButton();
    }
    
    public  String validateOrderConfirmationtext(MedExpressOrderCompletePage completePage) {
    	
    	return completePage.validateConfirmationText();
    }

}
