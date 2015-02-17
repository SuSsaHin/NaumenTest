package com.mygwt.mymvn.client.rpc;

import net.customware.gwt.dispatch.shared.Result;

public class AddResult implements Result
{
	private long  id;
	
	public AddResult()
	{
	}
	
	public AddResult(long id)
	{
		this.id = id;
	}
	
	public long getId()
	{
		return id;
	}
}
