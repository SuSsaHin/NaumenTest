package com.mygwt.mymvn.client.rpc;

import com.mygwt.mymvn.shared.PhoneRecord;

import net.customware.gwt.dispatch.shared.Result;

public class GetByIdResult implements Result
{
	private PhoneRecord record;
	public GetByIdResult()
	{
	}
	
	public GetByIdResult(PhoneRecord record)
	{
		this.record = record;
	}
	
	public PhoneRecord getRecord()
	{
		return record;
	}
}
