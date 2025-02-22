package stepDefinitions;

import java.awt.AWTException;

import org.junit.Assert;

import actions.MedExpressCustomerActions;
import base.Base;
import io.cucumber.java.en.*;
import pages.MedExpressConfirmPage;
import pages.MedExpressHomepage;
import pages.MedExpressOrderCompletePage;
import pages.MedExpressShippingAdressPage;
import pages.MedExpressUploadPrescriptionPage;


public class MedExpressUploadPrescriptionSteps extends Base{
	TestContext testContext;
	MedExpressCustomerActions CustomarActions = new MedExpressCustomerActions();
	
    MedExpressHomepage homePage = null;
    MedExpressUploadPrescriptionPage uploadPrescriptionPage = null;
    MedExpressShippingAdressPage shippingAdressPage = null;
    MedExpressConfirmPage confirmPage = null;
    MedExpressOrderCompletePage orderCompletePage = null;
    
 // Constructor to get shared data
    public MedExpressUploadPrescriptionSteps(TestContext testContext) {
        this.testContext = testContext;
        this.homePage = testContext.getHomePage();  // Retrieve homepage instance
    }
    
	@Then("click on upload prescription button")
	public void click_on_upload_prescription_button() throws Exception {
	   uploadPrescriptionPage = CustomarActions.customerCanClickOnUploadButton(homePage);
	   boolean isExsits = uploadPrescriptionPage.validatePageHasLoaded();
	   Assert.assertTrue(isExsits);
	}

	@Then("write the doctor name")
	public void write_the_doctor_name() throws Exception {
	    CustomarActions.customerCanWriteDoctorName("Dr. Reyad", uploadPrescriptionPage);
	}

	@Then("upload the prescription")
	public void upload_the_prescription() throws InterruptedException, AWTException {
		CustomarActions.customerCanUploadPrescription(uploadPrescriptionPage);
	}

	@Then("click on checkout button")
	public void click_on_checkout_button() throws Exception {
		shippingAdressPage = CustomarActions.customerCanClickOnCheckoutButton(uploadPrescriptionPage);
		shippingAdressPage.validatePageHasLoaded();
	}

	@Then("click on shipping address button")
	public void click_on_shipping_address_button() throws Exception {
		confirmPage = CustomarActions.customerCanClickOnShippingButton(shippingAdressPage);
		confirmPage.validatePageHasLoaded();
	}

	@Then("click on confirm button")
	public void click_on_confirm_button() throws InterruptedException {
		orderCompletePage = CustomarActions.customerCanClickOnConfirmButton(confirmPage);
		orderCompletePage.validatePageHasLoaded();
	}

	@Then("validate the order confirmation")
	public void validate_the_order_confirmation() {
	    
		String expectedText = "Thank you";
		String actualText = CustomarActions.validateOrderConfirmationtext(orderCompletePage);
		// Validate the text using Assert
        Assert.assertEquals(expectedText, actualText);
	}

}
