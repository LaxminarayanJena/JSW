package stepdefination;

import java.awt.AWTException;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.PDPRegisteredUserPage;
import pages.PLPNewPage;
import pages.ProductLandingPage;
import pages.ProductPage;

public class PLPSteps {

	ProductLandingPage productlandingpage = new ProductLandingPage(DriverFactory.getDriver());
	PDPRegisteredUserPage pdpreguser = new PDPRegisteredUserPage(DriverFactory.getDriver());
	ProductPage productpage = new ProductPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	PLPNewPage plpn = new PLPNewPage(DriverFactory.getDriver());

	@When("user click on search button")
	public void user_click_on_search_button() throws InterruptedException {

		productlandingpage.Search();
		Thread.sleep(2500);
	}

	@Then("Breadcrump should display HOME > Search Results")
	public void breadcrump_should_display_home_search_results() {
		Assert.assertTrue(productlandingpage.Validatebreadcrumb());
	}

	@When("user  click on home hyper link in breadcrumb\"")
	public void user_click_on_home_hyper_link_in_breadcrumb() {
		productlandingpage.clickonHomeHyperLink();
	}

	@Then("product page should navigate to home page\"")
	public void product_page_should_navigate_to_home_page() throws InterruptedException {
		Thread.sleep(2500);
		System.out.println("No of banner images " + homePage.validateSliderContainerImages());
	}

	@Then("Catgories Tabs should be available with Hot Rolled,Cold Rolled,Wire Rod,TMT\\(Not for R1),Coated,Colour coated,Alloy Steel\\(Not for R1)\"")
	public void catgories_tabs_should_be_available_with_hot_rolled_cold_rolled_wire_rod_tmt_not_for_r1_coated_colour_coated_alloy_steel_not_for_r1()
			throws InterruptedException {
		productlandingpage.categoriesTabList();
	}

	@Then("Reset link should be available above the filters section")
	public void reset_link_should_be_available_above_the_filters_section() throws InterruptedException {
		productlandingpage.validateReset();
	}

	@When("user  click on HR {int}-{int}")
	public void user_click_on_hr(Integer int1, Integer int2) throws InterruptedException {
		productlandingpage.clickGradesAndSubgrades();

	}

	@When("user  click on Reset Hyper link\"")
	public void user_click_on_reset_hyper_link() throws InterruptedException {
		productlandingpage.clickReset();
	}

	@Then("pagination button should be available on the right corner above the products")
	public void pagination_button_should_be_available_on_the_right_corner_above_the_products() {

	}

	@Then("products should display in grid view product count should per page is {int}")
	public void products_should_display_in_grid_view_product_count_should_per_page_is(Integer int1)
			throws InterruptedException {
		// productlandingpage.validateGridView();
		productlandingpage.countResultPLP();
	}

	@When("user  click on list view icon")
	public void user_click_on_list_view_icon() {
		productlandingpage.clickListView();
	}

	@Then("check {string}")
	public void check(String string) throws InterruptedException {
		productlandingpage.countResultPLP();
	}

	@Then("Reset Link should be present above the filters section")
	public void reset_link_should_be_present_above_the_filters_section() throws InterruptedException {
		productlandingpage.validateReset();
	}

	@Then("All the filters should be removed All the products should display and no filters has to be selected\"")
	public void all_the_filters_should_be_removed_all_the_products_should_display_and_no_filters_has_to_be_selected()
			throws InterruptedException {
		productlandingpage.validateFiltersTobeRemoved();
	}

	@Then("Filters applied should be shown above the Products display applied filters should display with cross button\"")
	public void filters_applied_should_be_shown_above_the_products_display_applied_filters_should_display_with_cross_button()
			throws InterruptedException {
		productlandingpage.validateFiltersTobeShown();
	}

	@When("user enter {string} in search bar")
	public void user_enter_in_search_bar(String SearchText) throws InterruptedException {

		productlandingpage.enterSearchText(SearchText);
	}

	@When("user Select E250A at Filters section in Grades and subGrades")
	public void user_select_e250a_at_filters_section_in_grades_and_sub_grades() throws InterruptedException {
		productlandingpage.clickGradesE250A();
	}

	@When("user Select E350A at Filters section in Grades and subGrades")
	public void user_select_e350a_at_filters_section_in_grades_and_sub_grades() throws InterruptedException {
		productlandingpage.clickE350A();
	}

	@Then("Filters applied should be shown above the Products display")
	public void filters_applied_should_be_shown_above_the_products_display() throws InterruptedException {
		productlandingpage.validateFiltersTobeShown();
	}

	@Then("all the applied filters should display")
	public void all_the_applied_filters_should_display() {
		productlandingpage.validateflitersDisplayed();
	}

	@Then("clear all hyper link must be available after selection of more than {int} filters")
	public void clear_all_hyper_link_must_be_available_after_selection_of_more_than_filters(Integer int1)
			throws InterruptedException {
		Assert.assertTrue(productlandingpage.validateClearAll());
	}

	@When("click on clear all hyper link")
	public void click_on_clear_all_hyper_link() throws InterruptedException {
		productlandingpage.clickClearAll();
	}

	@Then("all the applied filters should be removed")
	public void all_the_applied_filters_should_be_removed() throws InterruptedException {
		productlandingpage.validateFiltersTobeRemoved();
	}

	@Then("all the products should display\"")
	public void all_the_products_should_display() {
		productlandingpage.countNoofProductImages();
	}

	@When("user click on E350A filter cross button")
	public void user_click_on_e350a_filter_cross_button() {
		productlandingpage.countNoofProductImages();
		productlandingpage.removingfilterE350A();

	}

	@Then("After removing filter E350A remaining filters products should display")
	public void after_removing_filter_e350a_remaining_filters_products_should_display() {
		productlandingpage.countNoofProductImages();
	}

	@When("user click on cross mark for all filters shown\"")
	public void user_click_on_cross_mark_for_all_filters_shown() {
		productlandingpage.countNoofProductImages();
		productlandingpage.removingfilterE350A();
		productlandingpage.removingfilterE250A();
	}

	@Then("Filter sections are Forms ,Grades and Sub Grades,Application sector,Thickness,Width and Length")
	public void filter_sections_are_forms_grades_and_sub_grades_application_sector_thickness_width_and_length() {
		productlandingpage.validateHotRolledSheetFilterSection();
	}

	@Then("Filter sections are Grade,Sub grade, Thickness, sub Application Sector,Forms,Diameter")
	public void filter_sections_are_grade_sub_grade_thickness_sub_application_sector_forms_diameter() {
		productlandingpage.validateFilters();
	}

	@Then("Filter sections are Filter sections are Sub Category,Grade,sub Grade,Thickness,width,coating Grade,Spangle type ,Application Sector,sub Application Sector")
	public void filter_sections_are_filter_sections_are_sub_category_grade_sub_grade_thickness_width_coating_grade_spangle_type_application_sector_sub_application_sector() {
		productlandingpage.validateFilters();
	}

	@Then("Filter sections are Sub Category,Grade,sub Grade,Thickness,width,coating Grade,colour,Application Sector,sub Application Sector")
	public void filter_sections_are_sub_category_grade_sub_grade_thickness_width_coating_grade_colour_application_sector_sub_application_sector() {

	}

	@Then("Hot Rolled coil Related products will display")
	public void hot_rolled_coil_related_products_will_display() throws InterruptedException {
		productlandingpage.validateHotRolledProductName();
	}

	@Then("product name should be for Hot Rolled Sheet is \"\"Hot Rolled sheets[{int}:{int}]-E250A-HR CTLF")
	public void product_name_should_be_for_hot_rolled_sheet_is_hot_rolled_sheets_e250a_hr_ctlf(Integer int1,
			Integer int2) throws InterruptedException {
		productlandingpage.validateHotRolledProductName();
	}

	@When("user click on product name displayed on the page")
	public void user_click_on_product_name_displayed_on_the_page() throws InterruptedException {
		Thread.sleep(5000);
		productlandingpage.clickonProduct();
		Thread.sleep(3000);
	}

	@Then("page navigates to PDP page")
	public void page_navigates_to_pdp_page() {

	}

	@Then("product measurements should be display Thickness {double} mm, width {int} mm and  Length")
	public void product_measurements_should_be_display_thickness_mm_width_mm_and_length(Double double1, Integer int1) {

	}

	@Then("product price range should be display")
	public void product_price_range_should_be_display() throws InterruptedException {
		productlandingpage.validatePrice();
	}

	@Then("Rupee symbol should be display at before every price")
	public void rupee_symbol_should_be_display_at_before_every_price() throws InterruptedException {
		productlandingpage.validatePrice();
	}

	@Then("Delivery in should display with days range ie Delivery in {int}-{int} days")
	public void delivery_in_should_display_with_days_range_ie_delivery_in_days(Integer int1, Integer int2) throws InterruptedException {
		productlandingpage.validatedeliveryDate();
	}

	@Then("Sorry page should display with {string}{string}{string}{string}\"")
	public void sorry_page_should_display_with(String string, String string2, String string3, String string4) {
		productlandingpage.validateInvalidSearchMessage();
	}

	@Then("Grade and sub grade for Hot Rolled are dispalyed {int}_{int},E250_A, E250BR, E350A")
	public void grade_and_sub_grade_for_hot_rolled_are_dispalyed_e250_a_e250br_e350a(Integer int1, Integer int2)
			throws InterruptedException {
		productlandingpage.verifyGradesAndSubgradesForHotRolled();
	}

	@Then("Grade and sub grade for cold Rolled are displayed {int}_part1_{int} ,CR1,E250A")
	public void grade_and_sub_grade_for_cold_rolled_are_displayed__part1_cr1_e250a(Integer int1, Integer int2)
			throws InterruptedException {
		productlandingpage.verifyGradesAndSubgradesForColdRolled();
	}

	@Then("Filter with Coating Grade to be displayed")
	public void filter_with_coating_grade_to_be_displayed() throws InterruptedException {
		plpn.validateGrades();
		Thread.sleep(2000);
		productlandingpage.verifyGradesForCoated();
	
		
	}

	@Then("Filter with Color to be displayed")
	public void filter_with_color_to_be_displayed() throws InterruptedException {
		plpn.validateGrades();
		Thread.sleep(2000);
		productlandingpage.verifyFilterColorCoated();
	}

	@Then("Filter with Diameter to be displayed")
	public void filter_with_diameter_to_be_displayed() {
		productlandingpage.verifyDiameter();
	}

	@When("user click on {int}_{int} in filter")
	public void user_click_on_in_filter(Integer int1, Integer int2) throws InterruptedException {
		productlandingpage.clickGrades();
	}

	@When("user click on {int}_{int} in grades and subgrades filter")
	public void user_click_on_in_grades_and_subgrades_filter(Integer int1, Integer int2) throws InterruptedException {
		productlandingpage.click277_2018();
	}

	@When("click on cancel grade from tags")
	public void click_on_cancel_grade_from_tags() throws InterruptedException {
		Assert.assertTrue(productlandingpage.validateClearAll());
		productlandingpage.clickClearAll();

	}

	@Then("After cancelling the cancelled tag should be eliminated from the tags and products should display accordingly")
	public void after_cancelling_the_cancelled_tag_should_be_eliminated_from_the_tags_and_products_should_display_accordingly()
			throws InterruptedException {
		productlandingpage.validateFiltersTobeRemoved();
	}

	@When("user scroll down till enquiry button")
	public void user_scroll_down_till_enquiry_button() {
		productlandingpage.scrollTillEnquiryForm();
	}

	@Then("Enquiry form should be displayed in PLP page for guest user")
	public void enquiry_form_should_be_displayed_in_plp_page_for_guest_user() {

	}

	@Then("Stainless Steel Products are displayed")
	public void stainless_steel_products_are_displayed() {

		Assert.assertEquals(productlandingpage.validatePLPListResults(), "Stainless Steel");

	}

	@Then("Steel Products are displayed")
	public void steel_products_are_displayed() {

			Assert.assertEquals(productlandingpage.validatePLPListResults(), "Steel");

	}
	
	@Then("HR Products are displayed")
	public void hr_products_are_displayed() {
		Assert.assertEquals(productlandingpage.validatePLPListResults(), "Hot Rolled Sheets");
	}
	
	@Then("Breadcrump should display Home > Metals and Alloys > Stainless Steel")
	public void breadcrump_should_display_home_metals_and_alloys_stainless_steel() {

		Assert.assertEquals(productlandingpage.validatePLPBreadCrumb(), "Stainless Steel");
	}

	@Then("Breadcrump should display Home > Metals and Alloys > Steel")
	public void breadcrump_should_display_home_metals_and_alloys_steel() {

		Assert.assertEquals(productlandingpage.validatePLPBreadCrumb(), "Steel");
	}

	@When("user clicks on home hyper link in breadcrumb")
	public void user_clicks_on_home_hyper_link_in_breadcrumb() {
		productlandingpage.clickonHomeHyperLink();

	}

	@Then("products should display in grid view  and product count should be displayed")
	public void products_should_display_in_grid_view_and_product_count_should_be_displayed() {
		productlandingpage.TotalProductCount();
	}

	@Then("Filter with Thickness ,Width and Length to be displayed")
	public void filter_with_thickness_width_and_length_to_be_displayed() {
		Assert.assertTrue(productlandingpage.validatePLPFilter());
	}

	@Then("user click on grade in filter")
	public void user_click_on_grade_in_filter() throws InterruptedException {
		productlandingpage.clickonGradeFilter();
	}
	
	@Then("user click on grade in SteelPLPfilter")
	public void user_click_on_grade_in_SteelPLPfilter() throws InterruptedException {
		productlandingpage.clickonGradeFilterinSteel();
	}

	@Then("click on reset")
	public void click_on_reset() {
		productlandingpage.clickResetFilter();
	}

	@Then("all products to be displayed")
	public void all_products_to_be_displayed() throws InterruptedException {
		productlandingpage.validateFiltersTobeRemoved();

	}

	@When("user selects Stainless Steel product")
	public void user_selects_stainless_steel_product() throws InterruptedException {
		pdpreguser.selectProductreguser();
	}

	@When("user selects Steel product")
	public void user_selects_steel_product() throws InterruptedException {
		pdpreguser.selectSteelProductreguser();
	}
	
	@When("user selects CR Coil Steel product")
	public void user_selects_CRCoilSteel_product() throws InterruptedException {
		pdpreguser.selectCRCoilSteelProductreguser() ;
	}
	
	@When("user selects WeldingElectrode product")
	public void user_selects_WeldingElectrode_product() throws InterruptedException {
		pdpreguser.selectWeldingElectrodeProductreguser();
	}
	
	@When("user selects WeldingFlux product")
	public void user_selects_WeldingWire_product() throws InterruptedException {
		pdpreguser.selectWeldingWireProductreguser();
	}
	
	@When("user clicks CR Coil from Steel Categories Menu")
	public void user_clicks_CRCoil_from_SteelCategoriesMenu() throws InterruptedException, AWTException {
		productpage.CRMenu();
	}
	
	@When("user clicks HR Sheet series from Steel Categories Menu")
	public void user_clicks_hr_sheet_series_from_steel_categories_menu() throws InterruptedException, AWTException {
		productpage.SSMenu();
	}

	@Then("HR Sheet series Products are displayed")
	public void hr_sheet_series_products_are_displayed() {
		Assert.assertEquals(productpage.validateHRSeries300Page(), "Stainless Steel hot rolled sheets");
	}

	@When("user selects HR Sheet series product")
	public void user_selects_hr_sheet_series_product() throws InterruptedException {
		  
	}
	
	@When("user selects HR Stainless Steel product")
	public void user_selects_hr_stainless_steel_product() {
		Assert.assertEquals(productpage.validateHRSeries300Page(), "Stainless Steel hot rolled sheets");
		productpage.selectProductreguserHRS();
	}
	
	
}
