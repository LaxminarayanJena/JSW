package com.jswone.msme.oms.util;

public class TestDataBuild {
	
	public String neftTestData(String paymntId,String amt) {
		return "{\r\n"
				+ "    \"entity\": \"event\",\r\n"
				+ "    \"account_id\": \"acc_HQNb9tWZTJcm4b\",\r\n"
				+ "    \"event\": \"virtual_account.credited\",\r\n"
				+ "    \"contains\": [\r\n"
				+ "        \"payment\",\r\n"
				+ "        \"virtual_account\",\r\n"
				+ "        \"bank_transfer\"\r\n"
				+ "    ],\r\n"
				+ "    \"payload\": {\r\n"
				+ "        \"payment\": {\r\n"
				+ "            \"entity\": {\r\n"
				+ "                \"id\": \""+paymntId+"\",\r\n"
				+ "                \"entity\": \"payment\",\r\n"
				+ "                \"amount\": "+amt+",\r\n"
				+ "                \"currency\": \"INR\",\r\n"
				+ "                \"status\": \"captured\",\r\n"
				+ "                \"order_id\": null,\r\n"
				+ "                \"invoice_id\": null,\r\n"
				+ "                \"international\": false,\r\n"
				+ "                \"method\": \"bank_transfer\",\r\n"
				+ "                \"amount_refunded\": 0,\r\n"
				+ "                \"refund_status\": null,\r\n"
				+ "                \"captured\": true,\r\n"
				+ "                \"description\": \"\",\r\n"
				+ "                \"card_id\": null,\r\n"
				+ "                \"bank\": null,\r\n"
				+ "                \"wallet\": null,\r\n"
				+ "                \"vpa\": null,\r\n"
				+ "                \"email\": \"jswgeneric@gmail.com\",\r\n"
				+ "                \"contact\": null,\r\n"
				+ "                \"customer_id\": \"cust_qaFxin6dTtGEFr\",\r\n"
				+ "                \"notes\": [],\r\n"
				+ "                \"fee\": 5900,\r\n"
				+ "                \"tax\": 900,\r\n"
				+ "                \"error_code\": null,\r\n"
				+ "                \"error_description\": null,\r\n"
				+ "                \"error_source\": null,\r\n"
				+ "                \"error_step\": null,\r\n"
				+ "                \"error_reason\": null,\r\n"
				+ "                \"acquirer_data\": {},\r\n"
				+ "                \"created_at\": 1683623738\r\n"
				+ "            }\r\n"
				+ "        },\r\n"
				+ "        \"virtual_account\": {\r\n"
				+ "            \"entity\": {\r\n"
				+ "                \"id\": \"va_K3pavauP87006h\",\r\n"
				+ "                \"name\": \"JSW ONE PLATFORMS LIMITED\",\r\n"
				+ "                \"entity\": \"virtual_account\",\r\n"
				+ "                \"status\": \"active\",\r\n"
				+ "                \"description\": \"JSW TEST GENERIC VAN\",\r\n"
				+ "                \"amount_expected\": null,\r\n"
				+ "                \"notes\": [],\r\n"
				+ "                \"amount_paid\": 21659820878,\r\n"
				+ "                \"customer_id\": \"cust_qaFxin6dTtGEFr\",\r\n"
				+ "                \"close_by\": null,\r\n"
				+ "                \"closed_at\": null,\r\n"
				+ "                \"created_at\": 1660112851,\r\n"
				+ "                \"receivers\": [\r\n"
				+ "                    {\r\n"
				+ "                        \"id\": \"ba_K3pavn1bJMnR9Q\",\r\n"
				+ "                        \"entity\": \"bank_account\",\r\n"
				+ "                        \"ifsc\": \"RAZR0000001\",\r\n"
				+ "                        \"bank_name\": null,\r\n"
				+ "                        \"name\": \"JSW ONE PLATFORMS LIMITED\",\r\n"
				+ "                        \"notes\": [],\r\n"
				+ "                        \"account_number\": \"1112220057850296\"\r\n"
				+ "                    }\r\n"
				+ "                ]\r\n"
				+ "            }\r\n"
				+ "        },\r\n"
				+ "        \"bank_transfer\": {\r\n"
				+ "            \"entity\": {\r\n"
				+ "                \"id\": \"bt_LnVlHMlYU30rBQ\",\r\n"
				+ "                \"entity\": \"bank_transfer\",\r\n"
				+ "                \"payment_id\": \""+paymntId+"\",\r\n"
				+ "                \"mode\": \"NEFT\",\r\n"
				+ "                \"bank_reference\": \"168362372713\",\r\n"
				+ "                \"amount\": "+amt+"	,\r\n"
				+ "                \"payer_bank_account\": {\r\n"
				+ "                    \"id\": \"ba_LnVlHjh3XinfJl\",\r\n"
				+ "                    \"entity\": \"bank_account\",\r\n"
				+ "                    \"ifsc\": \"RBL0021\",\r\n"
				+ "                    \"bank_name\": null,\r\n"
				+ "                    \"name\": \"JSW ONE PLATFORMS LIMITED\",\r\n"
				+ "                    \"notes\": [],\r\n"
				+ "                    \"account_number\": \"312\"\r\n"
				+ "                },\r\n"
				+ "                \"virtual_account_id\": \"va_K3pavauP87006h\"\r\n"
				+ "            }\r\n"
				+ "        }\r\n"
				+ "    },\r\n"
				+ "    \"created_at\": 1683623738\r\n"
				+ "}";
	}

}
