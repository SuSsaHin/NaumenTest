package com.mygwt.mymvn.client.rpc;

import com.mygwt.mymvn.shared.PhoneRecord;

import net.customware.gwt.dispatch.shared.Action;

public class DeleteAction implements Action<DeleteResult>
{
	private PhoneRecord deleted;

	public DeleteAction()
	{
	}

	public DeleteAction(final PhoneRecord deleted)
	{
		this.deleted = deleted;
	}

	public PhoneRecord getDeleted()
	{
		return deleted;
	}
}
