package resources;


public enum APIResources {
	
    notificationRegistrationsmsAPI("/notification/sms/send"),
    notificationEmailAPI("/notification/email/send/order"),
    loginAPI("/auth/login/"),
    directUserloginAPI("/auth/login/"),
    myrequirementsAPI("/order-service/requirement/my-requirements"),
    plantSelectorAPI("/product/plantSelector"),
    requestForPriceAPI("/payment/requestForPrice"),
    registerAPI("/customer/v1/register"),
    cartSizeAPI("/cart/cart-size"),
	addToCartAPI("/cart/addtocart"),
	validateGSTAPI("/customer/v1/gst/validate"),
	validatePhoneAPI("/auth/customer/find-customer"),
	validateCouponAPI("/cart/v2/add-discount"),
	removeCouponAPI("/cart/v2/remove-discount"),
	validatemyOrderAPI("/order-service/order/my-orders?offset=0&limit=499"),
	createOrderAPI("/order/create"),
	orderSummaryAPI("/order/summary/order-num"),
	orderAPI("/order/order-num"),
	bankAPI("payment/banks"),
	paymentSummaryAPI("payment/paymentSummary/orderNumber"),
	razorPayOrderAPI("payment/razorpayorder"),
	captureTransactionAPI("payment/capture-transaction"),
	ledgerAPI("customer/ledger?page=0&limit=10"),
	ledgerTransactionDownloadAPI("customer/download-transaction"),
	ledgerEmailStatementAPI("customer/ledger/share"),
	ledgerBlockedAmountAPI("order-service/order/ledger/blocked-amount"),
    ledgerBlockedAmountDetailsAPI("order-service/order/ledger/blocked-amount/details"),
	plpAPI("catalog/breadcrumb/category"),
	plpFilterAPI("product/projections/filter"),
	profileAPI("customer/me/profile"),
	customerAPI("customer/me/v2"),
	updateprofileAPI("customer/profile"),
	clearCartAPI("/cart/delete-cart?cartType=cart"),
	cartSumamryAPI("/cart/summary"),
	validateCartAPI("/cart/validateCart"),
	removeCartItemAPI("/cart/removecartitem"),
	SLOAPI("data-sync/import/sales-opp");
	;
	
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
		
	}
}
	
