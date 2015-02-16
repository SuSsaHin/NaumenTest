package com.mygwt.mymvn.client.rpc;

import net.customware.gwt.dispatch.shared.Result;

public class ContainsResult implements Result
{
	private boolean result;
	public ContainsResult()
	{
	}
	
	public ContainsResult(boolean result)
	{
		this.result = result;
	}
	
	public boolean getResult()
	{
		return result;
	}
}
