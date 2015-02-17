package com.mygwt.mymvn.client.rpc;

import net.customware.gwt.dispatch.shared.Action;

public class DeleteAction implements Action<DeleteResult>
{
	private long deletedId;

	public DeleteAction()
	{
	}

	public DeleteAction(final long deletedId)
	{
		this.deletedId = deletedId;
	}

	public long getDeletedId()
	{
		return deletedId;
	}
}
