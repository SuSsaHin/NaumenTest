package com.mygwt.mymvn.client.rpc;

import net.customware.gwt.dispatch.shared.Action;

public class GetByIdAction implements Action<GetByIdResult>
{
	private long id;

	public GetByIdAction()
	{
	}

	public GetByIdAction(final long id)
	{
		this.id = id;
	}

	public long getId()
	{
		return id;
	}
}
