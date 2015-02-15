package com.mygwt.mymvn.client.rpc;

import net.customware.gwt.dispatch.shared.Result;

public class SendGreetingResult implements Result {
	private String resultMessage;
	
	public SendGreetingResult()
	{}

	public SendGreetingResult(String resultMessage)	{
		this.resultMessage = resultMessage;
	}
	
	public String getResultMessage() {
		return resultMessage;
	}
}
