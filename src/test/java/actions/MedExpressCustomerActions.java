package actions;

import pages.MedExpresLoginPage;
import pages.MedExpressHomepage;
import pages.MedExpressLandingPage;
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
	
	
	

}
