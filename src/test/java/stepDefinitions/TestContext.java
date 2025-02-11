package stepDefinitions;

import pages.MedExpressHomepage;

public class TestContext {
    private MedExpressHomepage homePage;

    public MedExpressHomepage getHomePage() {
        return homePage;
    }

    public void setHomePage(MedExpressHomepage homePage) {
        this.homePage = homePage;
    }
}
