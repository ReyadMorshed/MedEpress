package stepDefinitions;


import base.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MedExpresLoginPage;
import pages.MedExpressHomepage;
import pages.MedExpressLandingPage;

import javax.inject.Inject;
import org.testng.Assert;

import actions.MedExpressCustomerActions;

import java.util.Map;

public class MedExpressLoginTestSteps extends Base {
	
	MedExpressLandingPage landinPage = null;
	MedExpresLoginPage loginPage = null;
	MedExpressHomepage homePage = null;
	MedExpressCustomerActions CustomarActions = new MedExpressCustomerActions();
	TestContext testContext;  // Shared Test Context
	
	@Inject
    public MedExpressLoginTestSteps(TestContext testContext) {
        this.testContext = testContext;
    }
	
	@Given("Navigate to MedExpress website")
	public void navigate_to_med_express_website() {
	    navigateToApplication(Hook.projectProperties.getProperty("base_url"));
	}
	@Given("Validate the landing page")
	public void validate_the_landing_page() throws InterruptedException {
	    landinPage = newPage(MedExpressLandingPage.class, driver);
	    landinPage.clickOnCrossIcon();
	    boolean isExsits = landinPage.validatePageHasLoaded();
	    Assert.assertTrue(isExsits);
	}
	@Then("User is in the landing page, Click on the login link")
	public void user_is_in_the_landing_page_click_on_the_login_link() {
	   loginPage = CustomarActions.userCanClickOnSigninLink(landinPage);
	   
	   
	}
	@Then("Validate the login page")
	public void validate_the_login_page() {
	    boolean isExsits = loginPage.validatePageHasLoaded();
	    Assert.assertTrue(isExsits);
	}
	@Then("Give the email {string} and password {string}")
	public void give_the_email_and_password(String email, String password) throws Exception {
		CustomarActions.customerCanInputEmailAndPassword(email, password, loginPage);
	}
	@Then("Click on the login button")
	public void click_on_the_login_button() throws InterruptedException {
		
		homePage = CustomarActions.customerCanCLickOnSignInButton(loginPage);
		testContext.setHomePage(homePage);
	}
	@Then("validate the homepage")
	public void validate_the_homepage() throws InterruptedException {
	    boolean isExsits = homePage.validatePageHasLoaded();
	    Assert.assertTrue(isExsits);
	}

}
