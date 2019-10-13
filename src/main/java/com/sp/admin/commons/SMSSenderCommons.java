package com.sp.admin.commons;


public class SMSSenderCommons {
    
	private SMSSenderCommons() {
		
	}
	
	public static String sendMessage(final String moNumber, final String message) {
		String url = SMSGateWayCommons.URL.getValue() + "APIKEY=" + SMSGateWayCommons.APIKEY.getValue() + "&channel="
				+ SMSGateWayCommons.CHANNEL.getValue() + "&DCS=" + SMSGateWayCommons.DCS.getValue() + "&flashsms="
				+ SMSGateWayCommons.FLASHSMS.getValue() + "&number=" + moNumber + "&text=" + message + "&route="
				+ SMSGateWayCommons.ROUTE.getValue() + "&senderid=" + SMSGateWayCommons.SENDER_ID.getValue();
		return TemplateCommons.getTemplate().getForObject(url, String.class);
	}
}
