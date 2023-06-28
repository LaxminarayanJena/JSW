package stepdefination;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.MyOrderPages;

public class MyOrderPageSteps {
	

	private MyOrderPages order = new MyOrderPages(DriverFactory.getDriver());
	public String Orderno;
	public String tax;

	@When("user is able to click my order button")
	public void user_is_able_to_click_my_order_button() {
		order.getMyOrder().click();
	}

	@When("user is able to click view details button")
	public void user_is_able_to_click_view_details_button() throws InterruptedException {
		//order.scrollingDown(order.getViewDetails());
		order.clickViewDetails();
		
		
	}

	@When("user is able to click view price breakup button to view detailed cost list of the ordered product")
	public void user_is_able_to_click_view_price_breakup_button_to_view_detailed_cost_list_of_the_ordered_product() throws InterruptedException {
		order.scrollingDown(order.getViewPriceBreakup());
		Thread.sleep(2000);
		order.getViewPriceBreakup().click();
		Thread.sleep(2000);
	}

	@Then("user is again click the  view price breakup button to close")
	public void user_is_again_click_the_view_price_breakup_button_to_close() throws InterruptedException {
		order.closePopup();
		Thread.sleep(2000);
	}

	@When("user is able to click my order")
	public void user_is_able_to_click_my_order() throws InterruptedException {
		order.getMyOrder().click();
		Thread.sleep(2000);
	}

	@When("user is able click need help button")
	public void user_is_able_click_need_help_button() throws InterruptedException {
		order.scrollingDown(order.getNeedHelp());
		Thread.sleep(2000);
		order.getNeedHelp().click();
		Thread.sleep(2000);
	}

	@Then("user is able to navigate to need help page")
	public void user_is_able_to_navigate_to_need_help_page() {
		order.implicitWaitSec(10);
		order.validateNeedHelp();

	}
	
	@When("user is able to click my order in home page")
	public void user_is_able_to_click_my_order_in_home_page() {
		order.getMyOrder().click();
	}

	@When("user is able to scroll down and click buy again which was shown in the ordered product")
	public void user_is_able_to_scroll_down_and_click_buy_again_which_was_shown_in_the_ordered_product() throws InterruptedException {
		order.scrollingDown(order.getBuyAgain());
		order.getBuyAgain().click();
	}

	@When("user is able to choose requirement details and select")
	public void user_is_able_to_choose_requirement_details_and_select() throws InterruptedException {
		order.scrollingDown(order.getDimensionScroll());
		Thread.sleep(2000);
		order.getInput().sendKeys("2");
		Thread.sleep(2000);
		order.getArrow().click();
	}

	@When("user is able to click add to cart")
	public void user_is_able_to_click_add_to_cart() throws InterruptedException {
		order.getAddToCart().click();
		Thread.sleep(2000);
	}

	@When("user is able to click ok button in the pop of the add to cart button")
	public void user_is_able_to_click_ok_button_in_the_pop_of_the_add_to_cart_button() throws InterruptedException {
		order.getOkCart().click();
		Thread.sleep(2000);

	}

	@When("user is able to click cart icon")
	public void user_is_able_to_click_cart_icon() throws InterruptedException {
		order.getMyCart().click();
		Thread.sleep(2000);

	}

	@When("user is able to scroll down and click proceed to pay button")
	public void user_is_able_to_scroll_down_and_click_proceed_to_pay_button() throws InterruptedException {
		order.scrollingDown(order.getProceedToPay());
		Thread.sleep(2000);
		order.getProceedToPay().click();
	}

	@When("user is able to choose bank in the list")
	public void user_is_able_to_choose_bank_in_the_list() throws InterruptedException {
		order.dropDownValue(order.getBankList(), "SBHY");
		Thread.sleep(2000);

	}

	@When("user is able to click pay now button")
	public void user_is_able_to_click_pay_now_button() throws InterruptedException {
		order.getPayNow().click();
		Thread.sleep(2000);
	}

	@Then("user navigate to RayzorPay page")
	public void user_navigate_to_rayzor_pay_page() throws InterruptedException {
		order.implicitWaitSec(10);
		order.validateRazorpayPage();
	}

	@Then("User is able to click on success button")
	public void user_is_able_to_click_on_success_button() throws InterruptedException {
		order.implicitWaitSec(10);
		order.clickSucessPayment();
		order.implicitWaitSec(2);
	}

	@Then("verify after successful payment navigates to ORDER summary page")
	public void verify_after_successful_payment_navigates_to_order_summary_page() {
		order.implicitWaitSec(10);
		order.validateOrderSuccessfulmsg();
	}

	@Then("user verify your order is confirmed message")
	public void user_verify_your_order_is_confirmed_message() {
		order.implicitWaitSec(20);
	}

	@Then("user is able to click canel order button")
	public void user_is_able_to_click_canel_order_button() throws InterruptedException {
	  	order.scrollingDown(order.getCancel());
	    Thread.sleep(2000);
	    order.getCancel().click();
	    Thread.sleep(2000);
	    order.getOkCancel().click();
	    Thread.sleep(2000);
	}

	@Then("user is able to click My order button on home page")
	public void user_is_able_to_click_my_order_button_on_home_page() throws InterruptedException {
	   order.getMyOrder().click();
	   Thread.sleep(2000);
	}

	@Then("user is able to click cancel button in my order page")
	public void user_is_able_to_click_cancel_button_in_my_order_page() throws InterruptedException {
	  order.getCancelOrder().click();
	  Thread.sleep(2000);
	}

	@Then("user is able to write remark")
	public void user_is_able_to_write_remark() throws InterruptedException {
	  order.getRemark().sendKeys("Cancel the order");
	  Thread.sleep(5000);
	}

	@Then("user is able to click cancelorder button")
	public void user_is_able_to_click_cancelorder_button() throws InterruptedException {
	    order.getCancelOrderB().click();
	    order.implicitWaitSec(10);
	}

	@Then("user is able to view cancelled message")
	public void user_is_able_to_view_cancelled_message() throws InterruptedException {
	   Thread.sleep(2000);
		order.validateCancelmge();
	   Thread.sleep(2000);
	}
	//DO payment history
	
		@When("user is able to click view details button for DO")
		public void user_is_able_to_click_view_details_button_for_do() throws InterruptedException {
			order.DOorder();
			Thread.sleep(2000);
		}
		
		@When("user is able to view Order summary page")
		public void user_is_able_to_view_order_summary_page() throws InterruptedException {
		  order.validateOrderSummaryPage();
		  Thread.sleep(2000);
		}

		@Then("user is able to view Payment received section")
		public void user_is_able_to_view_payment_received_section() throws InterruptedException {
		  order.validatePaymentReceived();
		  Thread.sleep(2000);
		}

		@When("user is able to click Payment history dropdown CTA")
		public void user_is_able_to_click_payment_history_dropdown_cta() throws InterruptedException {
			order.scrollPayment();
			order.clickPaymentHistory();
		  Thread.sleep(2000);
		   order.clickPaymentHistory();
		}

		@Then("user is able to view Direct order payment status")
		public void user_is_able_to_view_direct_order_payment_status() throws InterruptedException {
		    order.paymentHistory();
		    Thread.sleep(2000);
		}
		

	//View applied coupons
		
		@When("user is able to verify view coupons displayed")
		public void user_is_able_to_verify_view_coupons_displayed() throws InterruptedException {
		    order.validateViewCoupons();
		    Thread.sleep(2000);
		}

		@Then("user is able to view number of applied coupons")
		public void user_is_able_to_view_number_of_applied_coupons() throws InterruptedException {
		    order.couponsCount();
		    Thread.sleep(2000);
		}

		@When("user is able to click View coupons")
		public void user_is_able_to_click_view_coupons() throws InterruptedException {
		    order.clcikViewCoupons();
		    Thread.sleep(2000);
		}

		@Then("user is able to view Applied coupons pop-up")
		public void user_is_able_to_view_applied_coupons_pop_up() throws InterruptedException {
		    order.validateAppliedCoupon();
		}
		
//Filter Functionality
		
		@When("user is able to view Myorders CTA")
		public void user_is_able_to_view_myorders_cta() throws InterruptedException {
		 System.out.println(order.getMyOrder().getText());
		 Thread.sleep(2000);
		    
		}

		@When("user is able to click the Myorders CTA")
		public void user_is_able_to_click_the_myorders_cta() throws InterruptedException {
		 order.getMyOrder().click();
		 Thread.sleep(3000);
		    
		}

		@When("user is navigate to MyOrder page")
		public void user_is_navigate_to_my_order_page() throws InterruptedException {
		    order.verifyMyOrderPage();
		    Thread.sleep(1500);
		    
		}

		@Then("user is able to verify the message displayed on the Filter icon")
		public void user_is_able_to_verify_the_message_displayed_on_the_filter_icon() throws InterruptedException {
		    order.invoiceMessage();
		    Thread.sleep(2000);
		    
		}

		@Then("user is able to click Filter icon on MyOrder page")
		public void user_is_able_to_click_filter_icon_on_my_order_page() {
		    order.clickFilter();
		    
		}

		@Then("user is able to verify the filter pop-up displayed")
		public void user_is_able_to_verify_the_filter_pop_up_displayed() throws InterruptedException {
		    order.verifyFilterPopup();
		    Thread.sleep(1500);
		    
		}

		@When("user is able select the any one status from the status dropdown menu")
		public void user_is_able_select_the_any_one_status_from_the_status_dropdown_menu() throws InterruptedException {
		    order.selectedPlaced();
		    
		}

		@Then("user is able click Apply CTA")
		public void user_is_able_click_apply_cta() {
		    order.clickApply();
		    
		}

		@Then("user is able to view the applied filter option below the My orders")
		public void user_is_able_to_view_the_applied_filter_option_below_the_my_orders() throws InterruptedException {
		    order.verifyFilterApplied();
		    
		}

		@When("user is able to select the duration of ordered products to be filtered")
		public void user_is_able_to_select_the_duration_of_ordered_products_to_be_filtered() throws InterruptedException {
		 order.durationDefault();
		    
		}

		@When("user is able select the custom date range of ordered products to be displayed")
		public void user_is_able_select_the_custom_date_range_of_ordered_products_to_be_displayed() throws InterruptedException {
		    order.customFromDuration();
		    order.customToDuration();
		}

		@When("user is able to select the pre-defined duration range of ordered products to be filtered")
		public void user_is_able_to_select_the_pre_defined_duration_range_of_ordered_products_to_be_filtered() throws InterruptedException {
		    order.durationDefault();
		    
		}

		@Then("user is able to view Clear all CTA and clickable")
		public void user_is_able_to_view_clear_all_cta_and_clickable() throws InterruptedException {
		    order.clickClearAll();
		    
		}

		@Then("user is verify that applied filters are cleared")
		public void user_is_verify_that_applied_filters_are_cleared() throws InterruptedException {
		    order.clearedAppliedFilter();
		    Thread.sleep(2000);
		    
		}

		@Then("user is able to click Reset CTA to clear the selected filter option")
		public void user_is_able_to_click_reset_cta_to_clear_the_selected_filter_option() throws InterruptedException {
		    order.clickReset();
		    
		}
		
		@When("user is able to click the MyOrder CTA")
		public void user_is_able_to_click_the_myorder_cta() {
			order.getMyOrder().click();
		}
		
		@And("gets the order details")
		public void get_the_order_details() {
			Orderno = order.getOrderNo();
			//tax=order.gettax();
			//System.out.print("tax"+ tax);
		}
		@When("user click on order and search orderno in mc")
		public void user_click_on_order_and_search_ordernoMc() throws InterruptedException {
			order.clickOrder();
			if (order.isElementPresentpopup()) {
				order.checkPopup();
			}
			Thread.sleep(2000);
			order.enterOrdernoSearchBox(Orderno);

		}	

	    @Then("^user is able to view Orders awaiting payment header$")
	    public void user_is_able_to_view_orders_awaiting_payment_header() throws Throwable {
	    	order.validateOrdersAwaitingPaymentHeader();
	    }

	    @And("^user is able to view My orders header$")
	    public void user_is_able_to_view_my_orders_header() throws Throwable {
	        order.validatemyOrdersHeader();
	    }
	    
	    @When("user clicks on ReviewAndPay")
		public void user_clicks_on_review_and_pay() throws InterruptedException {
			order.clickReviewAndPay();
		}
	    
	    @And("^verify active,delivered and cancelled tab$")
	    public void verify_active_delivered_and_cancelledTab() throws Throwable {
	        order.verifyActiveDeliveredAndCancelled();
	    }
	    
	    @And("^count list of orders$")
	    public void count_listoforders() throws Throwable {
	        order.countlistofOrders();
	    }
	    
	    @When("verify Order placed")
	    public void verify_order_placed() {
	    	order.verifyOrderPlaced();
	    }
	    
	    @When("verify Bill to,Ship to")
	    public void verify_bill_to_ship_to() {
	    	order.verifyBillToShipTo();
	    }
	    
	    @When("verify Order number")
	    public void verify_order_number() {
	    	order.verifyOrderNumber();
	    }
	    
	    @When("verify Payment details")
	    public void verify_payment_details() {
	    	order.verifyPaymentDetails();
	    }
	    
	    @When("verify Item details")
	    public void verify_item_details() {
	    	order.verifyItemDetails();
	    }
	    
	    @When("verify Order Status")
	    public void verify_order_status() {
	    	order.verifyOrderStatus();
	    }
	    
  
	    @When("verify clicking on View details navigates to order summaryPage")
	    public void verify_clicking_on_view_details_navigates_to_order_summary_page() throws InterruptedException {
	    	order.countlistofOrders();
	    }







	}
