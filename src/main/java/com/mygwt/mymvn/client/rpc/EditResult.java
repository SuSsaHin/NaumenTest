package com.mygwt.mymvn.client.rpc;

import net.customware.gwt.dispatch.shared.Result;

public class EditResult implements Result
{
	boolean updated;
	
	public EditResult()
	{
	}
	
	public EditResult(boolean updated)
	{
		this.updated = updated;
	}
	
	public boolean isUpdated()
	{
		return updated;
	}
}
