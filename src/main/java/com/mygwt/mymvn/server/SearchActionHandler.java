package com.mygwt.mymvn.server;

import java.util.ArrayList;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import com.mygwt.mymvn.client.rpc.SearchAction;
import com.mygwt.mymvn.client.rpc.SearchResult;
import com.mygwt.mymvn.server.logic.TestRepository;
import com.mygwt.mymvn.shared.PhoneRecord;

public class SearchActionHandler implements ActionHandler<SearchAction, SearchResult>
{

	public SearchResult execute(SearchAction action, ExecutionContext context)
			throws ActionException
	{
		ArrayList<PhoneRecord> records = TestRepository.getInstance().get(
				action.getNamePart());
		return new SearchResult(records);
	}

	public Class<SearchAction> getActionType()
	{
		return SearchAction.class;
	}

	public void rollback(SearchAction action, SearchResult result,
			ExecutionContext context) throws ActionException
	{
	}
}