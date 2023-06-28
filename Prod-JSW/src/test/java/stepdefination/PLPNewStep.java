package stepdefination;

import java.awt.AWTException;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.PDPRegisteredUserPage;
import pages.PLPNewPage;
import pages.ProductLandingPage;
import pages.ProductPage;

public class PLPNewStep {

	ProductLandingPage productlandingpage = new ProductLandingPage(DriverFactory.getDriver());
	PDPRegisteredUserPage pdpreguser = new PDPRegisteredUserPage(DriverFactory.getDriver());
	ProductPage productpage = new ProductPage(DriverFactory.getDriver());
	HomePage homePage = new HomePage(DriverFactory.getDriver());
	PLPNewPage plpn = new PLPNewPage(DriverFactory.getDriver());

	@When("user click Steel Menu on header section")
	public void user_click_steel_menu_on_header_section() throws InterruptedException {
		plpn.clickSteelMenu();

	}

	@When("user is able to view Steel products on PLP page")
	public void user_is_able_to_view_steel_products_on_plp_page() throws InterruptedException {
		plpn.validateSteelPLP();
		Thread.sleep(2000);

	}

	@Then("Breadcrump should display HOME > Metals and Alloys > Steel")
	public void breadcrump_should_display_home_metals_and_alloys_steel() throws InterruptedException {
		productlandingpage.Validatebreadcrumb();
		Thread.sleep(2000);
		plpn.verifySteel();

	}

	@When("user is able to select Hot Rolled from Steel Menu")
	public void user_is_able_to_select_hot_rolled_from_steel_menu() throws InterruptedException {
		plpn.selectHR();
		Thread.sleep(2000);

	}

	@Then("Breadcrump should display HOME > Metals and Alloys > Steel > HR")
	public void breadcrump_should_display_home_metals_and_alloys_steel_hr() throws InterruptedException {
		productlandingpage.Validatebreadcrumb();
		Thread.sleep(2000);
		plpn.verifyHR();

	}

	@When("user is able to select Cold Rolled from Steel Menu")
	public void user_is_able_to_select_cold_rolled_from_steel_menu() throws InterruptedException, AWTException {
		plpn.selectCR();

	}

	@Then("Breadcrump should display HOME > Metals and Alloys > Steel > CR")
	public void breadcrump_should_display_home_metals_and_alloys_steel_cr() throws InterruptedException {
		productlandingpage.Validatebreadcrumb();
		Thread.sleep(2000);
		plpn.verifyCR();
	}

	@When("user  click on Metal and Alloys hyper link in breadcrumb\"")
	public void user_click_on_metal_and_alloys_hyper_link_in_breadcrumb() {
		plpn.clickMetal();

	}

	@Then("product page should navigate to Metalm and Alloy")
	public void product_page_should_navigate_to_metalm_and_alloy() {
		plpn.verifyMetal();
	}

	@Then("product page should navigate to home page")
	public void product_page_should_navigate_to_home_page() throws InterruptedException {
		plpn.verifyHome();
		Thread.sleep(2000);
	}

	@When("user is able to view subcategory of Steel Menu on header section")
	public void user_is_able_to_view_subcategory_of_steel_menu_on_header_section() {
		plpn.verifySubCategorySteelMenu();

	}

	@Then("user is select Grade at Filter section")
	public void user_is_select_grade_at_filter_section() throws InterruptedException {
		plpn.clickBrand();
		Thread.sleep(2000);
		// plpn.clickGrade();
	}

	@When("user is able to view on Reset Hyper link CTA")
	public void user_is_able_to_view_on_reset_hyper_link_cta() {
		plpn.verifyReset();
	}

	@Then("check Found {string} total product number of Steel products displayed")
	public void check_found_total_product_number_of_steel_products_displayed(String string)
			throws InterruptedException {
		Thread.sleep(3000);
		plpn.clickSteel();
		Thread.sleep(3000);
		plpn.countSteelProd();
	}

	@Then("user is select {int}:{int} from Grade at Filter section")
	public void user_is_select_from_grade_at_filter_section(Integer int1, Integer int2) throws InterruptedException {
		// plpn.clickBrand();
		Thread.sleep(2000);
		plpn.clickGrade();

	}

	@When("user  click on Reset Hyper link")
	public void user_click_on_reset_hyper_link() {
		plpn.clickReset();

	}

	@When("user is on Steel Menu on header section")
	public void user_is_on_steel_menu_on_header_section() {
		plpn.steel();
	}

	@Then("user is select JSW Steel from Brand at Filter section")
	public void user_is_select_jsw_steel_from_brand_at_filter_section() {
		plpn.clickBrand();

	}

	@Then("user is select the Thickness - Min and Max values")
	public void user_is_select_the_thickness_min_and_max_values() throws InterruptedException {
		plpn.thicknessMin();
		plpn.thicknessMax();

	}

	@Then("check clear hyper link is displayed on Thickness section")
	public void check_clear_hyper_link_is_displayed_on_thickness_section() throws InterruptedException {
		plpn.verifyClear();
		Thread.sleep(3000);

	}

	@Then("click Clear huper link")
	public void click_clear_huper_link() throws InterruptedException {
		plpn.clickClear();
		Thread.sleep(2000);

	}

	@Then("After removing filter Thickness remaining filters products should display")
	public void after_removing_filter_thickness_remaining_filters_products_should_display()
			throws InterruptedException {
		plpn.clickFilterX();
		Thread.sleep(2000);
		plpn.countAppliedFilters();
	}

	@Then("user click on cross mark for all filters shown")
	public void user_click_on_cross_mark_for_all_filters_shown() throws InterruptedException {
		plpn.countAppliedFilters();
		plpn.clearAppliedFilters();

	}

	@Then("all the products should display")
	public void all_the_products_should_display() {
		plpn.verifyAllHRProducts();

	}

	@Then("Filter sections are Brand, Grade, Thickness,Width and Length")
	public void filter_sections_are_brand_grade_thickness_width_and_length() throws InterruptedException {
		Thread.sleep(2000);
		plpn.verifyFilterSection();

	}

	@When("user is able to select Hot rolled from Steel Menu")
	public void user_is_able_to_select_hot_rolled_from_steel_menu1() throws InterruptedException {
		plpn.selectHR();
		Thread.sleep(2000);
	}

	@When("user is able to select Cold rolled from Steel Menu")
	public void user_is_able_to_select_cold_rolled_from_steel_menu1() throws InterruptedException {
		plpn.selectCR();
		Thread.sleep(2000);
	}

	@When("user is able to select Wire rods from Steel Menu")
	public void user_is_able_to_select_wire_rods_from_steel_menu() throws InterruptedException {
		plpn.selectWR();
		Thread.sleep(2000);

	}

	@Then("Filter sections are Brand, Grade, Diameter")
	public void filter_sections_are_brand_grade_diameter() {
		plpn.verifyFilterSection();

	}

	@When("user is able to select Coated from Steel Menu")
	public void user_is_able_to_select_coated_from_steel_menu() throws InterruptedException {
		plpn.selectCoated();
		Thread.sleep(2000);

	}

	@When("user is able to select Colour coated from Steel Menu")
	public void user_is_able_to_select_colour_coated_from_steel_menu() throws InterruptedException {
		plpn.selectColourCoated();
		Thread.sleep(2000);

	}

	@When("user is able to select Hot rolled coil from Steel Menu")
	public void user_is_able_to_select_hot_rolled_coil_from_steel_menu() {
		plpn.selectHRC();

	}

	@When("user is able to select Hot rolled sheets from Steel Menu")
	public void user_is_able_to_select_hot_rolled_sheets_from_steel_menu() throws InterruptedException {
		plpn.selectHRS();
		Thread.sleep(2000);

	}

	@When("product name should be for Hot Rolled Sheet is {string}")
	public void product_name_should_be_for_hot_rolled_sheet_is(String string) {
		plpn.validateProductName();
	}

	@When("user is able to select Cold rolled sheets from Steel Menu")
	public void user_is_able_to_select_cold_rolled_sheets_from_steel_menu() {
		plpn.selectCRS();

	}

	@Then("Grade for Hot Rolled are dispalyed {int}:{int}, {int}:{int}")
	public void grade_for_hot_rolled_are_dispalyed(Integer int1, Integer int2, Integer int3, Integer int4)
			throws InterruptedException {
		plpn.validateGrades();
		Thread.sleep(2000);

	}

	@Then("Grade for Cold Rolled are dispalyed {int}:{int}, {int} \\(Part1):{int}, {int}:{int}, {int}:{int}")
	public void grade_for_cold_rolled_are_dispalyed_part1(Integer int1, Integer int2, Integer int3, Integer int4,
			Integer int5, Integer int6, Integer int7, Integer int8) throws InterruptedException {
		plpn.validateGrades();
		Thread.sleep(2000);
	}

	@When("user click on {int}_{int} in grade filter")
	public void user_click_on_in_grade_filter(Integer int1, Integer int2) {

	}

	// TMT Product

	@When("user click TMT Menu on header section")
	public void user_click_tmt_menu_on_header_section() throws InterruptedException {
		homePage.validateTMT();

	}

	@When("user is able to view TMT Steel products on PLP page")
	public void user_is_able_to_view_tmt_steel_products_on_plp_page() throws InterruptedException {
		//homePage.validateTMT();

	}

	@Then("Breadcrump should display HOME > Construction materials > TMT")
	public void breadcrump_should_display_home_construction_materials_construction_steel_tmt() {
		productlandingpage.Validatebreadcrumb();

	}

	@When("user click on Construction Steel hyper link in breadcrumb")
	public void user_click_on_construction_steel_hyper_link_in_breadcrumb() throws InterruptedException {
		plpn.clickConstructionSteel();

	}

	@Then("product page should navigate to Construction Steel")
	public void product_page_should_navigate_to_construction_steel() throws InterruptedException {
		plpn.valiadtePLP();
		Thread.sleep(2000);

	}

	@When("user click on Construction materials hyper link in breadcrumb")
	public void user_click_on_construction_materials_hyper_link_in_breadcrumb() throws InterruptedException {
		plpn.clickConstructionMaterials();

	}

	@Then("product page should navigate to Construction materials")
	public void product_page_should_navigate_to_construction_materials() throws InterruptedException {
		plpn.valiadtePLP();
		Thread.sleep(2000);

	}

	@Then("Filter sections are Brand, Grade and Diameter")
	public void filter_sections_are_brand_grade_and_diameter() throws InterruptedException {
		plpn.verifyFilterSection();
		Thread.sleep(2000);

	}

	@When("product name should be for TMT Steel is {string}")
	public void product_name_should_be_for_tmt_steel_is(String string) throws InterruptedException {
		plpn.verifyTMTProd();

	}

	@When("user click on product name of TMT Steel product displayed on the page")
	public void user_click_on_product_name_of_tmt_steel_product_displayed_on_the_page() throws InterruptedException {
		plpn.Pdpnavigate();
		plpn.verifyTMTPDPpage();

	}

	@And("^user click on product name of Cement product displayed on the page$")
	public void user_click_on_product_name_of_cement_product_displayed_on_the_page() throws Throwable {
		plpn.selectCementProduct();
	}

	@And("^user click on product name of Wire product displayed on the page$")
	public void user_click_on_product_name_of_wire_product_displayed_on_the_page() throws Throwable {
		plpn.selectWireProduct();
	}
	
	@And("^user click on product name of Cold rolled product displayed on the page$")
    public void user_click_on_product_name_of_cold_rolled_product_displayed_on_the_page() throws Throwable {
		plpn.selectColdRolledProduct();
    }

	@Then("product price range should be display for TMT")
	public void product_price_range_should_be_display_for_tmt() throws InterruptedException {
		plpn.priceRangeTMT();
	}

	@Then("user is select JSW Brand at Filter section for TMT")
	public void user_is_select_jsw_brand_at_filter_section_for_tmt() throws InterruptedException {
		plpn.clickBrand();
		Thread.sleep(1500);

	}

	@Then("Reset link should be available above the filters section for TMT")
	public void reset_link_should_be_available_above_the_filters_section_for_tmt() throws InterruptedException {
		plpn.clickReset();
		Thread.sleep(1500);

	}

	@Then("user is select Grade at Filter section for TMT")
	public void user_is_select_grade_at_filter_section_for_tmt() throws InterruptedException {
		plpn.TMTGrade();

	}

	@Then("user is select IS {int}:{int} Fe 550D from Grade at Filter section for TMT")
	public void user_is_select_is_fe_550d_from_grade_at_filter_section_for_tmt(Integer int1, Integer int2)
			throws InterruptedException {
		plpn.TMTGrade();

	}

	@Then("All the filters should be removed and products should display and no filters has to be selected\"")
	public void all_the_filters_should_be_removed_and_products_should_display_and_no_filters_has_to_be_selected()
			throws InterruptedException {
		plpn.clickReset();
		Thread.sleep(2000);

	}

	@Then("user is select the Diameter - Min and Max values for TMT")
	public void user_is_select_the_diameter_min_and_max_values_for_tmt() throws InterruptedException {
		plpn.diameterMin();
		Thread.sleep(2000);
		plpn.diameterMax();
	}

	@Then("check clear hyper link is displayed on Diameter section for TMT")
	public void check_clear_hyper_link_is_displayed_on_diameter_section_for_tmt() throws InterruptedException {
		plpn.diameterClear();

	}

	@Then("After removing filter Diamter remaining filters products should display")
	public void after_removing_filter_diamter_remaining_filters_products_should_display() throws InterruptedException {
		plpn.valiadtePLP();
		plpn.removeDiamterTMT();
	}

	@Then("all the applied filters should be removed for TMT")
	public void all_the_applied_filters_should_be_removed_for_tmt() throws InterruptedException {
		plpn.clickReset();
		Thread.sleep(2000);

	}

	@Then("all the products should display for TMT")
	public void all_the_products_should_display_for_tmt() {
		plpn.valiadtePLP();

	}
	
	@When("user selects Colour coated product")
	public void user_selects_colour_coated_product() throws InterruptedException {
		
		plpn.selectPPGLCoilProduct() ;
	    
	}
	
	@When("user is on product detail page of colour coated product and add quantiy with quantity {string}")
	public void user_is_on_product_detail_page_of_colour_coated_product_and_add_quantiy_with_quantity(String qty) throws InterruptedException {
		plpn.PPGLCoilProductDetails(qty) ;
	}



}
