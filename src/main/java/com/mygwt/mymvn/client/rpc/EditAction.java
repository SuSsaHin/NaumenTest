package com.mygwt.mymvn.client.rpc;

import com.mygwt.mymvn.shared.PhoneRecord;

import net.customware.gwt.dispatch.shared.Action;

public class EditAction implements Action<EditResult>
{
	private long editedId;
	private PhoneRecord newRecord;

	public EditAction()
	{
	}

	public EditAction(final long editedId, final PhoneRecord newRecord)
	{
		this.editedId = editedId;
		this.newRecord = newRecord;
	}

	public long getEditedId()
	{
		return editedId;
	}
	
	public PhoneRecord getNewRecord()
	{
		return newRecord;
	}
}
