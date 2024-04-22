package com.jswone.msme.oms.stepdefination;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Assert;

import com.jswone.msme.oms.factory.DriverFactory;
import com.jswone.msme.oms.pages.DashboardPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Dashboard {
	private DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());

	@Given("user login to ERP")
	public void user_login_to_erp() throws InterruptedException, IOException {
		dashboardPage.goToOMS();
	}

	@Then("validate {int} tabs User should see {int} tabs Dashboard,Order Details,Incoming Payments, Ledger,User Management,Finance Payout,Credit Limit,Credit Order")
	public void validate_tabs_user_should_see_tabs_dashboard_order_details_incoming_payments_ledger_user_management_finance_payout_credit_limit_credit_order(
			Integer int1, Integer int2) {
		dashboardPage.validateTabs();
	}

	@When("the user selects the {string} option from the filters at the top")
	public void the_user_selects_the_option_from_the_filters_at_the_top(String string) throws AWTException {
		dashboardPage.enterseller();
	}

	@When("the user types a partial seller name")
	public void the_user_types_a_partial_seller_name() {

	}

	@Then("the seller name should auto-populate based on the input")
	public void the_seller_name_should_auto_populate_based_on_the_input() {

	}

	@When("the user clicks on submit")
	public void the_user_clicks_on_submit() throws InterruptedException {
		dashboardPage.clickSubmit();

	}

	@Then("all the displayed rows should correspond to the seller searched for")
	public void all_the_displayed_rows_should_correspond_to_the_seller_searched_for() {
		dashboardPage.validateSellerCount();
	}

	@When("the user selects an Ops Spoc from the checkbox options")
	public void the_user_selects_an_ops_spoc_from_the_checkbox_options() throws AWTException, InterruptedException {
		dashboardPage.selectSPOC();
	}

	@Then("all the displayed rows should correspond to the Ops Spoc searched for")
	public void all_the_displayed_rows_should_correspond_to_the_ops_spoc_searched_for() {
		dashboardPage.validateSPOC();
	}

	@Given("the user applies filters on seller, delivery state, and ops spoc and performs a search")
	public void the_user_applies_filters_on_seller_delivery_state_and_ops_spoc_and_performs_a_search()
			throws AWTException, InterruptedException {
		dashboardPage.enterseller();
		dashboardPage.selectSPOC();

	}

	@When("the user clicks on the reset button")
	public void the_user_clicks_on_the_reset_button() {
		dashboardPage.clickReset();

	}

	@Then("the applied filters should be reset and user should be able to see data from different seller, state, and ops spoc")
	public void the_applied_filters_should_be_reset_and_user_should_be_able_to_see_data_from_different_seller_state_and_ops_spoc() {

		Assert.assertFalse(dashboardPage.validateFilterCleared());

	}

	@Then("verify total line items is {int}")
	public void verify_total_line_items_is(int orderCount) {
		dashboardPage.verifyLineItem(orderCount);
	}

	@When("the user goes to the dashboard and clicks on the {string} Today tab")
	public void the_user_goes_to_the_dashboard_and_clicks_on_the_today_tab(String TabName) throws InterruptedException {
		dashboardPage.TodaysTab(TabName);

	}

	@Then("the orders that have an order creation date today should appear in today's bucket")
	public void the_orders_that_have_an_order_creation_date_today_should_appear_in_today_s_bucket()
			throws InterruptedException {
		dashboardPage.orderCreationDate();
	}

	@Then("the count should match with the pagination after clicking")
	public void the_count_should_match_with_the_pagination_after_clicking() throws InterruptedException {
		dashboardPage.validatePaginationCount();
	}

	@When("the user goes to the dashboard and clicks on the {string} {int}-{int} tab")
	public void the_user_goes_to_the_dashboard_and_clicks_on_the_tab(String TabName, Integer int1, Integer int2)
			throws InterruptedException {
		dashboardPage.onetothreedaysTab(TabName);
	}

	@When("the user goes to the dashboard and clicks on the {string} {int}-{int} days tab")
	public void the_user_goes_to_the_dashboard_and_clicks_on_the_daystab(String TabName, Integer int1, Integer int2)
			throws InterruptedException {
		dashboardPage.fourtosevendaysTab(TabName);
	}

	@When("the user goes to the dashboard and clicks on the {string} 1week+ tab")
	public void the_user_goes_to_the_dashboard_and_clicks_on_the_1week_tab(String TabName) throws InterruptedException {
		dashboardPage.oneweekplusTab(TabName);
	}
	
	




	
	

}
