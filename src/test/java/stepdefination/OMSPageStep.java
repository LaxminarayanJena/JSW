package stepdefination;

import java.awt.AWTException;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OMSPage;
import pages.PDPRegisteredUserPage;
import pages.Paymentpage;

public class OMSPageStep {
	OMSPage  omspage  = new OMSPage(DriverFactory.getDriver());

	
	@When("user login to OMS")
	public void user_login_to_OMS() throws InterruptedException {
		omspage.goToOMS();
	}
	
	@Then("user navigates to OMS ShipmentsPage")
	public void user_navigates_to_oms_shipments_page() throws InterruptedException, AWTException {
		omspage.goToOMSShipmentPage();
	}
	
	@Then("user creates a completed shipment in OMS")
	public void user_creates_completed_shipment() throws InterruptedException, AWTException {
		omspage.createCompletedShipment();
	}
	
	@Then("user navigates to ShipmentDetails Page in CCP")
	public void user_navigates_to_shipments_page() throws InterruptedException, AWTException {
		omspage.navigateToshipMentsPageCCP();
	}
	
	@Then("user clicks on viewDocuments")
	public void user_clicks_on_view_documents() throws InterruptedException {
		omspage.navigateToViewDocuments();
	}


}
