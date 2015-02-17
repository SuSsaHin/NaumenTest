package com.mygwt.mymvn.client.rpc;

import com.mygwt.mymvn.shared.PhoneRecord;

import net.customware.gwt.dispatch.shared.Action;

public class AddAction implements Action<AddResult>
{
	private PhoneRecord record;

	public AddAction()
	{
	}

	public AddAction(final PhoneRecord record)
	{
		this.record = record;
	}

	public PhoneRecord getRecord()
	{
		return record;
	}
}
