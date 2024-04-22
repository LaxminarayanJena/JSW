package com.jswone.msme.oms.stepdefination;

import java.awt.AWTException;
import java.io.IOException;

import com.jswone.msme.oms.factory.DriverFactory;
import com.jswone.msme.oms.pages.CCPPage;
import com.jswone.msme.oms.pages.OrderPage;
import com.jswone.msme.oms.pages.SFPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class SF {
	SFPage sfpage = new SFPage(DriverFactory.getDriver());
	OrderPage orderPage = new OrderPage(DriverFactory.getDriver());
	CCPPage cppPage = new CCPPage(DriverFactory.getDriver());

	@Given("user login to SF")
	public void user_login_to_sf() throws InterruptedException {

		sfpage.goToSF();

	}

	@Given("user navigates to AccountPage")
	public void user_navigates_to_account_page() {
		sfpage.goToAccounts();
		
	}

	@When("they create an SLC Order")
	public void they_create_an_slc_order() throws InterruptedException, AWTException {
		sfpage.clickNewOpportunity();
		sfpage.fillSKURequirementDetails();

	}
	
	@When("they create a SLO Order")
	public void they_create_an_slo_order() throws InterruptedException, AWTException {
		sfpage.clickNewOpportunity();
		sfpage.fillSKURequirementDetails();

	}

	@When("create order and extract orderno from SF")
	public void create_order_and_extract_orderno_from_sf() throws InterruptedException {
		sfpage.orderDetails();
	}


	@Then("user navigates to orderpage in CCP using SFOrder")
	public void ccpusingSFOrder() throws InterruptedException {
		String orderNo = sfpage.extractSFOrderNo();
		cppPage.navigateToOrderPage(orderNo);
	}

	@Then("user navigates to ERP orders details page using SF order")
	public void ERPpusingSFOrder() throws InterruptedException, IOException {
		String orderNo = sfpage.extractSFOrderNo();
		orderPage.navigateToERPOrderPageUsingSFOrderNo(orderNo);
	}


	@Then("close rest open tabs")
	public void close_rest_open_tabs() {
		sfpage.closeRestTabs();
	}

	@Given("approves payment in SF")
	public void approves_payment_in_sf() throws InterruptedException {
		sfpage.approvePayment();
	}

}
