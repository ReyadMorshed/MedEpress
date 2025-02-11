package stepDefinitions;

import actions.MedExpressCustomerActions;
import base.Base;
import io.cucumber.java.en.*;
import pages.MedExpressHomepage;
import pages.MedExpressUploadPrescriptionPage;


public class MedExpressUploadPrescriptionSteps extends Base{
	TestContext testContext;
	MedExpressCustomerActions CustomarActions = new MedExpressCustomerActions();
	
    MedExpressHomepage homePage;
    MedExpressUploadPrescriptionPage uploadPrescriptionPage;
    
    
 // Constructor to get shared data
    public MedExpressUploadPrescriptionSteps(TestContext testContext) {
        this.testContext = testContext;
        this.homePage = testContext.getHomePage();  // Retrieve homepage instance
    }
    
	@Then("click on upload prescription button")
	public void click_on_upload_prescription_button() {
	   uploadPrescriptionPage = CustomarActions.customerCanClickOnUploadButton(homePage);
	}

	@Then("write the doctor name")
	public void write_the_doctor_name() {
	    
	}

	@Then("upload the prescription")
	public void upload_the_prescription() {
	    
	}

	@Then("click on checkout button")
	public void click_on_checkout_button() {
	    
	}

	@Then("click on shipping address button")
	public void click_on_shipping_address_button() {
	    
	}

	@Then("click on confirm button")
	public void click_on_confirm_button() {
	   
	}

	@Then("validate the order confirmation")
	public void validate_the_order_confirmation() {
	    
	}

}
