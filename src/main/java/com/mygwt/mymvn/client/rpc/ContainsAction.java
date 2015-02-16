package com.mygwt.mymvn.client.rpc;

import com.mygwt.mymvn.shared.PhoneRecord;

import net.customware.gwt.dispatch.shared.Action;

public class ContainsAction implements Action<ContainsResult>
{
	private PhoneRecord record;

	public ContainsAction()
	{
	}

	public ContainsAction(final PhoneRecord record)
	{
		this.record = record;
	}

	public PhoneRecord getRecord()
	{
		return record;
	}
}
