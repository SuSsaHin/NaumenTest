package com.mygwt.mymvn.client.rpc;

import net.customware.gwt.dispatch.shared.Action;

public class SearchAction implements Action<SearchResult>
{

	private String namePart;

	public SearchAction()
	{
	}

	public SearchAction(final String namePart)
	{
		this.namePart = namePart;
	}

	public String getNamePart()
	{
		return namePart;
	}
}
