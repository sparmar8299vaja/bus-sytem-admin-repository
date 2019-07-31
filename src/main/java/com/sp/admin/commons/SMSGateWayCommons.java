package com.sp.admin.commons;

public enum SMSGateWayCommons {
	URL("https://www.smsgatewayhub.com/api/mt/SendSMS?"),
	APIKEY("gBmel1M3j06cgHF6JsPxuQ"), SENDER_ID("SMSTST"),
	CHANNEL("1"),
	DCS("0"), 
	FLASHSMS("0"),
	ROUTE("1");

	private String value;

	private SMSGateWayCommons(final String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
